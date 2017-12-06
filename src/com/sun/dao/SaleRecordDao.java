package com.sun.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.DeleteOptions;
import org.mongodb.morphia.aggregation.Accumulator;
import org.mongodb.morphia.aggregation.AggregationPipeline;
import org.mongodb.morphia.aggregation.Group;
import org.mongodb.morphia.aggregation.Projection;
import org.mongodb.morphia.aggregation.Sort;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.WriteResult;
import com.sun.util.MongoUtil;
import com.sun.vo.db.SaleRecord;
import com.sun.vo.transfer.SaleRecordQueryVO;

@Transactional
@Repository
public class SaleRecordDao{

	
	public boolean insert(SaleRecord saleRecord) {
		boolean result = true;
		Datastore dataStore = null;
		try {
			dataStore = MongoUtil.getMorphia();
			dataStore.save(saleRecord);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			
		}
        return result;
    }
	
	public boolean insertBatch(List<SaleRecord> productList) {
		boolean result = true;
		Datastore dataStore = null;
		try {
			dataStore = MongoUtil.getMorphia();
			dataStore.save(productList);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			
		}
		return result;
	}
	
	public List<SaleRecord> query() {
		List<SaleRecord> productList = new ArrayList<>();
		Datastore dataStore = MongoUtil.getMorphia();
		productList = dataStore.createQuery(SaleRecord.class).asList();
//		for (SaleRecord product : productList) {
//			WriteResult wr = dataStore.delete(product);
//		}
		return productList;
	}
	
	
	public boolean deleteAll() throws Exception{
		Datastore dataStore = MongoUtil.getMorphia();
		DeleteOptions delo = new DeleteOptions();
		WriteResult wr = dataStore.delete(SaleRecord.class, delo.getCollation());
		System.out.println("檢查刪除數量" + wr.getN());
        return ( wr.getN()>0 ? true :false );
    }
	
	public List<SaleRecord> queryTopAndLast(SaleRecordQueryVO queryVO) {
		// TODO
		List<SaleRecord> resultList = new ArrayList<>();
		try {
			
			Datastore dataStore = MongoUtil.getMorphia();
			Query<SaleRecord> query = dataStore.createQuery(SaleRecord.class)
					.filter("saleDate >= ", queryVO.getStartDate())
					.filter("saleDate <= ", queryVO.getEndDate());
//					.order("monthSale");
			
			AggregationPipeline pipeline = dataStore.createAggregation(SaleRecord.class)
					.match(query)
//					.project(Projection.projection(field, projectedField))
					.group( Group.id(
							Group.grouping("month", new Accumulator("$month", "date")) ,
							Group.grouping("year", new Accumulator("$year", "date")))
							, Group.grouping("monthSale", new Accumulator("$sum", "amount"))
							)
					;
			
			
//			AggregationPipeline pipeline = dataStore.createAggregation(SaleRecord.class)
//					.match(query)
//					.group( Group.id( Group.grouping("saleDate"))
//							, Group.grouping("monthSale", Group.sum("amount"))
//							)
//					;
			System.out.println(pipeline.toString());
			
			Iterator<SaleRecord> resltIterator = pipeline.aggregate(SaleRecord.class);
			while (resltIterator.hasNext()) {
				resultList.add(resltIterator.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
}

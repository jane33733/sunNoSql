package com.sun.dao;

import static org.mongodb.morphia.aggregation.Accumulator.accumulator;
import static org.mongodb.morphia.aggregation.Group.grouping;
import static org.mongodb.morphia.aggregation.Group.id;
import static org.mongodb.morphia.aggregation.Group.sum;
import static org.mongodb.morphia.query.Sort.ascending;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.aggregation.AggregationPipeline;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.mongodb.WriteResult;
import com.sun.util.MongoUtil;
import com.sun.vo.db.SaleRecord;
import com.sun.vo.transfer.MonthRptRsVO;
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
		final Query<SaleRecord> hadBuy = dataStore.createQuery(SaleRecord.class)
                .filter("amount >", 0);
		WriteResult wr = dataStore.delete(hadBuy);
		System.out.println("檢查刪除數量" + wr.getN());
        return ( wr.getN()>0 ? true :false );
    }
	
	
	
	public List<MonthRptRsVO> queryTopAndLast(SaleRecordQueryVO queryVO) {
		// TODO
		List<MonthRptRsVO> resultList = new ArrayList<>();
		try {
			
			Datastore dataStore = MongoUtil.getMorphia();
			
			AggregationPipeline pipeline = dataStore
		            .createAggregation(SaleRecord.class)
		            .group(
		            		id(grouping("pId"),
		            		   grouping("year", accumulator("$year", "saleDate")),
		            		   grouping("month", accumulator("$month", "saleDate")) )
		            		, grouping("total", sum("amount")) )
		            .sort(ascending("_id"));
			
			System.out.println(pipeline.toString());
			
			
			Iterator<MonthRptRsVO> resltIterator = pipeline.aggregate(MonthRptRsVO.class);
			while (resltIterator.hasNext()) {
				resultList.add(resltIterator.next());
			}
			Gson gson = new Gson();
			System.out.println("測試" + gson.toJson(resultList));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
}

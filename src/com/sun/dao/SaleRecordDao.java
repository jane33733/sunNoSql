package com.sun.dao;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.WriteResult;
import com.sun.util.MongoUtil;
import com.sun.vo.db.SaleRecord;

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
	
	
	public boolean delete(String pId) {
		Datastore dataStore = MongoUtil.getMorphia();
		WriteResult wr = dataStore.delete(SaleRecord.class, pId);
		System.out.println("檢查刪除數量" + wr.getN());
        return ( wr.getN()>0 ? true :false );
    }
	
	public List<SaleRecord> queryTopAndLast() {
		// TODO
		List<SaleRecord> productList = new ArrayList<>();
		Datastore dataStore = MongoUtil.getMorphia();
		productList = dataStore.createQuery(SaleRecord.class).asList();
//		for (SaleRecord product : productList) {
//			WriteResult wr = dataStore.delete(product);
//		}
		return productList;
	}
	
}

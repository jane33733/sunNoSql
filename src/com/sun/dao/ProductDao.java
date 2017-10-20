package com.sun.dao;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.WriteResult;
import com.sun.util.MongoUtil;
import com.sun.vo.db.Product;

@Transactional
@Repository
public class ProductDao{

	
	public boolean insert(Product product) {
		boolean result = true;
		Datastore dataStore = null;
		try {
			dataStore = MongoUtil.getMorphia();
			dataStore.save(product);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			
		}
        return result;
    }
	
	public List<Product> query() {
		List<Product> productList = new ArrayList<>();
		Datastore dataStore = MongoUtil.getMorphia();
		productList = dataStore.createQuery(Product.class).asList();
//		for (Product product : productList) {
//			WriteResult wr = dataStore.delete(product);
//		}
		return productList;
	}
	
	
	public boolean delete(String pId) {
		Datastore dataStore = MongoUtil.getMorphia();
		WriteResult wr = dataStore.delete(Product.class, pId);
		System.out.println("檢查刪除數量" + wr.getN());
        return ( wr.getN()>0 ? true :false );
    }
	
	
}

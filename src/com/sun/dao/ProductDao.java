package com.sun.dao;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sun.vo.db.Product;

@Transactional
@Repository
public class ProductDao extends BaseDao{

	
	public List<Product> insert(Product product) {
		Datastore dataStore = super.getMorphia();
		dataStore.save(product);
		
		List<Product> productList = new ArrayList<>();
		productList = dataStore.createQuery(Product.class).asList();
		
//		MongoDatabase md = super.getConnection();
//		MongoCollection<Document> table = md.getCollection(Product.class.getSimpleName());
//		BasicDBObject document = new BasicDBObject("x", 1);
//		table.insertOne(product);
		

        
        
        return productList;

    }
	
	public List<Product> query() {
		List<Product> productList =  new ArrayList<>();
		
		return productList;
		
	}
	
}

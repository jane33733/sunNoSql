package com.sun.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public abstract class BaseDao {
	
    @Autowired
    protected SessionFactory sessionFactory;
    
    public MongoDatabase getConnection() {

        MongoClientURI uri  = new MongoClientURI("mongodb://user:pass@host:port/db"); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
    	
//    	MongoClient client = new MongoClient( "localhost" , 27017 );
//    	MongoDatabase db = client.getDatabase("database name");
//    	boolean auth = db.authenticate("username", "password".toCharArray());
    	return db;
    }
    

}

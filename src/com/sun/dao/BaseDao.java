package com.sun.dao;

import org.hibernate.SessionFactory;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public abstract class BaseDao {
	
    @Autowired
    protected SessionFactory sessionFactory;
    
    public MongoDatabase getConnection() {

//      MongoClientURI uri  = new MongoClientURI("mongodb://user:pass@host:port/db"); 
        MongoClientURI uri  = new MongoClientURI("mongodb://user:pass@host:port/db"); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
    	
//    	MongoClient client = new MongoClient( "localhost" , 27017 );
//    	MongoDatabase db = client.getDatabase("database name");
//    	boolean auth = db.authenticate("username", "password".toCharArray());
    	return db;
    }
    
    public Datastore getMorphia() {
    	Morphia morphia = new Morphia();
    	MongoClientURI uri  = new MongoClientURI("mongodb://sysAdmin01:123456@localhost:27017/newbornProject"); 
    	MongoClient client = new MongoClient(uri);
//    	MongoDatabase db = client.getDatabase(uri.getDatabase());
    	
    	morphia.mapPackage("com.sun.vo.db");

    	// create the Datastore connecting to the default port on the local host
    	final Datastore datastore = morphia.createDatastore(client, uri.getDatabase());
    	datastore.ensureIndexes();
    	return datastore;
    }
    

}

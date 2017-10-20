package com.sun.util;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.sun.vo.common.MongoSetting;

public class MongoUtil {

	private final static String MAPPING_PACKAGE = "com.sun.vo.db";
	private static MongoSetting setting;
	
    
    public static Datastore getMorphia() {
    	if (setting == null) {
    		setting = MongoSetting.initialSetting();
		}
    	
    	StringBuilder dbSetting = new StringBuilder();
    	dbSetting.append("mongodb://");
    	dbSetting.append(setting.getUser());
    	dbSetting.append(":");
    	dbSetting.append(setting.getPassword());
    	dbSetting.append("@");
    	dbSetting.append(setting.getHost());
    	dbSetting.append(":");
    	dbSetting.append(setting.getPort());
    	dbSetting.append("/");
    	dbSetting.append(setting.getDbName());
    	System.out.println(dbSetting.toString());

    	Morphia morphia = new Morphia();
//    	MongoClientURI uri  = new MongoClientURI("mongodb://sysAdmin01:123456@localhost:27017/newbornProject"); 
    	MongoClientURI uri  = new MongoClientURI(dbSetting.toString()); 
    	MongoClient client = new MongoClient(uri);
    	
    	morphia.mapPackage(MAPPING_PACKAGE);

    	// create the Datastore connecting to the default port on the local host
    	final Datastore datastore = morphia.createDatastore(client, uri.getDatabase());
    	datastore.ensureIndexes();
    	return datastore;
    }
    

	
    
}

package com.sun.vo.common;

import java.io.InputStream;
import java.util.Properties;

public class MongoSetting {

	private String user;
	private String password;
	private String host;
	private String port;
	private String dbName;
	
	public static MongoSetting initialSetting() {
		Properties properties = new Properties();
		MongoSetting ms = new MongoSetting();
		try {
			
			ClassLoader loader = Thread.currentThread().getContextClassLoader();   
			InputStream stream = loader.getResourceAsStream("db.properties");        
			properties.load(stream);
			
			ms.setUser(properties.getProperty("mongoDB.user"));
			ms.setPassword(properties.getProperty("mongoDB.password"));
			ms.setHost(properties.getProperty("mongoDB.host"));
			ms.setPort(properties.getProperty("mongoDB.port"));
			ms.setDbName(properties.getProperty("mongoDB.db"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ms;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}

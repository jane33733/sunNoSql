package com.sun.vo.db;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("employees")
public class Product {

	@Id
	private ObjectId pId;
	
	private String name;
	
	@Property("wage")
	private BigDecimal price;
	
	public ObjectId getpId() {
		return pId;
	}
	public void setpId(ObjectId pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}

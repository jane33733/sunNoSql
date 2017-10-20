package com.sun.vo.db;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("Product")
public class Product {

	@Id
	private String pId;
	
	@Property("name")
	private String name;
	
	@Property("price")
	private BigDecimal price;
	
	@Property("createTime")
	private LocalDateTime createTime;
	
	
	
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
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
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	
}

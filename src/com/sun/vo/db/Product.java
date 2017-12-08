package com.sun.vo.db;

import java.math.BigDecimal;
import java.util.Date;

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
	private Date createTime;
	
	
	public static Product create(String id, String name, int price) {
		Product p = new Product();
		p.setpId(id);
		p.setName(name);
		p.setPrice(new BigDecimal(price));
		p.setCreateTime(new Date());
		return p;
	}
	
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}

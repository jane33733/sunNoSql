package com.sun.respose.vo;

import java.math.BigDecimal;
import java.util.Date;


public class ProductInfoVO {

	private String id;
	private String name;
	private BigDecimal price;
	private Date createTime;

	public ProductInfoVO(){}
	public ProductInfoVO( String id, String name, BigDecimal price, Date createTime ){
		this.id = id;
		this.name = name;
		this.price = price;
		this.createTime = createTime;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

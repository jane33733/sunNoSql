package com.sun.vo.db;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("SaleRecord")
public class SaleRecord {

	@Id
	private String srId;
	
	@Property("pId")
	private String pId;
	
	@Property("amount")
	private int amount;
	
	@Property("saleDate")
	private Date saleDate;
	// mongo db don't support LocalDate, should use util.Date
	
	
	public static SaleRecord create(String srId, String pId, int amount, Date saleDate ) {
		SaleRecord sr = new SaleRecord();
		sr.setSrId(srId);
		sr.setpId(pId);
		sr.setAmount(amount);
		sr.setSaleDate(saleDate);
		return sr;
	}


	public String getSrId() {
		return srId;
	}


	public void setSrId(String srId) {
		this.srId = srId;
	}


	public String getpId() {
		return pId;
	}


	public void setpId(String pId) {
		this.pId = pId;
	}

	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Date getSaleDate() {
		return saleDate;
	}


	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	
}

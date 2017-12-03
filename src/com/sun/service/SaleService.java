package com.sun.service;

import java.util.List;

import com.sun.vo.db.SaleRecord;


public interface SaleService {
	
	boolean addSale(final SaleRecord sale);
	
	boolean addSaleList(final List<SaleRecord> saleList);
	
	boolean randomAddSale();
	
	String deleteSale(final String srId);
	
}

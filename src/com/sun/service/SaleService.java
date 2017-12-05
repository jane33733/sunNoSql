package com.sun.service;

import java.util.List;

import com.sun.vo.db.SaleRecord;
import com.sun.vo.transfer.SaleRecordQueryVO;


public interface SaleService {
	
	public List<SaleRecord> queryTopAndLast(SaleRecordQueryVO queryVO);
	
	boolean addSaleList(final List<SaleRecord> saleList);
	
	boolean randomAddSale();
	
	String deleteSale(final String srId);
	
}

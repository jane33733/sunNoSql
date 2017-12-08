package com.sun.service;

import java.util.List;

import com.sun.vo.db.SaleRecord;
import com.sun.vo.output.SaleRecordReportInfoVO;
import com.sun.vo.transfer.SaleRecordQueryVO;


public interface SaleRecordService {
	
	public List<SaleRecordReportInfoVO> queryTopAndLast(SaleRecordQueryVO queryVO);
	
	boolean addSaleList(final List<SaleRecord> saleList);
	
	boolean randomAddSale();
	
	boolean deleteAllSale();
	
}

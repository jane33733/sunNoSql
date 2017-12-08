package com.sun.vo.transfer;

import org.mongodb.morphia.annotations.Id;

import com.sun.vo.transfer.SrReportIdVO;

public class MonthRptRsVO {

	@Id
	private SrReportIdVO srReportId;
	private int total;
	
	public SrReportIdVO getSrReportId() {
		return srReportId;
	}
	public void setSrReportId(SrReportIdVO srReportId) {
		this.srReportId = srReportId;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}

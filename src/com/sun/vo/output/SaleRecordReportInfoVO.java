package com.sun.vo.output;

import java.util.List;

public class SaleRecordReportInfoVO {

	private String pId;
	private String pName;
	private List<String> dateList;
	private List<Integer> totalList;
	
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public List<String> getDateList() {
		return dateList;
	}
	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}
	public List<Integer> getTotalList() {
		return totalList;
	}
	public void setTotalList(List<Integer> totalList) {
		this.totalList = totalList;
	}
	
}

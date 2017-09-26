package com.sun.respose.vo;

import com.sun.entity.BaseEntity;

public class LoginInfoVO extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4186533726655407069L;
	
	private Boolean isExist;
	private String accountId;
	private String account;
	private String userId;
	private String userName;
	
	
	public Boolean getIsExist() {
		return isExist;
	}
	public void setIsExist(Boolean isExist) {
		this.isExist = isExist;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}

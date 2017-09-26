package com.sun.request.vo;

import javax.servlet.http.HttpServletRequest;

import com.sun.common.vo.VOBuilder;
import com.sun.entity.BaseEntity;

public class LoginVO extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1050753529291057610L;
	
	private String account;
	private String password;

	public LoginVO() {
		/* for spring init. */}

	@SuppressWarnings(value={"unchecked"})
	public static class Builder<T extends LoginVO> implements VOBuilder {
		private String account;
		private String password;

		public Builder account(String account) {
			this.account = account;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public T build() {
			return (T) new LoginVO(this);
		}
	}

	public LoginVO(Builder builder) {
		this.account = builder.account;
		this.password = builder.password;
	}

	public static final LoginVO getInstance(HttpServletRequest request) {
		return new LoginVO.Builder()
				.account(request.getParameter("account"))
				.password(request.getParameter("password"))
				.build();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

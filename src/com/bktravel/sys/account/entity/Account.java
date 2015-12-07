package com.bktravel.sys.account.entity;

import com.bkweb.common.entity.DataEntity;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account extends DataEntity<Account> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String loginFlag;
	private boolean isAdmin;

	// Constructors

	/** default constructor */
	public Account() {
	}

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Account(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public boolean isAdmin() {
		if ("admin".equals(username)) {
			return true;
		}
		return false;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
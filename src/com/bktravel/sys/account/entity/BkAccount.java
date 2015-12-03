package com.bktravel.sys.account.entity;

import com.bkweb.common.entity.DataEntity;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class BkAccount extends DataEntity<BkAccount> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public BkAccount() {
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

}
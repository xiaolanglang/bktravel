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
	private String passowrd;

	// Constructors

	/** default constructor */
	public BkAccount() {
	}

	/** minimal constructor */
	public BkAccount(String username, String passowrd) {
		this.username = username;
		this.passowrd = passowrd;
	}

	public BkAccount(String id, String username, String passowrd) {
		super();
		this.id = id;
		this.username = username;
		this.passowrd = passowrd;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassowrd() {
		return this.passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

}
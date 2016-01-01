package com.bktravel.sys.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

import com.bkweb.common.entity.DataEntity;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "bk_account")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Account extends DataEntity<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	// private String loginFlag;

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

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// public String getLoginFlag() {
	// return loginFlag;
	// }
	//
	// public void setLoginFlag(String loginFlag) {
	// this.loginFlag = loginFlag;
	// }

	// public boolean isAdmin() {
	// if ("admin".equals(username)) {
	// return true;
	// }
	// return false;
	// }

}
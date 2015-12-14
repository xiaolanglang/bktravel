package com.bktravel.sys.authority.entity;

import com.bktravel.sys.account.entity.Account;
import com.bkweb.common.entity.DataEntity;

/**
 * SysAccountRole entity. @author MyEclipse Persistence Tools
 */

public class AccountRole extends DataEntity<AccountRole> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Role role;
	private Account account;

	// Constructors

	/** default constructor */
	public AccountRole() {
	}

	public AccountRole(Account account, Role role) {
		this.account = account;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
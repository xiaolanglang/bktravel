package com.bktravel.sys.authority.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

import com.bktravel.sys.account.entity.Account;
import com.bkweb.common.entity.DataEntity;

/**
 * SysAccountRole entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "sys_account_role")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
package com.bktravel.sys.user.entity;

import java.util.Date;

import javax.persistence.Column;
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
 * User entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "bk_userinfo")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends DataEntity<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account;
	private String name;
	private String sex;
	private Integer age;
	private Date birthday;
	private String card;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String sex, Integer age, Date birthday, String card) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.card = card;
	}

	/** full constructor */
	public User(Account account, String name, String sex, Integer age, Date birthday, String card) {
		this.account = account;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.card = card;
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountId")
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex", nullable = false, length = 20)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "age", nullable = false, length = 20)
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "birthday", nullable = false, length = 20)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "card", nullable = false, length = 20)
	public String getCard() {
		return this.card;
	}

	public void setCard(String card) {
		this.card = card;
	}

}
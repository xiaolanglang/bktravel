package com.bktravel.modules.user.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.bktravel.sys.account.entity.BkAccount;
import com.bkweb.common.entity.DataEntity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class BkUser extends DataEntity<BkUser> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BkAccount account;
	private String name;
	private String sex;
	private Integer age;
	private Date birthday;
	private String card;
	
	

	// Constructors

	/** default constructor */
	public BkUser() {
	}

	/** minimal constructor */
	public BkUser(String name, String sex, Integer age, Date birthday, String card) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.card = card;
	}

	/** full constructor */
	public BkUser(BkAccount account, String name, String sex, Integer age, Date birthday, String card) {
		this.account = account;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.card = card;
	}

	// Property accessors

	public BkAccount getAccount() {
		return this.account;
	}

	public void setAccount(BkAccount account) {
		this.account = account;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCard() {
		return this.card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
package com.bktravel.sys.authority.entity;

import com.bkweb.common.entity.DataEntity;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class Role extends DataEntity<Role> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	// Constructors

	/** default constructor */
	public Role() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
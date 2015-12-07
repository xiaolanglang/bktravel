package com.bktravel.sys.purview.entity;

import com.bkweb.common.entity.DataEntity;

/**
 * SysAuthority entity. @author MyEclipse Persistence Tools
 */

public class Permissions extends DataEntity<Permissions> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String permission;

	// Constructors

	/** default constructor */
	public Permissions() {
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
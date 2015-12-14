package com.bktravel.sys.authority.entity;

import com.bkweb.common.entity.DataEntity;

/**
 * SysRoleAuth entity. @author MyEclipse Persistence Tools
 */

public class RolePermission extends DataEntity<RolePermission> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Role role;
	private Permissions permissions;

	// Constructors

	/** default constructor */
	public RolePermission() {
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permissions getPermissions() {
		return permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}

}
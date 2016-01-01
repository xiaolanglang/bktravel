package com.bktravel.sys.authority.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

import com.bkweb.common.entity.DataEntity;

/**
 * SysRoleAuth entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "sys_role_permission")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "per_id", nullable = false)
	public Permissions getPermissions() {
		return permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}

}
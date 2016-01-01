package com.bktravel.sys.authority.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

import com.bkweb.common.entity.DataEntity;

/**
 * SysAuthority entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "sys_permission")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Permissions extends DataEntity<Permissions> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String permission;
	private String name;

	// Constructors

	/** default constructor */
	public Permissions() {
	}

	@Column(name = "permission", length = 20)
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
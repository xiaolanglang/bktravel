package com.bktravel.sys.role.entity;

import org.hibernate.validator.constraints.Length;

import com.bktravel.sys.account.entity.Account;
import com.bkweb.common.entity.DataEntity;

/**
 * 角色Entity
 * 
 * @author ThinkGem
 * @version 2013-12-05
 */
public class Role extends DataEntity<Role> {

	private static final long serialVersionUID = 1L;
	private String name; // 角色名称
	private String enname; // 英文名称
	private String roleType;// 权限类型
	private String dataScope;// 数据范围

	private String oldName; // 原角色名称
	private String oldEnname; // 原英文名称
	private String sysData; // 是否是系统数据
	private String useable; // 是否是可用

	private Account account; // 根据用户ID查询角色列表

	// 数据范围（1：所有数据；2：所在公司及以下数据；3：所在公司数据；4：所在部门及以下数据；5：所在部门数据；8：仅本人数据；9：按明细设置）
	public static final String DATA_SCOPE_ALL = "1";
	public static final String DATA_SCOPE_COMPANY_AND_CHILD = "2";
	public static final String DATA_SCOPE_COMPANY = "3";
	public static final String DATA_SCOPE_OFFICE_AND_CHILD = "4";
	public static final String DATA_SCOPE_OFFICE = "5";
	public static final String DATA_SCOPE_SELF = "8";
	public static final String DATA_SCOPE_CUSTOM = "9";

	public Role() {
		super();
		this.dataScope = DATA_SCOPE_SELF;
	}

	public Role(String id) {
		super();
		this.id = id;
	}

	public Role(Account account) {
		this();
		this.account = account;
	}

	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}

	public String getSysData() {
		return sysData;
	}

	public void setSysData(String sysData) {
		this.sysData = sysData;
	}

	@Length(min = 1, max = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min = 1, max = 100)
	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	@Length(min = 1, max = 100)
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDataScope() {
		return dataScope;
	}

	public void setDataScope(String dataScope) {
		this.dataScope = dataScope;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getOldEnname() {
		return oldEnname;
	}

	public void setOldEnname(String oldEnname) {
		this.oldEnname = oldEnname;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}

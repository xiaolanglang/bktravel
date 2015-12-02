package com.bkweb.common.entity;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.bkweb.sys.account.entity.BkAccount;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 数据Entity类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
@JsonIgnoreProperties(value = { "createBy", "updateBy" })
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;

	protected String remarks; // 备注
	protected BkAccount createBy; // 创建者
	protected Date createDate; // 创建日期
	protected BkAccount updateBy; // 更新者
	protected Date updateDate; // 更新日期
	protected String delFlag; // 删除标记（0：正常；1：删除）

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@JsonIgnore
	public BkAccount getCreateBy() {
		return createBy;
	}

	public void setCreateBy(BkAccount createBy) {
		this.createBy = createBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@JsonIgnore
	public BkAccount getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(BkAccount updateBy) {
		this.updateBy = updateBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@JsonIgnore
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}

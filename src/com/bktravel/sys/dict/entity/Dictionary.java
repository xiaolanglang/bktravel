package com.bktravel.sys.dict.entity;

import com.bkweb.common.entity.DataEntity;

/**
 * 字典Entity
 * 
 * @author administrator
 * @version 2013-05-15
 */
public class Dictionary extends DataEntity<Dictionary> {

	private static final long serialVersionUID = 1L;
	private String value; // 数据值
	private String label; // 标签名
	private String type; // 类型
	private String description;// 描述

	// private Integer sort; // 排序
	// private String parentId;// 父Id
	// private String tableName;// 父主题对应的表名

	public Dictionary() {
	}

	public Dictionary(String value, String label) {
		this.value = value;
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
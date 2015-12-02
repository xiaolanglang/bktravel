/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bkweb.common.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.bkweb.common.dao.interfaces.IEnableEntity;

/**
 * Entity支持类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class BaseEntity<T> implements Serializable, IEnableEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 实体编号（唯一标识）
	 */
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

package com.bkweb.modules.position.entity;

import com.bkweb.common.entity.DataEntity;

public class PositionEntity<E> extends DataEntity<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String name;
	protected String nameEn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

}

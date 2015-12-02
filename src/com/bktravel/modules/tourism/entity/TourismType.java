package com.bktravel.modules.tourism.entity;

import com.bkweb.common.entity.DataEntity;

/**
 * TourismTypes entity. @author MyEclipse Persistence Tools
 */

public class TourismType extends DataEntity<TourismType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String nameEn;

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
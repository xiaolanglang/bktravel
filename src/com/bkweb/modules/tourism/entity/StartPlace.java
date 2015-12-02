package com.bkweb.modules.tourism.entity;

import com.bkweb.common.entity.DataEntity;
import com.bkweb.modules.position.entity.City;

/**
 * StartPlace entity. @author MyEclipse Persistence Tools
 */

public class StartPlace extends DataEntity<StartPlace> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private City city;
	private String name;

	private String nameEn;

	// Constructors

	/** default constructor */
	public StartPlace() {
	}

	/** full constructor */
	public StartPlace(City city) {
		this.city = city;
	}

	// Property accessors

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

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
package com.bktravel.modules.position.entity;

/**
 * Country entity. @author MyEclipse Persistence Tools
 */

public class Country extends PositionEntity<Country> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private City city;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
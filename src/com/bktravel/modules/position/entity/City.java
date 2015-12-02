package com.bktravel.modules.position.entity;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City extends PositionEntity<City> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Province province;

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}
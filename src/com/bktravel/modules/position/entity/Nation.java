package com.bktravel.modules.position.entity;

/**
 * Nation entity. @author MyEclipse Persistence Tools
 */

public class Nation extends PositionEntity<Nation> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Continent continent;

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

}
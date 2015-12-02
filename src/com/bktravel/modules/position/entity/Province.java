package com.bktravel.modules.position.entity;


/**
 * Province entity. @author MyEclipse Persistence Tools
 */

public class Province extends PositionEntity<Province> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Nation nation;

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

}
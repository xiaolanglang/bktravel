package com.bkweb.modules.tourism.entity;

import com.bkweb.common.entity.DataEntity;
import com.bkweb.modules.attraction.entity.Attraction;

/**
 * TourismDetail entity. @author MyEclipse Persistence Tools
 */

public class TourismDetail extends DataEntity<TourismDetail> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tourism tourism;
	private Attraction attractions;
	private Integer day;
	private Integer serialNumber;

	// Constructors

	/** default constructor */
	public TourismDetail() {
	}

	/** full constructor */
	public TourismDetail(Tourism tourism, Attraction attractions, Integer day, Integer serialNumber) {
		this.tourism = tourism;
		this.attractions = attractions;
		this.day = day;
		this.serialNumber = serialNumber;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Tourism getTourism() {
		return this.tourism;
	}

	public void setTourism(Tourism tourism) {
		this.tourism = tourism;
	}

	public Attraction getAttractions() {
		return this.attractions;
	}

	public void setAttractions(Attraction attractions) {
		this.attractions = attractions;
	}

	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

}
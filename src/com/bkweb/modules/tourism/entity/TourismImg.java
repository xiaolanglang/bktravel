package com.bkweb.modules.tourism.entity;

import com.bkweb.common.entity.DataEntity;

/**
 * TourismImg entity. @author MyEclipse Persistence Tools
 */

public class TourismImg extends DataEntity<TourismImg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tourism tourism;
	private String url;
	private String name;
	private Double size;

	// Constructors

	/** default constructor */
	public TourismImg() {
	}

	/** full constructor */
	public TourismImg(Tourism tourism, String url) {
		this.tourism = tourism;
		this.url = url;
	}

	// Property accessors

	public Tourism getTourism() {
		return this.tourism;
	}

	public void setTourism(Tourism tourism) {
		this.tourism = tourism;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

}
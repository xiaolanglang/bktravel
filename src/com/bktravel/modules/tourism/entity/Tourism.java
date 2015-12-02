package com.bktravel.modules.tourism.entity;

import com.bkweb.common.entity.DataEntity;

/**
 * Tourism entity. @author MyEclipse Persistence Tools
 */

public class Tourism extends DataEntity<Tourism> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String hide;
	private String type;// 类型
	private String[] theme;
	private String themes;
	private Double adultPrice;
	private Double childrenPrice;
	private Double adultOriginalPrice;
	private Double childrenOriginalPrice;
	private Double discount;
	private Integer days;
	private String subtitle;
	private String[] startPlace;
	private String startPlaces;
	private String recommend;
	private String[] status;// 状态
	private String statuses;

	// Constructors

	/** default constructor */
	public Tourism() {
	}

	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}

	public String getStatuses() {
		return statuses;
	}

	public void setStatuses(String statuses) {
		this.statuses = statuses;
	}

	public String[] getStatus() {
		return status;
	}

	public void setStatus(String[] status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHide() {
		return this.hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getTheme() {
		return this.theme;
	}

	public void setTheme(String[] theme) {
		this.theme = theme;
	}

	public Double getAdultPrice() {
		return this.adultPrice;
	}

	public void setAdultPrice(Double adultPrice) {
		this.adultPrice = adultPrice;
	}

	public Double getChildrenPrice() {
		return this.childrenPrice;
	}

	public void setChildrenPrice(Double childrenPrice) {
		this.childrenPrice = childrenPrice;
	}

	public Double getAdultOriginalPrice() {
		return this.adultOriginalPrice;
	}

	public void setAdultOriginalPrice(Double adultOriginalPrice) {
		this.adultOriginalPrice = adultOriginalPrice;
	}

	public Double getChildrenOriginalPrice() {
		return this.childrenOriginalPrice;
	}

	public void setChildrenOriginalPrice(Double childrenOriginalPrice) {
		this.childrenOriginalPrice = childrenOriginalPrice;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String[] getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String[] startPlace) {
		this.startPlace = startPlace;
	}

	public String getStartPlaces() {
		return startPlaces;
	}

	public void setStartPlaces(String startPlaces) {
		this.startPlaces = startPlaces;
	}

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

}
package com.bktravel.modules.attraction.entity;

import com.bktravel.modules.position.entity.City;
import com.bktravel.modules.position.entity.Country;
import com.bkweb.common.entity.DataEntity;

/**
 * Attractions entity. @author MyEclipse Persistence Tools
 */

public class Attraction extends DataEntity<Attraction> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private City city;
	private Country country;
	private String name;
	private String hide;
	private String forPeople;
	private String type;
	private String place;
	private String imgUrl;
	private String title;

	// Constructors

	/** default constructor */
	public Attraction() {
	}

	/** full constructor */
	public Attraction(City city, Country country, String name, String hide, String forPeople, String type,
			String place, String imgUrl, String title) {
		this.city = city;
		this.country = country;
		this.name = name;
		this.hide = hide;
		this.forPeople = forPeople;
		this.type = type;
		this.place = place;
		this.imgUrl = imgUrl;
		this.title = title;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHide() {
		return this.hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	public String getForPeople() {
		return this.forPeople;
	}

	public void setForPeople(String forPeople) {
		this.forPeople = forPeople;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
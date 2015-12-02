package com.bkweb.common.json;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Title implements Comparable<Title>{

	private String value;
	private String title;
	private Integer sort;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public int compareTo(Title arg0) {
        return this.getSort().compareTo(arg0.getSort());
    }
	
	public String toString()
	{
		return value+":"+title;
	}
}

package com.bkweb.common.utils.hibernatepage;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.bkweb.common.config.Global;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class HPage<T> {
	/**
	 * 当前页数
	 */
	private int pageNum;

	/**
	 * 每页大小
	 */
	private int pageSize;

	/**
	 * 总页数
	 */
	private int pages;

	/**
	 * 总条数
	 */
	@JsonIgnore
	private Long count;

	/**
	 * 查询数据
	 */
	private List<T> list;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public HPage(Integer pageNum) {
		if (pageNum == null) {
			pageNum = 0;
		}
		this.pageNum = pageNum;
		this.pageSize = Global.getPageSize();

	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void init(HPage<T> page, Criteria criteria) {
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.count("id"));
		criteria.setProjection(projList);
		Long count = (Long) criteria.uniqueResult();// 查询获得数据总条数
		page.setCount(count);
		int pageSize = page.getPageSize();// 获得一页的数量
		page.setPages(count.intValue() / pageSize + 1);// 获得总页数
		criteria.setProjection(null).setFirstResult((page.getPageNum() - 1) * page.getPageSize())
				.setMaxResults(page.getPageSize());
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

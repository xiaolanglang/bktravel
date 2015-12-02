package com.bkweb.common.utils;

import java.io.Serializable;
import java.util.List;

import com.bkweb.common.config.Global;
import com.bkweb.common.json.Title;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageHelper;

/**
 * 自定义分页对象
 * @author yourName
 * @version 2015-6-18
 */
public class Page<E> implements Serializable{

	private static final long serialVersionUID = 1L;


	private com.github.pagehelper.Page<E> page;
	
	/**
	 * 自定义表头
	 */
	private List<Title> titleList;

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
	 * 记录总数
	 */
	private long totalCount;
	
	public List<Title> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<Title> titleList) {
		this.titleList = titleList;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	@JsonIgnore
	public com.github.pagehelper.Page<E> getPage() {
		return page;
	}

	public void setPage(com.github.pagehelper.Page<E> page) {
		this.page = page;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Page()
	{
		this.pageSize=Global.getPageSize();
	}

	public Page(int pageNum)
	{
		this.pageSize=Global.getPageSize();
		this.pageNum=pageNum;
	}

	/**
	 * 开始分页
	 */
	@SuppressWarnings("unchecked")
	public void start()
	{
		page=PageHelper.startPage(pageNum, pageSize, true);
	}

	public void end()
	{
		this.totalCount=page.getTotal();
		this.pages=page.getPages();
	}
}

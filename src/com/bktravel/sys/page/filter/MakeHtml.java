package com.bktravel.sys.page.filter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.bkweb.common.httpservlet.MyHttpServletResponseWrapper;
import com.bkweb.common.utils.FileUtils;

public class MakeHtml implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		String filePath = "C:\\Users\\Administrator\\Desktop\\2.jsp";
		FileUtils.createFile(filePath);
		File file = new File(filePath);
		FileOutputStream outputStream = new FileOutputStream(file, true);

		HttpServletResponse response = (HttpServletResponse) res;

		MyHttpServletResponseWrapper wrapper = new MyHttpServletResponseWrapper(response);
		chain.doFilter(req, wrapper);

		byte[] jsp = "<%@ page language=\"java\" import=\"java.util.*\" pageEncoding=\"UTF-8\"%>".getBytes();
		byte[] bs = wrapper.getResponseData();
		outputStream.write(jsp, 0, jsp.length);
		outputStream.write(bs, 0, bs.length);
		outputStream.flush();
		outputStream.close();

		response.sendRedirect("http://www.baidu.com");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

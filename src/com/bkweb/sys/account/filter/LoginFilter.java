package com.bkweb.sys.account.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bkweb.sys.account.entity.BkAccount;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("====================================销毁过滤器");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		System.out.println("====================================执行过滤方法，放行之前");
		System.out.println("执行登录过滤器");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		BkAccount account = (BkAccount) session.getAttribute("account");
		if (account == null) {
			String url = request.getRequestURI();
			if (url.endsWith("/login") || url.endsWith("/index.jsp") || url.endsWith("/regForm")
					|| url.endsWith("/reg")) {
				// 没有登录，但是正在尝试登录，放行
				System.out.println("放行");
				chain.doFilter(req, res);
			} else {
				System.out.println("拦截");
				String path = ((HttpServletRequest) request).getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
						+ path + "/";
				HttpServletResponse response = (HttpServletResponse) res;
				response.sendRedirect(basePath + "login");
			}
		} else {
			System.out.println("登录了");
			chain.doFilter(req, res);
		}
		System.out.println("====================================执行过滤方法，放行之后");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("====================================初始化过滤器");
	}

}

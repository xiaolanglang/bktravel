package com.bktravel.sys.log.util;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.method.HandlerMethod;

import com.bktravel.common.utils.AccountUtils;
import com.bktravel.sys.account.entity.Account;
import com.bktravel.sys.log.dao.LogDao;
import com.bktravel.sys.log.entity.Log;
import com.bkweb.common.utils.Exceptions;
import com.bkweb.common.utils.SpringContextHolder;
import com.bkweb.common.utils.StringUtils;

/**
 * 日志工具类
 * 
 * @author ThinkGem
 * @version 2014-11-7
 */
public class LogUtils {

	public static final String CACHE_MENU_NAME_PATH_MAP = "menuNamePathMap";

	private static LogDao logDao = SpringContextHolder.getBean(LogDao.class);

	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, String title) {
		saveLog(request, null, null, title);
	}

	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title) {
		Account account = AccountUtils.getAccount();
		if (account != null && account.getId() != null) {
			Log log = new Log();
			log.setTitle(title);
			log.setType(ex == null ? Log.TYPE_ACCESS : Log.TYPE_EXCEPTION);
			log.setRemoteAddr(StringUtils.getRemoteAddr(request));
			log.setUserAgent(request.getHeader("user-agent"));
			log.setRequestUri(request.getRequestURI());
			log.setParams(request.getParameterMap());
			log.setMethod(request.getMethod());
			// 异步保存日志
			new SaveLogThread(log, handler, ex).start();
		}
	}

	/**
	 * 保存日志线程
	 */
	public static class SaveLogThread extends Thread {

		private Log log;
		private Object handler;
		private Exception ex;

		public SaveLogThread(Log log, Object handler, Exception ex) {
			super(SaveLogThread.class.getSimpleName());
			this.log = log;
			this.handler = handler;
			this.ex = ex;
		}

		@Override
		public void run() {
			// 获取日志标题
			if (StringUtils.isBlank(log.getTitle())) {
				String permission = "";
				if (handler instanceof HandlerMethod) {
					Method m = ((HandlerMethod) handler).getMethod();
					RequiresPermissions rp = m.getAnnotation(RequiresPermissions.class);
					permission = (rp != null ? StringUtils.join(rp.value(), ",") : "");
				}
			}
			// 如果有异常，设置异常信息
			log.setException(Exceptions.getStackTraceAsString(ex));
			// 如果无标题并无异常日志，则不保存信息
			if (StringUtils.isBlank(log.getTitle()) && StringUtils.isBlank(log.getException())) {
				return;
			}
			// 保存日志信息
			logDao.save(log);
		}
	}

}

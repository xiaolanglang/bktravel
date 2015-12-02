package com.bkweb.sys.account.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.bkweb.common.utils.SpringContextHolder;
import com.bkweb.sys.account.dao.BkAccountDao;
import com.bkweb.sys.account.entity.BkAccount;

/**
 * 用户工具类
 * 
 * @author yourName
 * @version 2015-6-18
 */
public class AccountUtils {

	private static BkAccountDao UserDao = SpringContextHolder.getBean(BkAccountDao.class);

	public static final String DEFAULT_CACHE = "wzqbCache";

	public static final String CACHE_USER_LIST_BY_OFFICE = "userList_by_office_";

	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache() {

	}

	/**
	 * 清除指定账户缓存
	 * 
	 * @param user
	 */
	public static void clearCache(BkAccount User) {

	}

	/**
	 * 获取当前账户
	 * 
	 * @return
	 */
	public static BkAccount getUser() {
		String username = getPrincipal();
		if (username != null) {
			BkAccount account = new BkAccount();
			account.setUsername(username);
			account = UserDao.get(account);
			if (account != null) {
				return account;
			}
			return new BkAccount();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new BkAccount();
	}

	/**
	 * user cache
	 */
	public static Session getSession() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null) {
				session = subject.getSession();
			}
			if (session != null) {
				return session;
			}
		} catch (InvalidSessionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defalutValue) {
		Object object = getSession().getAttribute(key);
		return object == null ? defalutValue : object;
	}

	public static void putCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		getSession().removeAttribute(key);
	}

	/**
	 * 获取当前登录者对象
	 */
	public static String getPrincipal() {
		try {
			Subject subject = SecurityUtils.getSubject();
			String principal = (String) subject.getPrincipal();
			if (principal != null) {
				return principal;
			}
			// subject.logout();
		} catch (UnavailableSecurityManagerException e) {

		} catch (InvalidSessionException e) {

		}
		return null;
	}
}

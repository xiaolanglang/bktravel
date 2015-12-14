/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bktravel.common.utils;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.bktravel.sys.account.entity.Account;
import com.bktravel.sys.authority.entity.AccountRole;
import com.bktravel.sys.authority.entity.Permissions;
import com.bktravel.sys.authority.entity.Role;
import com.bktravel.sys.security.SystemAuthorizingRealm.Principal;
import com.bktravel.sys.service.SystemService;
import com.bkweb.common.utils.CacheUtils;
import com.bkweb.common.utils.SpringContextHolder;

/**
 * 用户工具类
 * 
 * @author ThinkGem
 * @version 2013-12-05
 */
public class AccountUtils {

	// 因为使用了静态变量，所以不能使用@autowire注解
	private static SystemService systemService = SpringContextHolder.getBean(SystemService.class);

	public static final String ACCOUNT_CACHE = "accountCache";
	public static final String ACCOUNT_CACHE_ID_ = "id_";
	public static final String ACCOUNT_CACHE_LOGIN_NAME_ = "ln";
	public static final String ACCOUNT_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_PERMISSIONS_LIST = "permissionsList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";

	/**
	 * 根据ID获取用户
	 * 
	 * @param id
	 * @return 取不到返回null
	 */
	public static Account get(String id) {
		Account account = (Account) CacheUtils.get(ACCOUNT_CACHE, ACCOUNT_CACHE_ID_ + id);
		if (account == null) {
			account = systemService.get(new Account(id));
			if (account == null) {
				return null;
			}
			// account.setRoleList(roleDao.findList(new Role(account), false));
			CacheUtils.put(ACCOUNT_CACHE, ACCOUNT_CACHE_ID_ + account.getId(), account);
			CacheUtils.put(ACCOUNT_CACHE, ACCOUNT_CACHE_LOGIN_NAME_ + account.getUsername(), account);
		}
		return account;
	}

	/**
	 * 根据登录名获取用户
	 * 
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static Account getByUsername(String username) {
		Account account = (Account) CacheUtils.get(ACCOUNT_CACHE, ACCOUNT_CACHE_LOGIN_NAME_ + username);
		if (account == null) {
			account = systemService.getAccountByUsername(new Account(username, null));
			if (account == null) {
				return null;
			}
			// account.setRoleList(roleDao.findList(new Role(account), false));
			CacheUtils.put(ACCOUNT_CACHE, ACCOUNT_CACHE_ID_ + account.getId(), account);
			CacheUtils.put(ACCOUNT_CACHE, ACCOUNT_CACHE_LOGIN_NAME_ + account.getUsername(), account);
		}
		return account;
	}

	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache() {
		removeCache(CACHE_ROLE_LIST);
		removeCache(CACHE_PERMISSIONS_LIST);
		removeCache(CACHE_AREA_LIST);
		removeCache(CACHE_OFFICE_LIST);
		removeCache(CACHE_OFFICE_ALL_LIST);
		AccountUtils.clearCache(getAccount());
	}

	/**
	 * 清除指定用户缓存
	 * 
	 * @param account
	 */
	public static void clearCache(Account account) {
		CacheUtils.remove(ACCOUNT_CACHE, ACCOUNT_CACHE_ID_ + account.getId());
		CacheUtils.remove(ACCOUNT_CACHE, ACCOUNT_CACHE_LOGIN_NAME_ + account.getUsername());
		// if (account.getOffice() != null && account.getOffice().getId() !=
		// null) {
		// CacheUtils.remove(ACCOUNT_CACHE, ACCOUNT_CACHE_LIST_BY_OFFICE_ID_ +
		// account.getOffice().getId());
		// }
	}

	/**
	 * 获取当前用户
	 * 
	 * @return 取不到返回 new account()
	 */
	public static Account getAccount() {
		Principal principal = getPrincipal();
		if (principal != null) {
			Account account = get(principal.getId());
			if (account != null) {
				return account;
			}
			return new Account();
		}
		// 如果没有登录，则返回实例化空的account对象。
		return new Account();
	}

	/**
	 * 获取当前用户角色列表
	 * 
	 * @return
	 */
	public static List<Role> getRoleList() {
		@SuppressWarnings("unchecked")
		List<Role> roleList = (List<Role>) getCache(CACHE_ROLE_LIST);
		if (roleList == null) {
			Account account = getAccount();
			if (account.isAdmin()) {
				roleList = systemService.findAllRoleList();
			} else {
				roleList = systemService.findRoleListByAccount(account);
			}
			putCache(CACHE_ROLE_LIST, roleList);
		}
		return roleList;
	}

	/**
	 * 获取当前用户授权权限
	 * 
	 * @return
	 */
	public static List<Permissions> getPermissionList() {
		@SuppressWarnings("unchecked")
		List<Permissions> permissionsList = (List<Permissions>) getCache(CACHE_PERMISSIONS_LIST);
		if (permissionsList == null) {
			Account account = getAccount();
			if (account.isAdmin()) {
				permissionsList = systemService.findAllPermissionsList();
			} else {
				AccountRole ar = new AccountRole();
				ar.setAccount(account);
				permissionsList = systemService.findPermissionsByAccount(account);
			}
			putCache(CACHE_PERMISSIONS_LIST, permissionsList);
		}
		return permissionsList;
	}

	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal) subject.getPrincipal();
			if (principal != null) {
				return principal;
			}
		} catch (UnavailableSecurityManagerException e) {

		} catch (InvalidSessionException e) {

		}
		return null;
	}

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
			// subject.logout();
		} catch (InvalidSessionException e) {

		}
		return null;
	}

	// ============== account Cache ============== //

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		getSession().removeAttribute(key);
	}

}

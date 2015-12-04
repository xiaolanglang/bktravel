/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bktravel.common.utils;

import java.awt.Menu;
import java.awt.geom.Area;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.bktravel.sys.account.dao.AccountDao;
import com.bktravel.sys.account.entity.Account;
import com.bktravel.sys.role.dao.RoleDao;
import com.bktravel.sys.role.entity.Role;
import com.bktravel.sys.security.SystemAuthorizingRealm.Principal;
import com.bkweb.common.utils.CacheUtils;
import com.bkweb.common.utils.SpringContextHolder;

/**
 * 用户工具类
 * 
 * @author ThinkGem
 * @version 2013-12-05
 */
public class AccountUtils {

	private static AccountDao accountDao = SpringContextHolder.getBean(AccountDao.class);
	private static RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);
	// private static MenuDao menuDao =
	// SpringContextHolder.getBean(MenuDao.class);
	// private static AreaDao areaDao =
	// SpringContextHolder.getBean(AreaDao.class);
	// private static OfficeDao officeDao =
	// SpringContextHolder.getBean(OfficeDao.class);

	public static final String ACCOUNT_CACHE = "accountCache";
	public static final String ACCOUNT_CACHE_ID_ = "id_";
	public static final String ACCOUNT_CACHE_LOGIN_NAME_ = "ln";
	public static final String ACCOUNT_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
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
			account = accountDao.get(account);
			if (account == null) {
				return null;
			}
			account.setRoleList(roleDao.findList(new Role(account), false));
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
			account = accountDao.getAccountByUsername(new Account(username, null));
			if (account == null) {
				return null;
			}
			account.setRoleList(roleDao.findList(new Role(account), false));
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
		removeCache(CACHE_MENU_LIST);
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
				roleList = roleDao.findAllList(Role.class, true);
			} else {
				roleList = roleDao.findList(new Role(account), false);
			}
			putCache(CACHE_ROLE_LIST, roleList);
		}
		return roleList;
	}

	/**
	 * 获取当前用户授权菜单
	 * 
	 * @return
	 */
	public static List<Menu> getMenuList() {
		// @SuppressWarnings("unchecked")
		// List<Menu> menuList = (List<Menu>) getCache(CACHE_MENU_LIST);
		// if (menuList == null) {
		// Account account = getAccount();
		// if (account.isAdmin()) {
		// menuList = menuDao.findAllList(new Menu());
		// } else {
		// Menu m = new Menu();
		// m.setaccountId(account.getId());
		// menuList = menuDao.findByaccountId(m);
		// }
		// putCache(CACHE_MENU_LIST, menuList);
		// }
		return null;
	}

	/**
	 * 获取当前用户授权的区域
	 * 
	 * @return
	 */
	public static List<Area> getAreaList() {
		// @SuppressWarnings("unchecked")
		// List<Area> areaList = (List<Area>) getCache(CACHE_AREA_LIST);
		// if (areaList == null) {
		// areaList = areaDao.findAllList(new Area());
		// putCache(CACHE_AREA_LIST, areaList);
		// }
		return null;
	}

	// /**
	// * 获取当前用户有权限访问的部门
	// *
	// * @return
	// */
	// public static List<Office> getOfficeList() {
	// @SuppressWarnings("unchecked")
	// List<Office> officeList = (List<Office>) getCache(CACHE_OFFICE_LIST);
	// if (officeList == null) {
	// account account = getaccount();
	// if (account.isAdmin()) {
	// officeList = officeDao.findAllList(new Office());
	// } else {
	// Office office = new Office();
	// office.getSqlMap().put("dsf", BaseService.dataScopeFilter(account, "a",
	// ""));
	// officeList = officeDao.findList(office);
	// }
	// putCache(CACHE_OFFICE_LIST, officeList);
	// }
	// return officeList;
	// }

	// /**
	// * 获取当前用户有权限访问的部门
	// *
	// * @return
	// */
	// public static List<Office> getOfficeAllList() {
	// @SuppressWarnings("unchecked")
	// List<Office> officeList = (List<Office>) getCache(CACHE_OFFICE_ALL_LIST);
	// if (officeList == null) {
	// officeList = officeDao.findAllList(new Office());
	// }
	// return officeList;
	// }

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

	// ============== account Cache ==============

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		// Object obj = getCacheMap().get(key);
		Object obj = getSession().getAttribute(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		// getCacheMap().put(key, value);
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		// getCacheMap().remove(key);
		getSession().removeAttribute(key);
	}

	// public static Map<String, Object> getCacheMap(){
	// Principal principal = getPrincipal();
	// if(principal!=null){
	// return principal.getCacheMap();
	// }
	// return new HashMap<String, Object>();
	// }

}

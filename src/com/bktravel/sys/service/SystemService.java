package com.bktravel.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.common.utils.AccountUtils;
import com.bktravel.sys.account.dao.AccountDao;
import com.bktravel.sys.account.entity.Account;
import com.bktravel.sys.role.dao.RoleDao;
import com.bktravel.sys.security.SystemAuthorizingRealm;
import com.bkweb.common.security.shiro.session.SessionDAO;
import com.bkweb.common.service.BaseService;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 * 
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class SystemService extends BaseService {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private RoleDao roleDao;
	// @Autowired
	// private MenuDao menuDao;
	@Autowired
	private SessionDAO sessionDao;
	@Autowired
	private SystemAuthorizingRealm systemRealm;

	public SessionDAO getSessionDao() {
		return sessionDao;
	}

	// -- account Service --//

	/**
	 * 登录
	 * 
	 * @param userName
	 * @param passWord
	 */
	public Account login(String userName, String passWord) {
		Account account = accountDao.login(userName, passWord);
		return account;
	}

	/**
	 * 获取用户
	 * 
	 * @param id
	 * @return
	 */
	public Account getAccount(String id) {
		return AccountUtils.get(id);
	}

	/**
	 * 根据登录名获取用户
	 * 
	 * @param loginName
	 * @return
	 */
	public Account getAccountByUsername(String loginName) {
		return AccountUtils.getByUsername(loginName);
	}

}

package com.bktravel.sys.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bktravel.common.config.Global;
import com.bktravel.common.utils.AccountUtils;
import com.bktravel.sys.account.entity.Account;
import com.bktravel.sys.log.util.LogUtils;
import com.bktravel.sys.service.SystemService;
import com.bkweb.common.utils.Encodes;
import com.bkweb.common.web.Servlets;

/**
 * 系统安全认证实现类
 * 
 * @author ThinkGem
 * @version 2014-7-5
 */
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SystemService systemService;

	/**
	 * 认证回调函数, 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
		try {
			UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

			int activeSessionSize = systemService.getSessionDao().getActiveSessions(false).size();
			if (logger.isDebugEnabled()) {
				logger.debug("login submit, active session size: {}, accountname: {}", activeSessionSize,
						token.getUsername());
			}

			// 校验登录验证码
			// if (LoginController.isValidateCodeLogin(token.getUsername(),
			// false,
			// false)) {
			// Session session = AccountUtils.getSession();
			// String code = (String)
			// session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
			// if (token.getCaptcha() == null ||
			// !token.getCaptcha().toUpperCase().equals(code)) {
			// throw new AuthenticationException("msg:验证码错误, 请重试.");
			// }
			// }

			String userName = token.getUsername().trim();
			String passWord = String.valueOf(token.getPassword());
			passWord = Encodes.getMD5Password(userName, passWord);
			token.setPassword(passWord.toCharArray());

			Account account = systemService.login(userName, passWord);
			if (account != null) {
				if (Global.NO.equals(account.getLoginFlag())) {
					throw new AuthenticationException("msg:该已帐号禁止登录.");
				}

				return new SimpleAuthenticationInfo(new Principal(account, token.isMobileLogin()),
						account.getPassword(), getName());
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Principal principal = (Principal) getAvailablePrincipal(principals);
		// 获取当前已登录的用户
		if (!Global.TRUE.equals(Global.getConfig("account.multiAccountLogin"))) {
			Collection<Session> sessions = systemService.getSessionDao().getActiveSessions(true, principal,
					AccountUtils.getSession());
			if (sessions.size() > 0) {
				// 如果是登录进来的，则踢出已在线用户
				if (AccountUtils.getSubject().isAuthenticated()) {
					for (Session session : sessions) {
						systemService.getSessionDao().delete(session);
					}
				}
				// 记住我进来的，并且当前用户已登录，则退出当前用户提示信息。
				else {
					AccountUtils.getSubject().logout();
					throw new AuthenticationException("msg:账号已在其它地方登录，请重新登录。");
				}
			}
		}
		Account account = systemService.getAccountByUsername(principal.getUsername());
		if (account != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// List<Menu> list = AccountUtils.getMenuList();
			// for (Menu menu : list) {
			// if (StringUtils.isNotBlank(menu.getPermission())) {
			// // 添加基于Permission的权限信息
			// for (String permission : StringUtils.split(menu.getPermission(),
			// ",")) {
			// info.addStringPermission(permission);
			// }
			// }
			// }
			// 添加用户权限
			info.addStringPermission("user");
			info.addRole("tourism:list2");
			// 添加用户角色信息
			// for (Role role : account.getRoleList()) {
			// info.addRole(role.getEnname());
			// }
			// 更新登录IP和时间
			// systemService.updateAccountLoginInfo(account);
			// 记录登录日志
			LogUtils.saveLog(Servlets.getRequest(), "系统登录");
			return info;
		} else {
			return null;
		}
	}

	@Override
	protected void checkPermission(Permission permission, AuthorizationInfo info) {
		authorizationValidate(permission);
		super.checkPermission(permission, info);
	}

	@Override
	protected boolean[] isPermitted(List<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
			for (Permission permission : permissions) {
				authorizationValidate(permission);
			}
		}
		return super.isPermitted(permissions, info);
	}

	@Override
	public boolean isPermitted(PrincipalCollection principals, Permission permission) {
		authorizationValidate(permission);
		return super.isPermitted(principals, permission);
	}

	@Override
	protected boolean isPermittedAll(Collection<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
			for (Permission permission : permissions) {
				authorizationValidate(permission);
			}
		}
		return super.isPermittedAll(permissions, info);
	}

	/**
	 * 授权验证方法,模块授权预留接口
	 * 
	 * @param permission
	 */
	private void authorizationValidate(Permission permission) {

	}

	// /**
	// * 设定密码校验的Hash算法与迭代次数
	// */
	// @PostConstruct
	// public void initCredentialsMatcher() {
	// HashedCredentialsMatcher matcher = new
	// HashedCredentialsMatcher(Encodes.MD5);
	// matcher.setHashIterations(Encodes.HASH_INTERATIONS);
	// setCredentialsMatcher(matcher);
	// }

	/**
	 * 授权用户信息
	 */
	public static class Principal implements Serializable {

		private static final long serialVersionUID = 1L;

		private String id; // 编号
		private String username; // 登录名
		private boolean mobileLogin; // 是否手机登录

		public Principal(Account account, boolean mobileLogin) {
			this.id = account.getId();
			this.username = account.getUsername();
			this.mobileLogin = mobileLogin;
		}

		public String getId() {
			return id;
		}

		public boolean isMobileLogin() {
			return mobileLogin;
		}

		public String getUsername() {
			return username;
		}

		/**
		 * 获取SESSIONID
		 */
		public String getSessionid() {
			try {
				return (String) AccountUtils.getSession().getId();
			} catch (Exception e) {
				return "";
			}
		}

		@Override
		public String toString() {
			return id;
		}

	}
}

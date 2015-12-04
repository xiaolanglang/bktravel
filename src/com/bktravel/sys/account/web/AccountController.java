package com.bktravel.sys.account.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bktravel.common.utils.AccountUtils;
import com.bktravel.common.web.BaseController;
import com.bktravel.sys.account.entity.Account;
import com.bktravel.sys.account.service.AccountService;
import com.bktravel.sys.security.SystemAuthorizingRealm.Principal;
import com.bkweb.common.utils.hibernatepage.HPage;

/**
 * 用户Controller
 * 
 * @author yourName
 * @version 2015-6-19
 */
@Controller
@RequestMapping({ "${adminPath}/account", "" })
public class AccountController extends BaseController {

	@Autowired
	private AccountService accountService;

	@RequestMapping("list")
	public String findbkAccountList(Account account, int pageNum, HttpServletRequest request) {
		List<Account> list = accountService.findPageList(account, true, new HPage<Account>(pageNum));
		request.setAttribute("userList", list);
		return "bkAccount/bkAccountList";
	}

	@RequestMapping("")
	public String index(HttpSession session) {
		Principal principal = AccountUtils.getPrincipal();
		// 如果已经登录，则跳转到管理首页
		if (principal != null && !principal.isMobileLogin()) {
			return "home/index";
		}
		return "sys/login/login";
	}

	/**
	 * 登录失败之后进入的方法
	 * 
	 * @param account
	 * @return
	 */
	@RequestMapping("login")
	public String login(Account account) {

		return "redirect:/";
	}

	@RequestMapping("loginout")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

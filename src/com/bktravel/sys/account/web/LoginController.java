package com.bktravel.sys.account.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.utils.AccountUtils;
import com.bktravel.common.web.BaseController;
import com.bktravel.sys.account.entity.Account;
import com.bktravel.sys.account.service.AccountService;
import com.bktravel.sys.security.SystemAuthorizingRealm.Principal;

@Controller
@RequestMapping("")
public class LoginController extends BaseController {
	@Autowired
	private AccountService accountService;

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
	@RequestMapping(value = "login")
	public String login(Account account, RedirectAttributes attributes) {
		return "redirect:/";
	}

	@RequestMapping("loginout")
	public String loginout(HttpSession session) {
		AccountUtils.getSubject().logout();
		return "redirect:/";
	}
}

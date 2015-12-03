package com.bktravel.sys.account.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bktravel.common.config.Global;
import com.bktravel.common.web.BaseController;
import com.bktravel.sys.account.entity.BkAccount;
import com.bktravel.sys.account.service.BkAccountService;
import com.bkweb.common.utils.MD5;
import com.bkweb.common.utils.hibernatepage.HPage;

/**
 * 用户Controller
 * 
 * @author yourName
 * @version 2015-6-19
 */
@Controller
@RequestMapping({ "${adminPath}/account", "" })
public class BkAccountController extends BaseController {

	@Autowired
	private BkAccountService accountService;

	@RequestMapping("list")
	public String findbkAccountList(BkAccount account, int pageNum, HttpServletRequest request) {
		List<BkAccount> list = accountService.findPageList(account, true, new HPage<BkAccount>(pageNum));
		request.setAttribute("userList", list);
		return "bkAccount/bkAccountList";
	}

	@RequestMapping("")
	public String index(HttpSession session) {
		Object bkAccount = session.getAttribute("account");
		if (bkAccount == null) {
			return "sys/login/login";
		}
		return "home/index";
	}

	@RequestMapping("login")
	public String login(BkAccount account, HttpSession session) {
		String userName = account.getUsername().trim();
		String passWord = account.getPassword().trim();
		passWord = MD5.sign(passWord, userName, Global.CHART_SET);
		accountService.login(session, userName, passWord);

		return "redirect:/";
	}

	@RequestMapping("loginout")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

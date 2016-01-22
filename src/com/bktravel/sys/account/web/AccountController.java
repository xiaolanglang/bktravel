package com.bktravel.sys.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bkweb.common.utils.Encodes;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.sys.account.entity.Account;
import com.bkweb.sys.account.service.AccountService;
import com.bkweb.sys.user.entity.User;
import com.bkweb.sys.user.service.UserService;

/**
 * 用户Controller
 * 
 * @author yourName
 * @version 2015-6-19
 */
@Controller
@RequestMapping("${adminPath}/account")
public class AccountController extends BaseController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserService userService;

	@RequestMapping("list")
	public String findbkAccountList(User user, Integer pageNum, Model model) {
		HPage<User> page = new HPage<User>(pageNum);
		userService.findPageList(user, true, page, "account");
		model.addAttribute("page", page);
		return "sys/account/list";
	}

	@RequestMapping("save")
	public String save(User user, RedirectAttributes attributes) {
		Account account = user.getAccount();
		String password = Encodes.getMD5Password(account.getUsername(), account.getPassword());
		account.setPassword(password);
		accountService.saveOrUpdate(account);
		userService.saveOrUpdate(user);
		addRedirectMessage(attributes, "保存账户成功");
		return "redirect:" + adminPath + "/account/list";
	}

	@RequestMapping("edit")
	public String edit(User user, Model model) {
		if (user != null && !StringUtils.isEmpty(user.getId())) {
			user = userService.get(user);
		}

		model.addAttribute("user", user);
		return "sys/account/save";
	}

	@RequestMapping("del")
	public String delete(User user, RedirectAttributes attributes) {
		user = userService.get(user);
		Account account = user.getAccount();
		userService.trueDelete(user);
		if (account != null) {
			accountService.trueDelete(account);
		}
		addRedirectMessage(attributes, "删除账户成功");
		return "redirect:" + adminPath + "/account/list";
	}
}

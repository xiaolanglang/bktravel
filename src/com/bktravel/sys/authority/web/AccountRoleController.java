package com.bktravel.sys.authority.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.sys.account.entity.Account;
import com.bkweb.sys.authority.entity.AccountRole;
import com.bkweb.sys.authority.entity.Role;
import com.bkweb.sys.authority.service.CAccountRoleService;
import com.bkweb.sys.authority.service.CRoleService;

@Controller
@RequestMapping("${adminPath}/accountrole")
public class AccountRoleController extends BaseController {
	@Autowired
	private CAccountRoleService actRoleService;

	@Autowired
	private CRoleService roleService;

	@RequestMapping("list/{accountId}")
	public String findList(@PathVariable String accountId, AccountRole accountRole, Integer pageNum, Model model) {
		HPage<AccountRole> page = new HPage<AccountRole>(pageNum);
		accountRole.setAccount(new Account(accountId));
		actRoleService.findPageList(accountRole, true, page, "account");
		model.addAttribute("page", page);
		return "sys/authority/accountrole/list";
	}

	@RequestMapping("save/{accountId}")
	public String save(@PathVariable String accountId, AccountRole accountRole, RedirectAttributes attributes) {
		actRoleService.saveOrUpdate(accountRole);
		addRedirectMessage(attributes, "保存账户角色成功");
		return "redirect:" + adminPath + "/accountrole/list/" + accountId;
	}

	@RequestMapping("edit/{accountId}")
	public String edit(@PathVariable String accountId, Model model) {
		AccountRole accountRole = new AccountRole();
		accountRole.setAccount(new Account(accountId));
		model.addAttribute("accountRole", accountRole);
		model.addAttribute("roleList", roleService.findAllList(Role.class, true));
		return "sys/authority/accountrole/save";
	}

	@RequestMapping("del/{accountId}")
	public String delete(@PathVariable String accountId, AccountRole accountRole, RedirectAttributes attributes) {
		actRoleService.trueDelete(accountRole);
		addRedirectMessage(attributes, "删除账户角色成功");
		return "redirect:" + adminPath + "/accountrole/list/" + accountId;
	}
}

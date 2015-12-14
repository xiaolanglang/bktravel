package com.bktravel.sys.authority.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bktravel.sys.authority.entity.AccountRole;
import com.bktravel.sys.authority.service.AccountRoleService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;

@Controller
@RequestMapping("${adminPath}/accountrole")
public class AccountRoleController extends BaseController {
	@Autowired
	private AccountRoleService actRoleService;

	@RequestMapping("list")
	public String findList(AccountRole accountRole, Integer pageNum, Model model) {
		HPage<AccountRole> page = new HPage<AccountRole>(pageNum);
		actRoleService.findPageList(accountRole, true, page);
		model.addAttribute("page", page);
		return "sys/authority/accountrole/list";
	}

	@RequestMapping("save")
	public String save(AccountRole accountRole, RedirectAttributes attributes) {
		actRoleService.saveOrUpdate(accountRole);
		addRedirectMessage(attributes, "保存账户角色成功");
		return "redirect:" + adminPath + "/accountrole/list";
	}

	@RequestMapping("edit")
	public String edit(AccountRole accountRole, Model model) {
		if (accountRole != null && !StringUtils.isEmpty(accountRole.getId())) {
			accountRole = actRoleService.get(accountRole);
		}

		model.addAttribute("accountRole", accountRole);
		return "sys/authority/accountrole/save";
	}

	@RequestMapping("del")
	public String delete(AccountRole accountRole, RedirectAttributes attributes) {
		actRoleService.trueDelete(accountRole);
		addRedirectMessage(attributes, "删除账户角色成功");
		return "redirect:" + adminPath + "/accountrole/list";
	}
}

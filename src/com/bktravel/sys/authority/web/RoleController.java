package com.bktravel.sys.authority.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bktravel.sys.authority.service.RoleService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.sys.authority.entity.Role;

@Controller
@RequestMapping("${adminPath}/role")
public class RoleController extends BaseController {
	@Autowired
	private RoleService roleService;

	@RequestMapping("list")
	public String findList(Role role, Integer pageNum, Model model) {
		HPage<Role> page = new HPage<Role>(pageNum);
		roleService.findPageList(role, true, page);
		model.addAttribute("page", page);
		return "sys/authority/role/list";
	}

	@RequestMapping("save")
	public String save(Role role, RedirectAttributes attributes) {
		roleService.saveOrUpdate(role);
		addRedirectMessage(attributes, "保存权限成功");
		return "redirect:" + adminPath + "/role/list";
	}

	@RequestMapping("edit")
	public String edit(Role role, Model model) {
		if (role != null && !StringUtils.isEmpty(role.getId())) {
			role = roleService.get(role);
		}

		model.addAttribute("role", role);
		return "sys/authority/role/save";
	}

	@RequestMapping("del")
	public String delete(Role role, RedirectAttributes attributes) {
		roleService.trueDelete(role);
		addRedirectMessage(attributes, "删除权限成功");
		return "redirect:" + adminPath + "/role/list";
	}
}

package com.bktravel.sys.authority.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.sys.authority.entity.Permissions;
import com.bkweb.sys.authority.entity.Role;
import com.bkweb.sys.authority.entity.RolePermission;
import com.bkweb.sys.authority.service.PermissionsService;
import com.bkweb.sys.authority.service.RolePerService;

@Controller
@RequestMapping("${adminPath}/rolepermission")
public class RolePerController extends BaseController {
	@Autowired
	private RolePerService rolePerService;

	@Autowired
	private PermissionsService perService;

	@RequestMapping("list/{roleId}")
	public String findPermissionsByRole(@PathVariable String roleId, RolePermission rolePer, Integer pageNum,
			Model model) {
		HPage<RolePermission> page = new HPage<RolePermission>(pageNum);
		rolePer.setRole(new Role(roleId));
		rolePerService.findPageList(rolePer, true, page, "role", "permissions");
		model.addAttribute("page", page);
		model.addAttribute("rolePer", rolePer);
		return "sys/authority/rolepermission/list";
	}

	@RequestMapping("save/{roleId}")
	public String save(@PathVariable String roleId, RolePermission rolePer, RedirectAttributes attributes) {
		rolePerService.saveOrUpdate(rolePer);
		addRedirectMessage(attributes, "保存权限成功");
		return "redirect:" + adminPath + "/rolepermission/list/" + roleId;
	}

	@RequestMapping("edit/{roleId}")
	public String edit(@PathVariable String roleId, Model model) {
		RolePermission rolePer = new RolePermission();
		rolePer.setRole(new Role(roleId));
		model.addAttribute("rolePer", rolePer);
		model.addAttribute("permissionsList", perService.findAllList(Permissions.class, true));
		return "sys/authority/rolepermission/save";
	}

	@RequestMapping("del/{roleId}")
	public String delete(@PathVariable String roleId, RolePermission rolePer, RedirectAttributes attributes) {
		rolePerService.trueDelete(rolePer);
		addRedirectMessage(attributes, "删除权限成功");
		return "redirect:" + adminPath + "/rolepermission/list/" + roleId;
	}
}

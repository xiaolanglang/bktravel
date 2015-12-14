package com.bktravel.sys.authority.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bktravel.sys.authority.entity.RolePermission;
import com.bktravel.sys.authority.service.RolePerService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;

@Controller
@RequestMapping("${adminPath}/rolepermission")
public class RolePerController extends BaseController {
	@Autowired
	private RolePerService rolePerService;

	@RequestMapping("list")
	public String findList(RolePermission rolePer, Integer pageNum, Model model) {
		HPage<RolePermission> page = new HPage<RolePermission>(pageNum);
		rolePerService.findPageList(rolePer, true, page);
		model.addAttribute("page", page);
		return "sys/authority/rolepermission/list";
	}

	@RequestMapping("save")
	public String save(RolePermission rolePer, RedirectAttributes attributes) {
		rolePerService.saveOrUpdate(rolePer);
		addRedirectMessage(attributes, "保存权限成功");
		return "redirect:" + adminPath + "/rolepermission/list";
	}

	@RequestMapping("edit")
	public String edit(RolePermission rolePer, Model model) {
		if (rolePer != null && !StringUtils.isEmpty(rolePer.getId())) {
			rolePer = rolePerService.get(rolePer);
		}

		model.addAttribute("rolePer", rolePer);
		return "sys/authority/rolepermission/save";
	}

	@RequestMapping("del")
	public String delete(RolePermission rolePer, RedirectAttributes attributes) {
		rolePerService.trueDelete(rolePer);
		addRedirectMessage(attributes, "删除权限成功");
		return "redirect:" + adminPath + "/rolepermission/list";
	}
}

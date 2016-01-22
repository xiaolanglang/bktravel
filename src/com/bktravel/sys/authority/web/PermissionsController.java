package com.bktravel.sys.authority.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.sys.authority.entity.Permissions;
import com.bkweb.sys.authority.service.CPermissionsService;

@Controller
@RequestMapping("${adminPath}/permissions")
public class PermissionsController extends BaseController {

	@Autowired
	private CPermissionsService perService;

	@RequestMapping("list")
	public String findList(Permissions permissions, Integer pageNum, Model model) {
		HPage<Permissions> page = new HPage<Permissions>(pageNum);
		perService.findPageList(permissions, true, page);
		model.addAttribute("page", page);
		return "sys/authority/permissions/list";
	}

	@RequestMapping("save")
	public String save(Permissions permissions, RedirectAttributes attributes) {
		perService.saveOrUpdate(permissions);
		addRedirectMessage(attributes, "保存权限成功");
		return "redirect:" + adminPath + "/permissions/list";
	}

	@RequestMapping("edit")
	public String edit(Permissions permissions, Model model) {
		if (permissions != null && !StringUtils.isEmpty(permissions.getId())) {
			permissions = perService.get(permissions);
		}

		model.addAttribute("permission", permissions);
		return "sys/authority/permissions/save";
	}

	@RequestMapping("del")
	public String delete(Permissions permissions, RedirectAttributes attributes) {
		perService.trueDelete(permissions);
		addRedirectMessage(attributes, "删除权限成功");
		return "redirect:" + adminPath + "/permissions/list";
	}
}

package com.bktravel.modules.menu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.menu.entity.MenuFind;
import com.bkweb.modules.menu.service.MenuFindService;

@Controller
@RequestMapping("${adminPath}/menu/find")
public class FindPageController extends BaseController {

	@Autowired
	private MenuFindService menuFindService;

	@RequestMapping("list")
	public String findList(MenuFind menuFind, Integer pageNum, Model model) {
		HPage<MenuFind> page = new HPage<MenuFind>(pageNum);
		menuFindService.findPageList(menuFind, true, page);
		model.addAttribute("page", page);
		model.addAttribute("menuFind", menuFind);
		return "menu/find/list";
	}

	@RequestMapping("save")
	public String save(MenuFind menuFind, RedirectAttributes attributes) {
		menuFindService.saveOrUpdate(menuFind);
		addRedirectMessage(attributes, "保存菜单信息成功");
		return "redirect:" + adminPath + "/menu/find/list";
	}

	@RequestMapping("edit")
	public String edit(MenuFind menuFind, Model model) {
		if (menuFind != null && !StringUtils.isEmpty(menuFind.getId())) {
			menuFind = menuFindService.get(menuFind);
		}

		model.addAttribute("menuFind", menuFind);
		return "menu/find/save";
	}

	@RequestMapping("del")
	public String delete(MenuFind menuFind, RedirectAttributes attributes) {
		menuFindService.trueDelete(menuFind);
		addRedirectMessage(attributes, "删除菜单信息成功");
		return "redirect:" + adminPath + "/menu/find/list";
	}
}

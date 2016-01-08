package com.bktravel.modules.menu.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.menu.entity.MenuSort;
import com.bkweb.modules.menu.service.MenuSortService;

@Controller
@RequestMapping("${adminPath}/menu/sort")
public class SortPageController extends BaseController {

	@Autowired
	private MenuSortService menuSortService;

	@RequestMapping("list")
	public String sortList(Model model) {
		model.addAttribute("list", menuSortService.findAllParentList());
		return "menu/sort/list";
	}

	@RequestMapping("save")
	public String save(MenuSort menusort, RedirectAttributes attributes) {
		menuSortService.saveOrUpdate(menusort);
		addRedirectMessage(attributes, "保存菜单信息成功");
		return "redirect:" + adminPath + "/menu/sort/list";
	}

	@RequestMapping("edit")
	public String edit(MenuSort menusort, Model model) {
		if (menusort != null && !StringUtils.isEmpty(menusort.getId())) {
			menusort = menuSortService.get(menusort);
		}

		model.addAttribute("menusort", menusort);
		return "menu/sort/save";
	}

	@RequestMapping("del")
	public String delete(MenuSort menusort, RedirectAttributes attributes) {
		menuSortService.trueDelete(menusort);
		addRedirectMessage(attributes, "删除菜单信息成功");
		return "redirect:" + adminPath + "/menu/sort/list";
	}

	// ---------- 子栏目部分

	@RequestMapping("childmenulist/{parentId}")
	public String childMenuList(@PathVariable String parentId, MenuSort menusort, Model model, Integer pageNum) {
		HPage<MenuSort> page = new HPage<MenuSort>(pageNum);
		menusort.setParent(new MenuSort());
		menusort.getParent().setId(parentId);
		menuSortService.findPageList(menusort, true, page, "parent");

		model.addAttribute("page", page);
		model.addAttribute("parentId", parentId);
		model.addAttribute("menusort", menusort);
		return "menu/sort/childMenuList";
	}

	@RequestMapping("childmenuedit/{parentId}")
	public String childMenuEdit(@PathVariable String parentId, MenuSort menusort, Model model) {
		if (menusort != null && !StringUtils.isEmpty(menusort.getId())) {
			menusort = menuSortService.get(menusort);
		}

		model.addAttribute("menusort", menusort);
		model.addAttribute("parentId", parentId);
		return "menu/sort/childMenuSave";
	}

	@RequestMapping("childmenusave")
	public String childMenuSave(MenuSort menusort, Model model, RedirectAttributes attributes,
			HttpServletRequest request) {
		boolean flag = menuSortService.save(request, menusort);
		if (flag) {
			addRedirectMessage(attributes, "保存菜单信息成功");
			return "redirect:" + adminPath + "/menu/sort/childmenulist/" + menusort.getParent().getId();
		} else {
			addRedirectMessage(attributes, "请选择600*400大小的图片");
			return "redirect:" + adminPath + "/menu/sort/childmenuedit/" + menusort.getParent().getId() + "?id="
					+ menusort.getId();
		}
	}

	@RequestMapping("childmenudel/{parentId}")
	public String delete(@PathVariable String parentId, MenuSort menusort, RedirectAttributes attributes) {
		menuSortService.trueDelete(menusort);
		addRedirectMessage(attributes, "删除栏目成功");
		return "redirect:" + adminPath + "/menu/sort/childmenulist/" + parentId;
	}

}

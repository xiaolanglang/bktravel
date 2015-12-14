package com.bktravel.modules.position.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bktravel.modules.position.entity.Continent;
import com.bktravel.modules.position.entity.Nation;
import com.bktravel.modules.position.service.NationService;
import com.bktravel.modules.position.service.PositionService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;

@Controller
@RequestMapping("${adminPath}/nation")
public class NationController extends BaseController {
	@Autowired
	private NationService nationService;

	@Autowired
	private PositionService positionService;

	@RequestMapping("list")
	public String findList(Nation nation, Integer pageNum, Model model) {
		HPage<Nation> page = new HPage<Nation>(pageNum);
		nationService.findPageList(nation, true, page, "continent");

		model.addAttribute("page", page);
		model.addAttribute("nation", nation);
		model.addAttribute("continents", positionService.findContinentList(new Continent(), true));
		return "position/nation/list";
	}

	@RequestMapping("save")
	public String save(Nation nation, RedirectAttributes attributes) {
		nationService.saveOrUpdate(nation);
		addRedirectMessage(attributes, "保存国家成功");
		return "redirect:" + adminPath + "/nation/list";
	}

	@RequestMapping("edit")
	public String edit(Nation nation, Model model) {
		if (nation != null && !StringUtils.isEmpty(nation.getId())) {
			nation = nationService.get(nation);
		}

		model.addAttribute("nation", nation);
		model.addAttribute("continents", positionService.findContinentList(new Continent(), true));
		return "position/nation/save";
	}

	@RequestMapping("del")
	public String delete(Nation nation, RedirectAttributes attributes) {
		nationService.trueDelete(nation);
		addRedirectMessage(attributes, "删除国家成功");
		return "redirect:" + adminPath + "/nation/list";
	}

}

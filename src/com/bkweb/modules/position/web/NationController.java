package com.bkweb.modules.position.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.common.web.BaseController;
import com.bkweb.modules.position.entity.Continent;
import com.bkweb.modules.position.entity.Nation;
import com.bkweb.modules.position.service.NationService;
import com.bkweb.modules.position.service.PositionService;

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
	public String save(Nation nation, Model model) {
		nationService.saveOrUpdate(nation);
		addMessage(model, "添加国家信息成功");
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
	public String delete(Nation nation, Model model) {
		nationService.trueDelete(nation);
		addMessage(model, "删除洲信息成功");
		return "redirect:" + adminPath + "/nation/list";
	}

}
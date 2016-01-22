package com.bktravel.modules.attraction.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bktravel.modules.attraction.service.AttractionService;
import com.bktravel.modules.position.service.PositionService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.attraction.entity.Attraction;

@Controller
@RequestMapping("${adminPath}/attraction")
public class AttractionController extends BaseController {
	@Autowired
	private AttractionService attractionService;

	@Autowired
	private PositionService positionService;

	@RequestMapping("list")
	public String findList(Attraction attraction, Integer pageNum, Model model) {
		HPage<Attraction> page = new HPage<Attraction>(pageNum);
		attractionService.findPageList(attraction, true, page, "city");
		model.addAttribute("page", page);
		model.addAttribute("attraction", attraction);
		return "attraction/attraction/list";
	}

	@RequestMapping("save")
	public String save(Attraction attraction, RedirectAttributes attributes) {
		attractionService.saveOrUpdate(attraction);
		addRedirectMessage(attributes, "保存景点成功");
		return "redirect:" + adminPath + "/attraction/list";
	}

	@RequestMapping("edit")
	public String edit(Attraction attraction, Model model) {
		if (attraction != null && !StringUtils.isEmpty(attraction.getId())) {
			attraction = attractionService.get(attraction);
		}

		model.addAttribute("attraction", attraction);
		return "attraction/attraction/save";
	}

	@RequestMapping("del")
	public String delete(Attraction attraction, RedirectAttributes attributes) {
		attractionService.trueDelete(attraction);
		addRedirectMessage(attributes, "删除景点成功");
		return "redirect:" + adminPath + "/attraction/list";
	}
}

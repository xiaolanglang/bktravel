package com.bktravel.modules.attraction.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bktravel.modules.attraction.entity.Attraction;
import com.bktravel.modules.attraction.service.AttractionService;
import com.bktravel.modules.position.service.PositionService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.common.web.BaseController;

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
		attractionService.findPageList(attraction, true, page,"city");
		model.addAttribute("page", page);
		model.addAttribute("attraction", attraction);
		return "attraction/attraction/list";
	}

	@RequestMapping("save")
	public String save(Attraction attraction, Model model) {
		attractionService.saveOrUpdate(attraction);
		addMessage(model, "添加省会信息成功");
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
	public String delete(Attraction attraction, Model model) {
		attractionService.trueDelete(attraction);
		addMessage(model, "删除洲信息成功");
		return "redirect:" + adminPath + "/attraction/list";
	}
}

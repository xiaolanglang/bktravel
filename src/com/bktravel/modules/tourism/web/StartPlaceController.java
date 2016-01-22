package com.bktravel.modules.tourism.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.position.entity.City;
import com.bkweb.modules.position.service.CPositionService;
import com.bkweb.modules.tourism.entity.StartPlace;
import com.bkweb.modules.tourism.service.CStartPlaceService;

@Controller
@RequestMapping("${adminPath}/startPlace")
public class StartPlaceController extends BaseController {

	@Autowired
	private CStartPlaceService startPlaceService;

	@Autowired
	private CPositionService positionService;

	@RequestMapping("list")
	public String findList(StartPlace startPlace, Integer pageNum, Model model) {
		HPage<StartPlace> page = new HPage<StartPlace>(pageNum);
		startPlaceService.findPageList(startPlace, true, page, "city", "city.province", "city.province.nation",
				"city.province.nation.continent");
		model.addAttribute("page", page);
		model.addAttribute("startPlace", startPlace);
		return "tourism/startPlace/list";
	}

	@RequestMapping("save")
	public String save(StartPlace startPlace, RedirectAttributes attributes) {
		City city = positionService.getCity(startPlace.getCity());
		startPlace.setName(city.getName());
		startPlace.setNameEn(city.getNameEn());
		startPlaceService.saveOrUpdate(startPlace);
		addRedirectMessage(attributes, "保存出发地成功");
		return "redirect:" + adminPath + "/startPlace/list";
	}

	@RequestMapping("edit")
	public String edit(StartPlace startPlace, Model model) {
		if (startPlace != null && !StringUtils.isEmpty(startPlace.getId())) {
			startPlace = startPlaceService.get(startPlace);
		}

		model.addAttribute("startPlace", startPlace);
		return "tourism/startPlace/save";
	}

	@RequestMapping("del")
	public String delete(StartPlace startPlace, RedirectAttributes attributes) {
		startPlaceService.trueDelete(startPlace);
		addRedirectMessage(attributes, "删除出发地成功");
		return "redirect:" + adminPath + "/startPlace/list";
	}
}

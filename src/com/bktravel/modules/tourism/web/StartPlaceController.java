package com.bktravel.modules.tourism.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bktravel.modules.position.entity.City;
import com.bktravel.modules.position.service.PositionService;
import com.bktravel.modules.tourism.entity.StartPlace;
import com.bktravel.modules.tourism.service.StartPlaceService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.common.web.BaseController;

@Controller
@RequestMapping("${adminPath}/startPlace")
public class StartPlaceController extends BaseController {

	@Autowired
	private StartPlaceService startPlaceService;

	@Autowired
	private PositionService positionService;

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
	public String save(StartPlace startPlace, Model model) {
		City city = positionService.getCity(startPlace.getCity());
		startPlace.setName(city.getName());
		startPlace.setNameEn(city.getNameEn());
		startPlaceService.saveOrUpdate(startPlace);
		addMessage(model, "添加省会信息成功");
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
	public String delete(StartPlace startPlace, Model model) {
		startPlaceService.trueDelete(startPlace);
		addMessage(model, "删除洲信息成功");
		return "redirect:" + adminPath + "/startPlace/list";
	}
}

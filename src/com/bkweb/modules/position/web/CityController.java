package com.bkweb.modules.position.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.common.web.BaseController;
import com.bkweb.modules.position.entity.City;
import com.bkweb.modules.position.service.CityService;

@Controller
@RequestMapping("${adminPath}/city")
public class CityController extends BaseController {

	@Autowired
	private CityService cityService;

	@RequestMapping("list")
	public String findList(City city, Integer pageNum, Model model) {
		HPage<City> page = new HPage<City>(pageNum);
		cityService.findPageList(city, true, page, "province", "province.nation", "province.nation.continent");
		model.addAttribute("page", page);
		model.addAttribute("city", city);
		return "position/city/list";
	}

	@RequestMapping("save")
	public String save(City city, Model model) {
		cityService.saveOrUpdate(city);
		addMessage(model, "添加城市信息成功");
		return "redirect:" + adminPath + "/city/list";
	}

	@RequestMapping("edit")
	public String edit(City city, Model model) {
		if (city != null && !StringUtils.isEmpty(city.getId())) {
			city = cityService.get(city);
		}

		model.addAttribute("city", city);
		return "position/city/save";
	}

	@RequestMapping("del")
	public String delete(City city, Model model) {
		cityService.trueDelete(city);
		addMessage(model, "删除洲信息成功");
		return "redirect:" + adminPath + "/city/list";
	}
}

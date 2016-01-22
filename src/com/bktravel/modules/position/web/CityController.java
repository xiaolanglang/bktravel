package com.bktravel.modules.position.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bktravel.modules.position.service.CityService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.position.entity.City;

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
	public String save(City city, RedirectAttributes attributes) {
		cityService.saveOrUpdate(city);
		addRedirectMessage(attributes, "保存城市成功");
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
	public String delete(City city, RedirectAttributes attributes) {
		cityService.trueDelete(city);
		addRedirectMessage(attributes, "删除城市成功");
		return "redirect:" + adminPath + "/city/list";
	}
}

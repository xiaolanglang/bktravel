package com.bktravel.modules.position.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bktravel.common.web.BaseController;
import com.bktravel.modules.position.entity.Country;
import com.bktravel.modules.position.service.CountryService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;

@Controller
@RequestMapping("${adminPath}/country")
public class CountryController extends BaseController {
	@Autowired
	private CountryService countryService;

	@RequestMapping("list")
	public String findList(Country country, Integer pageNum, Model model) {
		HPage<Country> page = new HPage<Country>(pageNum);
		countryService.findPageList(country, true, page, "city", "city.province", "city.province.nation",
				"city.province.nation.continent");
		model.addAttribute("page", page);
		model.addAttribute("country", country);
		return "position/country/list";
	}

	@RequestMapping("save")
	public String save(Country country, Model model) {
		countryService.saveOrUpdate(country);
		addMessage(model, "添加县信息成功");
		return "redirect:" + adminPath + "/country/list";
	}

	@RequestMapping("edit")
	public String edit(Country country, Model model) {
		if (country != null && !StringUtils.isEmpty(country.getId())) {
			country = countryService.get(country);
		} 

		model.addAttribute("country", country);
		return "position/country/save";
	}

	@RequestMapping("del")
	public String delete(Country country, Model model) {
		countryService.trueDelete(country);
		addMessage(model, "删除洲信息成功");
		return "redirect:" + adminPath + "/country/list";
	}
}

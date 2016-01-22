package com.bktravel.modules.position.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bktravel.modules.position.service.CountryService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.position.entity.Country;

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
	public String save(Country country, RedirectAttributes attributes) {
		countryService.saveOrUpdate(country);
		addRedirectMessage(attributes, "保存县成功");
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
	public String delete(Country country, RedirectAttributes attributes) {
		countryService.trueDelete(country);
		addRedirectMessage(attributes, "删除县成功");
		return "redirect:" + adminPath + "/country/list";
	}
}

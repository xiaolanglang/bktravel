package com.bktravel.modules.position.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.position.entity.Province;
import com.bkweb.modules.position.service.PositionService;
import com.bkweb.modules.position.service.ProvinceService;

@Controller
@RequestMapping("${adminPath}/province")
public class ProvinceController extends BaseController {

	@Autowired
	private ProvinceService provinceService;

	@Autowired
	private PositionService positionService;

	@RequestMapping("list")
	public String findList(Province province, Integer pageNum, Model model) {
		HPage<Province> page = new HPage<Province>(pageNum);
		provinceService.findPageList(province, true, page, "nation", "nation.continent");
		model.addAttribute("page", page);
		model.addAttribute("province", province);
		return "position/province/list";
	}

	@RequestMapping("save")
	public String save(Province province, RedirectAttributes attributes) {
		provinceService.saveOrUpdate(province);
		addRedirectMessage(attributes, "保存省会成功");
		return "redirect:" + adminPath + "/province/list";
	}

	@RequestMapping("edit")
	public String edit(Province province, Model model) {
		if (province != null && !StringUtils.isEmpty(province.getId())) {
			province = provinceService.get(province);
		}

		model.addAttribute("province", province);
		return "position/province/save";
	}

	@RequestMapping("del")
	public String delete(Province province, RedirectAttributes attributes) {
		provinceService.trueDelete(province);
		addRedirectMessage(attributes, "删省会成功");
		return "redirect:" + adminPath + "/province/list";
	}
}

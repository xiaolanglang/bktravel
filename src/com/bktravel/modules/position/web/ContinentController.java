package com.bktravel.modules.position.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bktravel.common.web.BaseController;
import com.bktravel.modules.position.entity.Continent;
import com.bktravel.modules.position.service.ContinentService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;

@Controller
@RequestMapping("${adminPath}/continent")
public class ContinentController extends BaseController {
	@Autowired
	private ContinentService continentService;

	@RequestMapping("list")
	public String findList(Continent continent, Integer pageNum, Model model) {
		HPage<Continent> page = new HPage<Continent>(pageNum);
		continentService.findPageList(continent, true, page);
		model.addAttribute("page", page);
		model.addAttribute("continent", continent);
		return "position/continent/list";
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String save(Continent continent, Model model) {
		continentService.saveOrUpdate(continent);
		addMessage(model, "保存洲信息成功");
		return "redirect:" + adminPath + "/continent/list";
	}

	@RequestMapping("edit")
	public String edit(Continent continent, Model model) {
		if (continent != null && !StringUtils.isEmpty(continent.getId())) {
			continent = continentService.get(continent);
		} 

		model.addAttribute("continent", continent);
		return "position/continent/save";
	}

	@RequestMapping("del")
	public String delete(Continent continent, Model model) {
		continentService.trueDelete(continent);
		addMessage(model, "删除洲信息成功");
		return "redirect:" + adminPath + "/continent/list";
	}
}

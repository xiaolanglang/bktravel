package com.bktravel.sys.dict.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bktravel.sys.dict.service.DictionaryService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.sys.dict.entity.Dictionary;

@Controller
@RequestMapping("${adminPath}/dict")
public class DictionaryController extends BaseController {

	@Autowired
	private DictionaryService dictService;

	@RequestMapping("list")
	public String findList(Dictionary dictionary, Integer pageNum, Model model) {
		HPage<Dictionary> page = new HPage<Dictionary>(pageNum);
		dictService.findPageList(dictionary, true, page);
		model.addAttribute("page", page);
		model.addAttribute("dictionary", dictionary);
		model.addAttribute("types", dictService.findAllTypes());
		return "sys/dict/list";
	}

	@RequestMapping("save")
	public String save(Dictionary dictionary, RedirectAttributes attributes) {
		dictService.saveOrUpdate(dictionary);
		addRedirectMessage(attributes, "保存字典成功");
		return "redirect:" + adminPath + "/dict/list";
	}

	@RequestMapping("edit")
	public String edit(Dictionary dictionary, Model model) {
		if (dictionary != null && !StringUtils.isEmpty(dictionary.getId())) {
			dictionary = dictService.get(dictionary);
		}

		model.addAttribute("dictionary", dictionary);
		return "sys/dict/save";
	}

	@RequestMapping("del")
	public String delete(Dictionary dictionary, RedirectAttributes attributes) {
		dictService.trueDelete(dictionary);
		addRedirectMessage(attributes, "删除字典成功");
		return "redirect:" + adminPath + "/dict/list";
	}
}

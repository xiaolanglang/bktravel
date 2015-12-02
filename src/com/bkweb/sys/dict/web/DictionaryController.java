package com.bkweb.sys.dict.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.common.web.BaseController;
import com.bkweb.sys.dict.entity.Dictionary;
import com.bkweb.sys.dict.service.DictionaryService;

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
	public String save(Dictionary dictionary, Model model) {
		dictService.saveOrUpdate(dictionary);
		addMessage(model, "添加城市信息成功");
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
	public String delete(Dictionary dictionary, Model model) {
		dictService.trueDelete(dictionary);
		addMessage(model, "删除洲信息成功");
		return "redirect:" + adminPath + "/dict/list";
	}
}

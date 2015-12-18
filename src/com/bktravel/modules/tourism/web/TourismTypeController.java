package com.bktravel.modules.tourism.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.position.service.PositionService;
import com.bkweb.modules.tourism.entity.TourismType;
import com.bkweb.modules.tourism.service.TourismTypeService;

@Controller
@RequestMapping("${adminPath}/tourismType")
public class TourismTypeController extends BaseController {

	@Autowired
	private TourismTypeService tourismTypeService;

	@Autowired
	private PositionService positionService;

	@RequestMapping("list")
	public String findList(TourismType tourismType, Integer pageNum, Model model) {
		HPage<TourismType> page = new HPage<TourismType>(pageNum);
		tourismTypeService.findPageList(tourismType, true, page);
		model.addAttribute("page", page);
		model.addAttribute("tourismType", tourismType);
		return "tourism/tourismType/list";
	}

	@RequestMapping("save")
	public String save(TourismType tourismType, RedirectAttributes attributes) {
		tourismTypeService.saveOrUpdate(tourismType);
		addRedirectMessage(attributes, "保存旅游类型成功");
		return "redirect:" + adminPath + "/tourismType/list";
	}

	@RequestMapping("edit")
	public String edit(TourismType tourismType, Model model) {
		if (tourismType != null && !StringUtils.isEmpty(tourismType.getId())) {
			tourismType = tourismTypeService.get(tourismType);
		}

		model.addAttribute("tourismType", tourismType);
		return "tourism/tourismType/save";
	}

	@RequestMapping("del")
	public String delete(TourismType tourismType, RedirectAttributes attributes) {
		tourismTypeService.trueDelete(tourismType);
		addRedirectMessage(attributes, "删除旅游类型成功");
		return "redirect:" + adminPath + "/tourismType/list";
	}
}

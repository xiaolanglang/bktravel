package com.bktravel.modules.tourism.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bktravel.modules.position.service.PositionService;
import com.bktravel.modules.tourism.entity.StartPlace;
import com.bktravel.modules.tourism.entity.Tourism;
import com.bktravel.modules.tourism.service.StartPlaceService;
import com.bktravel.modules.tourism.service.TourismService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.common.web.BaseController;

@Controller
@RequestMapping("${adminPath}/tourism")
public class TourismController extends BaseController {

	@Autowired
	private TourismService tourismService;

	@Autowired
	private PositionService positionService;

	@Autowired
	private StartPlaceService startPlaceService;

	@RequestMapping("list")
	public String findList(Tourism tourism, Integer pageNum, Model model) {
		HPage<Tourism> page = new HPage<Tourism>(pageNum);
		tourismService.findPageList(tourism, true, page);
		model.addAttribute("page", page);
		model.addAttribute("tourism", tourism);
		return "tourism/tourism/list";
	}

	@RequestMapping("save_base")
	public String save_base(Tourism tourism, Model model) {
		tourism.setThemes(StringUtils.strsToString(tourism.getTheme()));
		tourism.setStatuses(StringUtils.strsToString(tourism.getStatus()));
		tourism.setStartPlaces(StringUtils.strsToString(tourism.getStartPlace()));

		tourismService.saveOrUpdate(tourism);
		
		return "redirect:" + adminPath + "/tourism/save_price/" + tourism.getId();
	}

	@RequestMapping("save_price/{id}")
	public String save_price(@PathVariable String id, Model model) {
		Tourism tourism = new Tourism();
		tourism.setId(id);
		tourism = tourismService.get(tourism);
		model.addAttribute("tourism", tourism);
		return "tourism/tourism/save_price";
	}

	@RequestMapping("save_price")
	public String save_price(Tourism tourism, Model model) {

		tourismService.saveOrUpdate(tourism);

		tourism = tourismService.get(tourism);
		model.addAttribute("tourism", tourism);

		return "redirect:" + adminPath + "/tourismImg/save_img/" + tourism.getId();
	}

	@RequestMapping("save_expand/{id}")
	public String save_expand(@PathVariable String id, Model model) {

		Tourism tourism = new Tourism();
		tourism.setId(id);

		model.addAttribute("touriam", tourism);

		return "tourism/tourism/save_expand";
	}

	@RequestMapping("save_expand")
	public String save_expand(Tourism tourism, Model model) {
		tourism.setThemes(StringUtils.strsToString(tourism.getTheme()));
		tourism.setStatuses(StringUtils.strsToString(tourism.getStatus()));

		// tourismService.saveOrUpdate(tourism);

		addMessage(model, "添加省会信息成功");

		return "redirect:" + adminPath + "/tourism/list";
	}

	@RequestMapping("edit")
	public String edit(Tourism tourism, Model model) {
		if (tourism != null && !StringUtils.isEmpty(tourism.getId())) {
			tourism = tourismService.get(tourism);
			String[] status = tourism.getStatuses().split(",");
			String[] theme = tourism.getThemes().split(",");
			String[] startPlace = tourism.getStartPlaces().split(",");
			tourism.setTheme(theme);
			tourism.setStatus(status);
			tourism.setStartPlace(startPlace);
		} else {
			String[] strs = { "-1" };
			tourism.setTheme(strs);
			tourism.setStatus(strs);
			tourism.setStartPlace(strs);
		}
		model.addAttribute("tourism", tourism);
		model.addAttribute("startPlaces", startPlaceService.findList(new StartPlace(), true));
		return "tourism/tourism/save_base";
	}

	@RequestMapping("del")
	public String delete(Tourism tourism, Model model) {
		tourismService.trueDelete(tourism);
		addMessage(model, "删除洲信息成功");
		return "redirect:" + adminPath + "/tourism/list";
	}

}

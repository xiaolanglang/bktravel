package com.bktravel.modules.tourism.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bktravel.common.web.BaseController;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.position.service.CPositionService;
import com.bkweb.modules.tourism.entity.StartPlace;
import com.bkweb.modules.tourism.entity.Tourism;
import com.bkweb.modules.tourism.service.CStartPlaceService;
import com.bkweb.modules.tourism.service.CTourismService;

@Controller
@RequestMapping("${adminPath}/tourism")
public class TourismController extends BaseController {

	@Autowired
	private CTourismService tourismService;

	@Autowired
	private CPositionService positionService;

	@Autowired
	private CStartPlaceService startPlaceService;

	@RequestMapping("list")
	@RequiresPermissions("tourism:list")
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
	public String save_expand(Tourism tourism, RedirectAttributes attributes) {
		tourism.setThemes(StringUtils.strsToString(tourism.getTheme()));
		tourism.setStatuses(StringUtils.strsToString(tourism.getStatus()));

		// tourismService.saveOrUpdate(tourism);

		addRedirectMessage(attributes, "保存基础信息成功");

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
	public String delete(Tourism tourism, RedirectAttributes attributes) {
		tourismService.trueDelete(tourism);
		addRedirectMessage(attributes, "删除旅行信息成功");
		return "redirect:" + adminPath + "/tourism/list";
	}

}

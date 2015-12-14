package com.bktravel.modules.tourism.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bktravel.common.web.BaseController;
import com.bktravel.modules.tourism.entity.Tourism;
import com.bktravel.modules.tourism.entity.TourismImg;
import com.bktravel.modules.tourism.service.TourismImgService;

@Controller
@RequestMapping("${adminPath}/tourismImg")
public class TourismImgController extends BaseController {
	@Autowired
	private TourismImgService tourismImgService;

	@RequestMapping("list")
	@ResponseBody
	public Object findList(Tourism tourism) {
		TourismImg tourismImg = new TourismImg();
		tourismImg.setTourism(tourism);
		return tourismImgService.findList(tourismImg, true, "tourism");
	}

	@RequestMapping("save")
	@ResponseBody
	public String save(Tourism tourism, HttpServletRequest request) {
		tourismImgService.save(tourism, request);
		return "SUCCSEE";
	}

	@RequestMapping("save_img/{id}")
	public String edit(@PathVariable String id, Model model) {
		Tourism tourism = new Tourism();
		tourism.setId(id);
		model.addAttribute("tourism", tourism);
		return "tourism/tourism/save_img";
	}

	@RequestMapping("del")
	public String delete(TourismImg tourismImg) {
		tourismImgService.trueDelete(tourismImg);
		return "redirect:" + adminPath + "/tourismImg/list";
	}
}

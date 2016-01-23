package com.bktravel.modules.tourism.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bktravel.common.utils.QiNiuUtils;
import com.bktravel.common.web.BaseController;
import com.bktravel.modules.tourism.service.TourismImgService;
import com.bkweb.common.utils.FileUtils;
import com.bkweb.common.web.Result;
import com.bkweb.modules.tourism.entity.Tourism;
import com.bkweb.modules.tourism.entity.TourismImg;

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
	public Object save(String id, String type, HttpServletRequest request) {
		Tourism tourism = new Tourism();
		tourism.setId(id);
		TourismImg tourismImg = new TourismImg();
		tourismImg.setTourism(tourism);
		tourismImg.setType(type);
		Result result = new Result();
		tourismImgService.save(tourismImg, request, result);
		return result;
	}

	@RequestMapping("save_img/{id}")
	public String edit(@PathVariable String id, Model model) {
		Tourism tourism = new Tourism();
		tourism.setId(id);
		model.addAttribute("tourism", tourism);
		return "tourism/tourism/save_img";
	}

	@RequestMapping("del")
	@ResponseBody
	public String delete(TourismImg tourismImg) {
		tourismImg = tourismImgService.get(tourismImg);
		if (FileUtils.delFile(tourismImg.getLocalUrl())) {
			tourismImgService.trueDelete(tourismImg);
			// 七牛删除
			QiNiuUtils.del(QiNiuUtils.getFileName(tourismImg.getUrl()));
		}
		return "redirect:" + adminPath + "/tourismImg/list";
	}

	@RequestMapping("cover")
	@ResponseBody
	public String cover(TourismImg tourismImg) {
		tourismImgService.cover(tourismImg);
		return "redirect:" + adminPath + "/tourismImg/list";
	}
}

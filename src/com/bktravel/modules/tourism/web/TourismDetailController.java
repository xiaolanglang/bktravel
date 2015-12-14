package com.bktravel.modules.tourism.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bktravel.common.web.BaseController;
import com.bktravel.modules.position.service.PositionService;
import com.bktravel.modules.tourism.entity.Tourism;
import com.bktravel.modules.tourism.entity.TourismDetail;
import com.bktravel.modules.tourism.service.TourismDetailService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.common.utils.hibernatepage.HPage;

@Controller
@RequestMapping("${adminPath}/tourismDetail")
public class TourismDetailController extends BaseController {

	@Autowired
	private TourismDetailService tourismDetailService;

	@Autowired
	private PositionService positionService;

	@RequestMapping("list")
	public String findList(TourismDetail tourismDetail, Integer pageNum, Model model) {
		HPage<TourismDetail> page = new HPage<TourismDetail>(pageNum);
		tourismDetailService.findPageList(tourismDetail, true, page);
		model.addAttribute("page", page);
		model.addAttribute("tourismDetail", tourismDetail);
		return "tourism/tourismDetail/list";
	}

	@RequestMapping("save")
	public String save(TourismDetail tourismDetail, Model model) {
		// tourismDetailService.saveOrUpdate(tourismDetail);
		addMessage(model, "保存省会信息成功");

		model.addAttribute("tourism", new Tourism());

		return "redirect:" + adminPath + "/tourism/save_expand/" + tourismDetail.getTourism().getId();
	}

	@RequestMapping("save_detail/{id}")
	public String edit(TourismDetail tourismDetail, Model model) {
		if (tourismDetail != null && !StringUtils.isEmpty(tourismDetail.getId())) {
			tourismDetail = tourismDetailService.get(tourismDetail);
		}

		model.addAttribute("tourismDetail", new TourismDetail());

		return "tourism/tourism/save_route";
	}

	@RequestMapping("del")
	public String delete(TourismDetail tourismDetail, Model model) {
		tourismDetailService.trueDelete(tourismDetail);
		addMessage(model, "删除洲信息成功");
		return "redirect:" + adminPath + "/tourismDetail/list";
	}
}

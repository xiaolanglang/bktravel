package com.bktravel.modules.tourism.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.modules.tourism.entity.TourismImg;
import com.bkweb.modules.tourism.service.CTourismService;

@Service
@Transactional
public class TourismService extends CTourismService {
	public List<TourismImg> searchPageList(Model model, String content, Integer pageNum, boolean flag) {
		HPage<TourismImg> page = new HPage<TourismImg>(pageNum);
		model.addAttribute("page", page);
		return dao.searchPageList(content, flag, page);
	}

	public List<TourismImg> searchSortPageList(Model model, String content, Integer pageNum, boolean flag) {
		HPage<TourismImg> page = new HPage<TourismImg>(pageNum);
		model.addAttribute("page", page);
		return dao.searchSortPageList(content, flag, page);
	}
}
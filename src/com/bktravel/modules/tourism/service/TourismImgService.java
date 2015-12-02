package com.bktravel.modules.tourism.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.tourism.dao.TourismImgDao;
import com.bktravel.modules.tourism.entity.Tourism;
import com.bktravel.modules.tourism.entity.TourismImg;
import com.bkweb.common.config.Global;
import com.bkweb.common.service.impl.CrudService;
import com.bkweb.common.utils.FileUploadUtils;
import com.bkweb.common.utils.IdUtils;

@Service
@Transactional
public class TourismImgService extends CrudService<TourismImgDao, TourismImg> {
	
	public void save(Tourism tourism, HttpServletRequest request) {
		TourismImg tourismImg = new TourismImg();
		tourismImg.setTourism(tourism);

		String fileName = IdUtils.uuid();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String date = format.format(new Date());

		String url = Global.getConfig("file.imgLocalPath") + "/" + date;

		File file = FileUploadUtils.upload(request, FileUploadUtils.getPath(url), fileName);

		String name = file.getName();
		tourismImg.setUrl(url + "/" + name);
		tourismImg.setName(name.substring(0, name.lastIndexOf(".")));
		tourismImg.setSize(((double) file.length()) / 1200 / 1200);
		saveOrUpdate(tourismImg);
	}
}

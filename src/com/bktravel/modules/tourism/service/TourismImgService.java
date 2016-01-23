package com.bktravel.modules.tourism.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.common.utils.QiNiuUtils;
import com.bkweb.common.utils.FileUploadUtils;
import com.bkweb.common.utils.FileUtils;
import com.bkweb.common.utils.IdUtils;
import com.bkweb.common.web.Result;
import com.bkweb.modules.tourism.entity.TourismImg;
import com.bkweb.modules.tourism.service.CTourismImgService;

@Service
@Transactional
public class TourismImgService extends CTourismImgService {

	/**
	 * 先把文件保存到磁盘中，然后判断文件大小，如果尺寸不符合，就删除磁盘中的文件，如果符合就保存信息
	 * 
	 * @param tourismImg
	 * @param request
	 * @param result
	 */
	public void save(TourismImg tourismImg, HttpServletRequest request, Result result) {

		if (checkSave(tourismImg)) {
			result.setCode("500");
			result.setMessage("已经有对应的图片了，请先删除之前的图片");
			return;
		}

		File file = FileUploadUtils.upload(request, FileUploadUtils.getDefaultImgLocalUrl(), IdUtils.uuid());

		boolean flag = checkImgSize(tourismImg.getType(), file, result);
		if (flag) {
			String name = file.getName();
			tourismImg.setUrl(FileUploadUtils.getDefaultImgUrl(request, name));
			tourismImg.setLocalUrl(file.getAbsolutePath());
			tourismImg.setName(name.substring(0, name.lastIndexOf(".")));
			tourismImg.setSize(((double) file.length()) / 1200 / 1200);
			saveOrUpdate(tourismImg);
			result.setCode("200");
			result.setMessage("上传图片成功");
			// 七牛上传
			QiNiuUtils.put(file, QiNiuUtils.getFileName(tourismImg.getUrl()));
		} else {
			FileUtils.deleteFile(file.getAbsolutePath());
		}

	}

	/**
	 * 检查是否已经存在图片了
	 * 
	 * @param tourismImg
	 * @return
	 */
	private boolean checkSave(TourismImg tourismImg) {
		List<TourismImg> t = dao.findList(tourismImg, false, "tourism");
		if (t == null || t.size() <= 0) {
			return false;

		}
		return true;
	}

	public void cover(TourismImg tourismImg) {
		tourismImg = get(tourismImg);
		dao.clearCover(tourismImg.getTourism().getId());
		// 1为封面
		tourismImg.setCover("1");
		update(tourismImg);
	}

	/**
	 * 检查图片的宽高
	 * 
	 * @param type
	 * @param file
	 * @param result
	 * @return
	 */
	private boolean checkImgSize(String type, File file, Result result) {
		BufferedImage sourceImg = null;
		int width = 0;
		int height = 0;
		boolean flag = false;
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			sourceImg = ImageIO.read(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		width = sourceImg.getWidth();
		height = sourceImg.getHeight();
		switch (type) {
		case "0":
			if (width == 640 && height == 225) {
				flag = true;
			} else {
				result.setMessage("上传失败,请确保图片大小为640*225");
			}
			break;
		case "1":
			if (width == 320 && height == 220) {
				flag = true;
			} else {
				result.setMessage("上传失败,请确保图片大小为320*220");
			}
			break;
		case "2":
			if (width == 600 && height == 250) {
				flag = true;
			} else {
				result.setMessage("上传失败,请确保图片大小为600*250");
			}
			break;
		case "3":
			if (width == 200 && height == 200) {
				flag = true;
			} else {
				result.setMessage("上传失败,请确保图片大小为200*200");
			}
			break;
		default:
			break;
		}
		if (!flag) {
			result.setCode("500");
		}

		return flag;
	}
}

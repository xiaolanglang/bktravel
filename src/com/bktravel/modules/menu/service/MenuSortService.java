package com.bktravel.modules.menu.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.common.utils.QiNiuUtils;
import com.bkweb.common.utils.FileUploadUtils;
import com.bkweb.common.utils.FileUtils;
import com.bkweb.common.utils.IdUtils;
import com.bkweb.common.utils.ImageUtils;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.modules.menu.entity.MenuSort;
import com.bkweb.modules.menu.service.CMenuSortService;

@Service
@Transactional(readOnly = true)
public class MenuSortService extends CMenuSortService {

	public List<MenuSort> findAllParentList() {
		return dao.findAllParentList();
	}

	@Transactional(readOnly = false)
	public boolean save(HttpServletRequest request, MenuSort menusort) {
		File file = FileUploadUtils.upload(request, FileUploadUtils.getDefaultImgLocalUrl(), IdUtils.uuid());
		if (file != null) {
			if (!ImageUtils.checkImage(file, 600, 400)) {
				FileUtils.deleteFile(file.getAbsolutePath());
				return false;
			}
			if (!StringUtils.isEmpty(menusort.getId())) {
				MenuSort menuSort2 = dao.get(menusort);
				String localUrl = menuSort2.getImageLocal();
				String url = menuSort2.getImageUrl();
				if (!StringUtils.isEmpty(localUrl)) {
					FileUtils.deleteFile(localUrl);
				}
				// 七牛删除文件
				if (!StringUtils.isEmpty(url)) {
					QiNiuUtils.del(QiNiuUtils.getFileName(url));
				}
			}
			menusort.setImageUrl(FileUploadUtils.getDefaultImgUrl(request, file.getName()));
			menusort.setImageLocal(file.getAbsolutePath());
			// 七牛上传文件
			QiNiuUtils.put(file, QiNiuUtils.getFileName(menusort.getImageUrl()));
		}
		dao.saveOrUpdate(menusort);
		return true;
	}

	public List<MenuSort> findAllSortList() {
		return dao.findAllSortList();
	}

}

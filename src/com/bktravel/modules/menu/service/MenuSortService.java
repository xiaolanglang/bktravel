package com.bktravel.modules.menu.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
				// TODO 删除
				return false;
			}
			if (!StringUtils.isEmpty(menusort.getId())) {
				String url = dao.get(menusort).getImageLocal();
				if (!StringUtils.isEmpty(url)) {
					FileUtils.deleteFile(url);
				}
			}
			menusort.setImageUrl(FileUploadUtils.getDefaultImgUrl(request, file.getName()));
			menusort.setImageLocal(file.getAbsolutePath());
		}
		dao.saveOrUpdate(menusort);
		// TODO 上传
		return true;
	}

	public List<MenuSort> findAllSortList() {
		return dao.findAllSortList();
	}

}

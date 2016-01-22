package com.bktravel.modules.menu.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.utils.FileUploadUtils;
import com.bkweb.common.utils.FileUtils;
import com.bkweb.common.utils.IdUtils;
import com.bkweb.common.utils.ImageUtils;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.modules.menu.entity.MenuFind;
import com.bkweb.modules.menu.service.CMenuFindService;

@Service
@Transactional(readOnly = true)
public class MenuFindService extends CMenuFindService {

	@Transactional(readOnly = false)
	public boolean save(HttpServletRequest request, MenuFind menuFind) {
		File file = FileUploadUtils.upload(request, FileUploadUtils.getDefaultImgLocalUrl(), IdUtils.uuid());
		if (file != null) {
			if (!ImageUtils.checkImage(file, 500, 255)) {
				FileUtils.deleteFile(file.getAbsolutePath());
				return false;
			}
			if (!StringUtils.isEmpty(menuFind.getId())) {
				String url = dao.get(menuFind).getLocalUrl();
				if (!StringUtils.isEmpty(url)) {
					FileUtils.deleteFile(url);
				}
			}
			menuFind.setImage(FileUploadUtils.getDefaultImgUrl(request, file.getName()));
			menuFind.setLocalUrl(file.getAbsolutePath());
		}
		dao.saveOrUpdate(menuFind);
		return true;
	}

}

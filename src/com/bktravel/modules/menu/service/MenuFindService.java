package com.bktravel.modules.menu.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.common.utils.QiNiuUtils;
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
			// 检查是更新还是添加
			if (!StringUtils.isEmpty(menuFind.getId())) {
				MenuFind menuFind2 = dao.get(menuFind);
				String localUrl = menuFind2.getLocalUrl();
				String url = menuFind2.getImage();

				if (!StringUtils.isEmpty(localUrl)) {
					FileUtils.deleteFile(localUrl);
				}
				// 七牛删除文件
				if (!StringUtils.isEmpty(url)) {
					QiNiuUtils.del(QiNiuUtils.getFileName(url));
				}
			}
			menuFind.setImage(FileUploadUtils.getDefaultImgUrl(request, file.getName()));
			menuFind.setLocalUrl(file.getAbsolutePath());
			// 七牛上传文件
			QiNiuUtils.put(file, QiNiuUtils.getFileName(menuFind.getImage()));
		}
		dao.saveOrUpdate(menuFind);
		return true;
	}

}

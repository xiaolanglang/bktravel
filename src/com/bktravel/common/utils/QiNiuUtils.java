package com.bktravel.common.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bktravel.common.config.Global;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @author Administrator
 * 
 */
public class QiNiuUtils {
	private static final String ACCESS_KEY = Global.getConfig("qiniu.access_key");
	private static final String SECRET_KEY = Global.getConfig("qiniu.secret_key");
	private static final String BUCKET = "itravel";

	private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	private UploadManager uploadManager = new UploadManager();
	private BucketManager bucketManager = new BucketManager(auth);

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 上传图片
	 * 
	 * @param bs
	 * @param fileName
	 *            文件名称,例如:img/2013/123.png
	 * @return
	 */
	public boolean put(byte[] bs, String fileName) {
		boolean flag = true;
		try {
			Response res = uploadManager.put(bs, fileName, getUpToken());
			logger.info(res.bodyString());
		} catch (QiniuException e) {
			flag = false;
			try {
				logger.info(e.response.bodyString());
			} catch (QiniuException e1) {
			}
		}
		return flag;
	}

	/**
	 * 上传
	 * 
	 * @param file
	 * @return
	 */
	public boolean put(File file) {
		boolean flag = true;
		try {
			Response res = uploadManager.put(file, file.getName(), getUpToken());
			logger.info(res.bodyString());
		} catch (QiniuException e) {
			flag = false;
			try {
				logger.info(e.response.bodyString());
			} catch (QiniuException e1) {
			}
		}
		return flag;
	}

	/**
	 * 删除
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean del(String fileName) {
		boolean flag = true;
		try {
			bucketManager.delete(BUCKET, fileName);
		} catch (QiniuException e) {
			flag = false;
			try {
				logger.info(e.response.bodyString());
			} catch (QiniuException e1) {
			}
		}
		return flag;
	}

	private String getUpToken() {
		return auth
				.uploadToken(
						BUCKET,
						null,
						3600,
						new StringMap()
								.putNotEmpty("returnBody",
										"{\"key\": $(key), \"hash\": $(etag), \"width\": $(imageInfo.width), \"height\": $(imageInfo.height)}"));
	}

	// private class MyRet {
	// public String key;
	// public String hash;
	// public int width;
	// public int height;
	//
	// @Override
	// public String toString() {
	// return ReflectionToStringBuilder.toString(this);
	// }
	// }
}

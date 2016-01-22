package test;

import java.io.File;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class TestQiNiu {
	String ACCESS_KEY = "";
	String SECRET_KEY = "";
	private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	private UploadManager uploadManager = new UploadManager();
	private static final String BUCKET = "itravel";
	private BucketManager bucketManager = new BucketManager(auth);
	private String file1 = "C:\\Users\\Administrator\\Desktop\\test.png";
	private File file = new File(file1);

	@Test
	public void put() {
		try {
			Response res = uploadManager.put(file, file.getName(), getUpToken());
			MyRet ret = res.jsonToObject(MyRet.class);
			System.out.println(ret);
		} catch (QiniuException e) {
			Response r = e.response;
			try {
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
	}

	@Test
	public void del() {
		try {
			bucketManager.delete(BUCKET, file.getName());
		} catch (QiniuException e) {
			Response r = e.response;
			try {
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
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

	private class MyRet {
		public String key;
		public String hash;
		public int width;
		public int height;

		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}
	}
}

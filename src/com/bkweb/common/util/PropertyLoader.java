package com.bkweb.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class PropertyLoader {
	private Properties properties;
	/**
	 * 静态变量的好处就是下一次再调用的时候，不会再实例化一个对象，好处就是节约内存 <br>
	 * 这里使用静态类型是因为resourceLoader并没有涉及到对象属性的改变
	 */
	private static ResourceLoader resourceLoader = new DefaultResourceLoader();

	public PropertyLoader(String url) {
		properties = getProperties(url);
	}

	private Properties getProperties(String url) {
		InputStream inputStream = null;
		Properties properties = new Properties();
		Resource resource = resourceLoader.getResource(url);
		try {
			inputStream = resource.getInputStream();
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
		return properties;
	}

	public String getValue(String key) {
		if (!MyUtil.isEmpty(key)) {
			return "";
		}
		if (properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return "";
	}
}

package com.bktravel.common.tld;

import java.util.List;
import java.util.Map;

import com.bktravel.common.config.Global;
import com.bktravel.common.utils.DictUtils;
import com.bktravel.sys.dict.entity.Dictionary;
import com.bkweb.common.util.PropertyLoader;
import com.bkweb.common.utils.hibernatepage.HPage;
import com.bkweb.common.utils.hibernatepage.HpageUtils;
import com.google.common.collect.Maps;

public class Message {

	/**
	 * 属性文件加载对象
	 */
	private static PropertyLoader propertyLoader = new PropertyLoader(Global.PROPERTIES_PATH);

	private static Map<String, String> map = Maps.newHashMap();

	/**
	 * 获取配置
	 * 
	 * @see ${msg:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = propertyLoader.getValue(key);
			map.put(key, value != null ? value : null);
		}
		return value;
	}

	public static String getDictLabel(String value, String type) {
		return DictUtils.getDictLabel(value, type);
	}

	/**
	 * @param values
	 *            like 1,2,3
	 * @param type
	 * @return
	 */
	public static String getDictLabels(String values, String type) {
		return DictUtils.getDictLabels(values, type);
	}

	public static List<Dictionary> getDictList(String type) {
		return DictUtils.getDictList(type);
	}

	public static String page(HPage<?> page) {
		return HpageUtils.page(page);
	}

}

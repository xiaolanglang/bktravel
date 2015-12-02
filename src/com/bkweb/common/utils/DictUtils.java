package com.bkweb.common.utils;

import java.util.List;
import java.util.Map;

import com.bkweb.sys.dict.dao.DictionaryDao;
import com.bkweb.sys.dict.entity.Dictionary;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 字典工具类
 * 
 * @author ThinkGem
 * @version 2013-5-29
 */
public class DictUtils {

	private static DictionaryDao dictDao = SpringContextHolder.getBean(DictionaryDao.class);
	private static Map<String, List<Dictionary>> dictMap = null;
	private static String defaultValue = "无";

	/**
	 * 待优化
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	public static String getDictLabel(String value, String type) {
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)) {
			for (Dictionary dict : getDictList(type)) {
				if (type.equals(dict.getType()) && value.equals(dict.getValue())) {
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}

	/**
	 * 待优化
	 * 
	 * @param values
	 * @param type
	 * @return
	 */
	public static String getDictLabels(String values, String type) {
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)) {
			List<String> valueList = Lists.newArrayList();
			for (String value : StringUtils.split(values, ",")) {
				valueList.add(getDictLabel(value, type));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultValue;
	}

	/**
	 * 待优化
	 * 
	 * @param label
	 * @param type
	 * @return
	 */
	public static String getDictValue(String label, String type) {
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)) {
			for (Dictionary dict : getDictList(type)) {
				if (type.equals(dict.getType()) && label.equals(dict.getLabel())) {
					return dict.getValue();
				}
			}
		}
		return defaultValue;
	}

	/**
	 * 根据字典类型找到字典集合
	 * 
	 * @param type
	 * @return
	 */
	public static List<Dictionary> getDictList(String type) {
		if (dictMap == null) {
			dictMap = Maps.newHashMap();
			for (Dictionary dict : dictDao.findAllList(Dictionary.class, true)) {
				List<Dictionary> dictList = dictMap.get(dict.getType());
				if (dictList != null) {
					dictList.add(dict);
				} else {
					dictMap.put(dict.getType(), Lists.newArrayList(dict));
				}
			}
		}
		List<Dictionary> dictList = dictMap.get(type);
		if (dictList == null) {
			dictList = Lists.newArrayList();
		}
		return dictList;
	}

}

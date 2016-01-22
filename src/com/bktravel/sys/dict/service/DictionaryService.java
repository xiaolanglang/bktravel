package com.bktravel.sys.dict.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.utils.StringUtils;
import com.bkweb.sys.dict.entity.Dictionary;

@Transactional
public class DictionaryService extends com.bkweb.sys.dict.service.CDictionaryService {
	/**
	 * 找出一个类型中的最大的value值
	 * 
	 * @param dictionary
	 * @return
	 */
	public int getMaxValueByType(Dictionary dictionary) {
		return dao.getMaxType(dictionary);
	}

	/**
	 * 获得所有字典类型
	 * 
	 * @return
	 */
	public List<String> findAllTypes() {
		return dao.findAllTypes();
	}

	@Override
	public void saveOrUpdate(Dictionary dictionary) {
		if (StringUtils.isEmpty(dictionary.getId())) {
			int value = getMaxValueByType(dictionary);
			dictionary.setValue(String.valueOf(value + 1));
		}
		super.saveOrUpdate(dictionary);
	}
}

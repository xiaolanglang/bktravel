package com.bkweb.sys.dict.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.sys.dict.dao.DictionaryDao;
import com.bkweb.sys.dict.entity.Dictionary;

@Service
@Transactional
public class DictionaryService extends CrudService<DictionaryDao, Dictionary> {
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

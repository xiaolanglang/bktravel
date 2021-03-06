package com.bktravel.sys.dict.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.bkweb.sys.dict.entity.Dictionary;

public class DictionaryDao extends com.bkweb.sys.dict.dao.CDictionaryDao {

	public int getMaxType(Dictionary dictionary) {
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.max("value"));

		Criterion c = Restrictions.eq("type", dictionary.getType());
		Object result = getCriteria(Dictionary.class).add(c).setProjection(projectionList).uniqueResult();

		if (result != null) {
			return Integer.parseInt(result.toString());
		}

		return -1;
	}

	public List<String> findAllTypes() {
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.groupProperty("type"));

		@SuppressWarnings("unchecked")
		List<String> list = getCriteria(Dictionary.class).setProjection(projectionList).list();
		return list;
	}

}

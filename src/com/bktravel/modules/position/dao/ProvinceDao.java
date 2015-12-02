package com.bktravel.modules.position.dao;

import org.hibernate.Criteria;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.bktravel.modules.position.entity.Continent;
import com.bktravel.modules.position.entity.Nation;
import com.bktravel.modules.position.entity.Province;
import com.bkweb.common.dao.impl.CrudDao;

@Repository
public class ProvinceDao extends CrudDao<Province> {

	public void test() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
		Continent continent = new Continent();
		Nation nation = new Nation();
		Province province = new Province();
		nation.setContinent(continent);
		province.setNation(nation);
		Criteria criteria = getCriteria(Province.class);
		criteria.createCriteria("nation.continent", JoinType.LEFT_OUTER_JOIN);
		criteria.createCriteria("nation", JoinType.LEFT_OUTER_JOIN);
		criteria.list();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

}

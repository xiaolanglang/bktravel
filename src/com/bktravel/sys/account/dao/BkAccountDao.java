package com.bktravel.sys.account.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bktravel.sys.account.entity.BkAccount;
import com.bkweb.common.dao.impl.CrudDao;

/**
 * User Dao
 * 
 * @author yourName
 * @version 2015-6-19
 */
@Repository
public class BkAccountDao extends CrudDao<BkAccount> {

	public BkAccount login(String userName, String passWord) {
		Criteria criteria = getCriteria(BkAccount.class);
		criteria.add(Restrictions.eq("username", userName));
		criteria.add(Restrictions.eq("password", passWord));
		@SuppressWarnings("unchecked")
		List<BkAccount> list = criteria.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}

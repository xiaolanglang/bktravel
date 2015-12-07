package com.bktravel.sys.purview.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bktravel.sys.account.entity.Account;
import com.bktravel.sys.purview.entity.Role;
import com.bkweb.common.dao.impl.CrudDao;

@Repository
public class RoleDao extends CrudDao<Role> {

	@SuppressWarnings("unchecked")
	public List<Role> findRoleListByAccount(Account account) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from sys_role r ");
		buffer.append("join sys_account_role ar on ar.role_id = r.id ");
		buffer.append("where ar.account_id = :id ");
		return getSession().createSQLQuery(buffer.toString()).addEntity(Role.class).setString("id", account.getId())
				.list();
	}

}

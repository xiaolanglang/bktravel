package com.bktravel.sys.account.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.sys.account.dao.BkAccountDao;
import com.bktravel.sys.account.entity.BkAccount;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional(readOnly = true)
public class BkAccountService extends CrudService<BkAccountDao, BkAccount> {

	public void login(HttpSession session, String userName, String passWord) {
		BkAccount account = dao.login(userName, passWord);
		if (account != null) {
			session.setAttribute("account", account);
		}
	}

}

package com.bktravel.sys.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.utils.StringUtils;
import com.bkweb.sys.account.entity.Account;
import com.bkweb.sys.account.service.CAccountService;

@Service
@Transactional(readOnly = true)
public class AccountService extends CAccountService {

	public boolean checkRegister(Account account) {
		if (StringUtils.isEmpty(account.getUsername()) || StringUtils.isEmpty(account.getPassword())) {
			return false;
		}
		List<Account> list = findList(new Account(account.getUsername(), null), false);
		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}

}

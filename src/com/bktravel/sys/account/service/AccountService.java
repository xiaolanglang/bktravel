package com.bktravel.sys.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.sys.account.dao.AccountDao;
import com.bktravel.sys.account.entity.Account;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional(readOnly = true)
public class AccountService extends CrudService<AccountDao, Account> {

}

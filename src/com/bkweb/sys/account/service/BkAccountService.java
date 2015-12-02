package com.bkweb.sys.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.sys.account.dao.BkAccountDao;
import com.bkweb.sys.account.entity.BkAccount;

@Service
@Transactional(readOnly = true)
public class BkAccountService extends CrudService<BkAccountDao, BkAccount> {

}

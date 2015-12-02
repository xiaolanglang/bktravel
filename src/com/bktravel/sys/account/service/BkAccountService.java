package com.bktravel.sys.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.sys.account.dao.BkAccountDao;
import com.bktravel.sys.account.entity.BkAccount;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional(readOnly = true)
public class BkAccountService extends CrudService<BkAccountDao, BkAccount> {

}

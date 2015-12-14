package com.bktravel.sys.authority.service;

import org.springframework.stereotype.Service;

import com.bktravel.sys.authority.dao.AccountRoleDao;
import com.bktravel.sys.authority.entity.AccountRole;
import com.bkweb.common.service.impl.CrudService;

@Service
public class AccountRoleService extends CrudService<AccountRoleDao, AccountRole> {

}

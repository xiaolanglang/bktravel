package com.bktravel.sys.purview.service;

import org.springframework.stereotype.Service;

import com.bktravel.sys.purview.dao.AccountRoleDao;
import com.bktravel.sys.purview.entity.AccountRole;
import com.bkweb.common.service.impl.CrudService;

@Service
public class AccountRoleService extends CrudService<AccountRoleDao, AccountRole> {

}

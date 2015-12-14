package com.bktravel.sys.authority.service;

import org.springframework.stereotype.Service;

import com.bktravel.sys.authority.dao.RoleDao;
import com.bktravel.sys.authority.entity.Role;
import com.bkweb.common.service.impl.CrudService;

@Service
public class RoleService extends CrudService<RoleDao, Role> {

}

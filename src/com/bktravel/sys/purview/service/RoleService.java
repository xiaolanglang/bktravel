package com.bktravel.sys.purview.service;

import org.springframework.stereotype.Service;

import com.bktravel.sys.purview.dao.RoleDao;
import com.bktravel.sys.purview.entity.Role;
import com.bkweb.common.service.impl.CrudService;

@Service
public class RoleService extends CrudService<RoleDao, Role> {

}

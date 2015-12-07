package com.bktravel.sys.purview.service;

import org.springframework.stereotype.Service;

import com.bktravel.sys.purview.dao.RolePermissionsDao;
import com.bktravel.sys.purview.entity.RolePer;
import com.bkweb.common.service.impl.CrudService;

@Service
public class RoleAuthService extends CrudService<RolePermissionsDao, RolePer> {

}

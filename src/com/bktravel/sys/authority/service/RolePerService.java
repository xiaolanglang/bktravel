package com.bktravel.sys.authority.service;

import org.springframework.stereotype.Service;

import com.bktravel.sys.authority.dao.RolePermissionsDao;
import com.bktravel.sys.authority.entity.RolePermission;
import com.bkweb.common.service.impl.CrudService;

@Service
public class RolePerService extends CrudService<RolePermissionsDao, RolePermission> {

}

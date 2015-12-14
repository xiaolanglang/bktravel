package com.bktravel.sys.authority.service;

import org.springframework.stereotype.Service;

import com.bktravel.sys.authority.dao.PermissionsDao;
import com.bktravel.sys.authority.entity.Permissions;
import com.bkweb.common.service.impl.CrudService;

@Service
public class PermissionsService extends CrudService<PermissionsDao, Permissions> {

}

package com.bktravel.sys.purview.service;

import org.springframework.stereotype.Service;

import com.bktravel.sys.purview.dao.PermissionsDao;
import com.bktravel.sys.purview.entity.Permissions;
import com.bkweb.common.service.impl.CrudService;

@Service
public class PermissionsService extends CrudService<PermissionsDao, Permissions> {

}

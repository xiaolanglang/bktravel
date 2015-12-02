package com.bktravel.modules.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.user.dao.BkUserDao;
import com.bktravel.modules.user.entity.BkUser;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class BkUserService extends CrudService<BkUserDao, BkUser> {

}

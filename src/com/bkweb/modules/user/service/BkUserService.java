package com.bkweb.modules.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.user.dao.BkUserDao;
import com.bkweb.modules.user.entity.BkUser;

@Service
@Transactional
public class BkUserService extends CrudService<BkUserDao, BkUser> {

}

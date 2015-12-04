package com.bktravel.sys.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.sys.user.dao.UserDao;
import com.bktravel.sys.user.entity.User;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class UserService extends CrudService<UserDao, User> {

}

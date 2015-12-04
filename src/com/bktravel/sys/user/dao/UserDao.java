package com.bktravel.sys.user.dao;

import org.springframework.stereotype.Repository;

import com.bktravel.sys.user.entity.User;
import com.bkweb.common.dao.impl.CrudDao;

@Repository
public class UserDao extends CrudDao<User> {
}

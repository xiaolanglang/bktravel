package com.bkweb.modules.user.dao;

import org.springframework.stereotype.Repository;

import com.bkweb.common.dao.impl.CrudDao;
import com.bkweb.modules.user.entity.BkUser;

@Repository
public class BkUserDao extends CrudDao<BkUser> {
}

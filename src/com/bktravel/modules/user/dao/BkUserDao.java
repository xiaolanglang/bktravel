package com.bktravel.modules.user.dao;

import org.springframework.stereotype.Repository;

import com.bktravel.modules.user.entity.BkUser;
import com.bkweb.common.dao.impl.CrudDao;

@Repository
public class BkUserDao extends CrudDao<BkUser> {
}

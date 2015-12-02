/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bkweb.sys.log.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.sys.log.dao.LogDao;
import com.bkweb.sys.log.entity.Log;

/**
 * 日志Service
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class LogService extends CrudService<LogDao, Log> {
	
}

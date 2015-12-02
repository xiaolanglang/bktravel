package com.bkweb.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.position.dao.ContinentDao;
import com.bkweb.modules.position.entity.Continent;

@Service
@Transactional
public class ContinentService extends CrudService<ContinentDao, Continent> {

}

package com.bktravel.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.position.dao.ContinentDao;
import com.bktravel.modules.position.entity.Continent;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class ContinentService extends CrudService<ContinentDao, Continent> {

}
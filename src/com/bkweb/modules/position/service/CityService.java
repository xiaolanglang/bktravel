package com.bkweb.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.position.dao.CityDao;
import com.bkweb.modules.position.entity.City;

@Service
@Transactional
public class CityService extends CrudService<CityDao, City> {

}

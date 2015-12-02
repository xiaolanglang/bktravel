package com.bktravel.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.position.dao.CityDao;
import com.bktravel.modules.position.entity.City;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class CityService extends CrudService<CityDao, City> {

}

package com.bktravel.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.position.dao.CountryDao;
import com.bktravel.modules.position.entity.Country;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class CountryService extends CrudService<CountryDao, Country> {

}

package com.bkweb.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.position.dao.CountryDao;
import com.bkweb.modules.position.entity.Country;

@Service
@Transactional
public class CountryService extends CrudService<CountryDao, Country> {

}

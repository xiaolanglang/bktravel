package com.bktravel.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.position.dao.ProvinceDao;
import com.bktravel.modules.position.entity.Province;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class ProvinceService extends CrudService<ProvinceDao, Province> {

}

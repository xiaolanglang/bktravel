package com.bkweb.modules.tourism.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.tourism.dao.TourismTypeDao;
import com.bkweb.modules.tourism.entity.TourismType;

@Service
@Transactional
public class TourismTypeService extends CrudService<TourismTypeDao, TourismType> {

}
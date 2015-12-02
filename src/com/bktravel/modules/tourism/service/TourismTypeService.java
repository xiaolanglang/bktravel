package com.bktravel.modules.tourism.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.tourism.dao.TourismTypeDao;
import com.bktravel.modules.tourism.entity.TourismType;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class TourismTypeService extends CrudService<TourismTypeDao, TourismType> {

}
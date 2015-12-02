package com.bkweb.modules.tourism.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.tourism.dao.TourismDetailDao;
import com.bkweb.modules.tourism.entity.TourismDetail;

@Service
@Transactional
public class TourismDetailService extends CrudService<TourismDetailDao, TourismDetail> {

}
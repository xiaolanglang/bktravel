package com.bktravel.modules.tourism.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.tourism.dao.TourismDetailDao;
import com.bktravel.modules.tourism.entity.TourismDetail;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class TourismDetailService extends CrudService<TourismDetailDao, TourismDetail> {

}
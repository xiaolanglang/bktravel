package com.bktravel.modules.tourism.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.tourism.dao.TourismDao;
import com.bktravel.modules.tourism.entity.Tourism;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class TourismService extends CrudService<TourismDao, Tourism> {
}
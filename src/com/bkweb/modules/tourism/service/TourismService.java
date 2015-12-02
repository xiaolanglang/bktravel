package com.bkweb.modules.tourism.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.tourism.dao.TourismDao;
import com.bkweb.modules.tourism.entity.Tourism;

@Service
@Transactional
public class TourismService extends CrudService<TourismDao, Tourism> {
}
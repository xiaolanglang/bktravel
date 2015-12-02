package com.bktravel.modules.tourism.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.tourism.dao.StartPlaceDao;
import com.bktravel.modules.tourism.entity.StartPlace;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class StartPlaceService extends CrudService<StartPlaceDao, StartPlace> {

}
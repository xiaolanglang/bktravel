package com.bktravel.modules.attraction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.attraction.dao.AttractionDao;
import com.bktravel.modules.attraction.entity.Attraction;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class AttractionService extends CrudService<AttractionDao, Attraction> {

}

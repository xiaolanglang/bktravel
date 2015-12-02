package com.bkweb.modules.attraction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.attraction.dao.AttractionDao;
import com.bkweb.modules.attraction.entity.Attraction;

@Service
@Transactional
public class AttractionService extends CrudService<AttractionDao, Attraction> {

}

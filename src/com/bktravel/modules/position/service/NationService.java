package com.bktravel.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bktravel.modules.position.dao.NationDao;
import com.bktravel.modules.position.entity.Nation;
import com.bkweb.common.service.impl.CrudService;

@Service
@Transactional
public class NationService extends CrudService<NationDao, Nation> {

}

package com.bkweb.modules.position.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.modules.position.dao.NationDao;
import com.bkweb.modules.position.entity.Nation;

@Service
@Transactional
public class NationService extends CrudService<NationDao, Nation> {

}

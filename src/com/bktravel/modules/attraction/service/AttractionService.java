package com.bktravel.modules.attraction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.modules.attraction.service.CAttractionService;

@Service
@Transactional(readOnly = true)
public class AttractionService extends CAttractionService {

}

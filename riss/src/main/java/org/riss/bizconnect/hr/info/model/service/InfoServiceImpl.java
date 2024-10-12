package org.riss.bizconnect.hr.info.model.service;

import org.riss.bizconnect.hr.info.model.dao.InfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("infoService")
public class InfoServiceImpl implements InfoService {
	@Autowired
	private InfoDao infoDao;

}

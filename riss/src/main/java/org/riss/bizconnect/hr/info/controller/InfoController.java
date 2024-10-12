package org.riss.bizconnect.hr.info.controller;

import org.riss.bizconnect.hr.info.model.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InfoController {
	@Autowired
	private InfoService infoService;
}

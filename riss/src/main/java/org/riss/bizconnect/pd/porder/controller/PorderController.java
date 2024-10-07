package org.riss.bizconnect.pd.porder.controller;

import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.riss.bizconnect.pd.porder.dto.PorderDTO;
import org.riss.bizconnect.pd.porder.service.PorderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PorderController {
	
	@Autowired
	private PorderService porderService;
	
	@RequestMapping("porder.do")
	public ModelAndView Pordertest(ModelAndView mv) {
		mv.setViewName("stock/porder");
		ArrayList<PorderDTO> porder = porderService.listAllPorders();
		
		mv.addObject("all", porder);
		
		return mv;
	}
}

/*
@Controller
public class PorderController {
	private static final Logger logger = LoggerFactory.getLogger(PorderController.class);

	
	@Autowired
	private PorderService poderService;
	
	@RequestMapping("nlist.do")
	public ModelAndView test(ModelAndView mv) {
		
		mv.setViewName("home");
		ArrayList<PorderDTO> porder = poderService.selectList();
		
		mv.addObject("one1", porder);
		
		return mv;
	}*/

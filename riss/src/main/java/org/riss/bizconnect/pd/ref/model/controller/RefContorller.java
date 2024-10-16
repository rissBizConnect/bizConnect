package org.riss.bizconnect.pd.ref.model.controller;

import java.util.ArrayList;

import org.riss.bizconnect.pd.ref.model.dto.RefDTO;
import org.riss.bizconnect.pd.ref.model.service.RefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RefContorller {
	
	@Autowired
	private RefService refService;
	
	@RequestMapping("ref.do")
	public ModelAndView Reftest(ModelAndView mv) {
		mv.setViewName("ref/ref");
		ArrayList<RefDTO> ref = refService.listAllRefs();
		
		mv.addObject("all", ref);
		
		return mv;
	}
}

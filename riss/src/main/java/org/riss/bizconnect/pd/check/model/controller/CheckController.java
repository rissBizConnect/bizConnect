package org.riss.bizconnect.pd.check.model.controller;

import java.util.ArrayList;

import org.riss.bizconnect.pd.check.model.dto.CheckDTO;
import org.riss.bizconnect.pd.check.model.service.CheckService;
import org.riss.bizconnect.pd.product.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckController {
	
	@Autowired
	private CheckService checkService;
	
	@RequestMapping("prMenu_check.do")
	public ModelAndView checkhome(ModelAndView mv) {
		
		mv.setViewName("pr/prMenubar/prMenu_check");
		ArrayList<CheckDTO> check = checkService.listAllChecks();
		
		mv.addObject("all", check);
		
		return mv;
	}
	
	@RequestMapping("check.do")
	public ModelAndView Checktest(ModelAndView mv) {
		mv.setViewName("pr/stock/check");
		ArrayList<CheckDTO> check = checkService.listAllChecks();
		
		mv.addObject("all", check);
		
		return mv;
		
	}
}

package org.riss.bizconnect.pd.porder.model.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.pd.porder.model.dto.PorderDTO;
import org.riss.bizconnect.pd.porder.model.service.PorderService;
import org.riss.bizconnect.pd.product.model.dto.ProductDTO;
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
	
	@RequestMapping("prMenu_porder.do")
	public ModelAndView producthome(ModelAndView mv) {
		
		mv.setViewName("pr/prMenubar/prMenu_porder");
		ArrayList<PorderDTO> porder = porderService.listAllPorders();
		
		mv.addObject("all", porder);
		
		return mv;
	}
	
	@RequestMapping("porder.do")
	public ModelAndView Pordertest(ModelAndView mv) {
		mv.setViewName("pr/stock/porder/porder");
		ArrayList<PorderDTO> porder = porderService.listAllPorders();
		
		mv.addObject("all", porder);
		
		return mv;
	}

	@RequestMapping("insertporder.do")
	public ModelAndView insertporder(ModelAndView mv, HttpSession session, HttpServletRequest request) {
		
		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
	    session.setAttribute("loginUser", member);//너도!!!!!!!!!!!!!!!!!!!!!!!!
	     
	    member = (Member)session.getAttribute("loginUser");
		PorderDTO pord = new PorderDTO();

		pord.setLicenseCode(member.getComCode());
		
		pord.setPorderNo(Integer.parseInt(request.getParameter("PorderNo")));

		if(porderService.insertporder(pord) > 0) {
			mv.setViewName("pr/stock/porder/porder");
		}else {
			mv.setViewName("common/error");
		}
		mv.setViewName("pr/stock/porder/porder");
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

package org.riss.bizconnect.pd.porder.model.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.pd.porder.model.dto.PorderDTO;
import org.riss.bizconnect.pd.porder.model.service.PorderService;
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

	@RequestMapping("insertporder.do")
	public ModelAndView insertporder(ModelAndView mv, HttpSession session, HttpServletRequest request) {
	     
	    Member member = (Member)session.getAttribute("loginUser");
		PorderDTO pord = new PorderDTO();

		pord.setLicenseCode(member.getComCode());
		
		pord.setPorderNo(Integer.parseInt(request.getParameter("PorderNo")));

		if(porderService.insertporder(pord) > 0) {
			mv.setViewName("stock/porder");
		}else {
			mv.setViewName("common/error");
		}
		mv.setViewName("stock/porder");
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

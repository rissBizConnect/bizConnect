package org.riss.bizconnect.hr.salary.controller;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.hr.attendance.controller.AttendanceController;
import org.riss.bizconnect.hr.attendance.model.service.AttendanceService;
import org.riss.bizconnect.hr.salary.model.dto.Salary;
import org.riss.bizconnect.hr.salary.model.service.SalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SalaryController {
	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
	
	@Autowired
	private SalaryService salaryService;
	
//	@RequestMapping("moveSalary.do")
//	public ModelAndView moveSalary(
//			HttpSession session, 
//			ModelAndView mv,
//			@RequestParam(name = "page", required = false) String page,
//			@RequestParam(name = "limit", required = false) String slimit,
//			@RequestParam(name = "fileter", required = false) String fileter) {
//		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
//				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
//		session.setAttribute("loginUser", member);
//		
//		int currentPage = 1;
//		if (page != null) {
//			currentPage = Integer.parseInt(page);
//		}
//
//		int limit = 10;
//		if (slimit != null) {
//			limit = Integer.parseInt(slimit);
//		}
//		if (fileter == null) {
//			fileter = "all";
//		}
//		
//		Salary salary = new Salary(((Member)session.getAttribute("loginUser")).getgId(), 
//				((Member)session.getAttribute("loginUser")).getComCode());
//		int listCount = salaryService.selectAllCount(salary.getComCode());
//		Paging paging = new Paging(salary.getComCode(), listCount, limit, currentPage, "moveSalary.do");
//		ArrayList<Salary> list = salaryService.selectAll(paging);
//
//		mv.addObject("list",list);
//		mv.addObject("paging", paging);
//		mv.setViewName("hr/salary");
//		return mv;
//	}
	
	@RequestMapping("moveSalary.do")
	public ModelAndView moveSalary(
			HttpSession session, 
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit,
			@RequestParam(name = "fileter", required = false) String fileter,
			@RequestParam(name = "keyword", required = false) String keyword,
			HttpServletRequest request,
			ModelAndView mv) {

		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);

		String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}
		if (fileter == null) {
			fileter = "all";
		}
		logger.info("asd");
		if(fileter.equals("keyword")) {
			logger.info("asd2");
			Search search = new Search();
			search.setKeyword("%"+ keyword +"%");
			search.setComCode(myCom);
			
			int listCount = salaryService.selectKeywordCount(search);
			Paging paging = new Paging(myCom, listCount, limit, currentPage, "moveSalary.do");
			search.setStartRow(paging.getStartRow());
			search.setEndRow(paging.getEndRow());
			
			ArrayList<Salary> list = salaryService.selectKeyword(search);
			
			mv.addObject("fileter", fileter);
			mv.addObject("keyword", keyword);
			mv.addObject("list", list);
			mv.addObject("paging", paging);
		}else if(fileter.equals("all")) {
			int listCount = salaryService.selectAllCount(myCom);	
			Paging paging = new Paging(myCom, listCount, limit, currentPage, "moveSalary.do");
			ArrayList<Salary> list = salaryService.selectAll(paging);

			
			mv.addObject("list", list);
			mv.addObject("paging", paging);
		}else if(fileter == "date") {
			
		}

		mv.addObject("fileter", fileter);

		mv.setViewName("hr/salary");
		return mv;
	}
	
	@RequestMapping("salaryDelete.do")
	public String salaryDelete(
			HttpSession session,
			HttpServletRequest request,
			@RequestParam("gId") String gId,
			@RequestParam("salaryno") int salaryno) {
		
		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);
		
		String myCom = ((Member)session.getAttribute("loginUser")).getComCode();
		Salary salary = new Salary();
		
		salary.setComCode(myCom);
		salary.setgId(gId);
		salary.setSalaryNo(salaryno);
		
		if(salaryService.deleteMember(salary) != 1) {
			return "common/error";
		}
					
		return "redirect:moveSalary.do";
	}
}

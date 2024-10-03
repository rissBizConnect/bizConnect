package org.riss.bizconnect.hr.attendance.controller;

import java.lang.reflect.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.hr.attendance.model.service.AttendanceService;
import org.riss.bizconnect.hr.model.dto.GooutTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttendanceController {
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
	
	@Autowired
	private AttendanceService attendanceService;
	
	@RequestMapping("moveAttendance.do")
	public ModelAndView moveAttendance (
			HttpSession session, HttpServletRequest request,  
			ModelAndView mv) {
		Member gooutT = (Member) request.getAttribute("loginUser");
		/*
		 * if(gooutT == null) { mv.addObject("gooutBTN", "go"); logger.info("go 활성화");
		 * }else if(gooutT.getOutDate() == null) { mv.addObject("gooutBTN", "out");
		 * logger.info("out 활성화"); }else { mv.addObject("gooutBTN", "finish");
		 * logger.info("모든 버튼 비활성화"); }
		 */
		
		mv.setViewName("hr/attendance");

		return mv;
	}
	
	@RequestMapping("gooutwork.do")
	public String gooutworkCheck() {
		if(attendanceService.goCheck() > 0)
			return "common/footer";
		
		return "common/click";
	}
}

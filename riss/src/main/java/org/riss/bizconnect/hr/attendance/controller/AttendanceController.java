package org.riss.bizconnect.hr.attendance.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.hr.attendance.model.service.AttendanceService;
import org.riss.bizconnect.hr.model.dto.GooutTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttendanceController {

	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

	@Autowired
	private AttendanceService attendanceService;

	@RequestMapping("moveAttendance.do")
	public ModelAndView moveAttendance(
			HttpSession session, 
			ModelAndView mv) {
		
		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456", "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);
		
		Member loginUser = (Member) session.getAttribute("loginUser");
		GooutTime gooutTime = attendanceService.selectTodayGOTime(loginUser);
		
		logger.info("Member : " + loginUser);
		logger.info("gooutTime : " + gooutTime);
		if (gooutTime == null || gooutTime.getDay() == null) {
			if(attendanceService.insertGOTime(loginUser) > 0) {
				mv.addObject("gooutBTN", "go");
				logger.info("insert => go 활성화");
			}
		} else if (gooutTime.getGoDate() == null) {
			mv.addObject("gooutBTN", "go");
			logger.info("go 활성화");
			
		} else if(gooutTime.getOutDate() == null){
			mv.addObject("gooutBTN", "out");
			logger.info("out 활성화");
		} else {
			mv.addObject("gooutBTN", "finish");
			logger.info("모든 버튼 비활성화");
		}

		mv.setViewName("hr/attendance");
		//session.invalidate();
		return mv;
	}
	@RequestMapping("goWorkCheck.do")
	public String goWork(
			HttpSession session) {
		
		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456", "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);
	
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		if(attendanceService.updateGoD(loginUser) > 0) {
			return "redirect:moveAttendance.do";
		}else {
			return "common/error";
		}
	}
	
	@RequestMapping("goWorkCheck.do")
	public String outWork(
			HttpSession session) {
		
		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456", "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);
	
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		if(attendanceService.updateOutD(loginUser) > 0) {
			return "redirect:moveAttendance.do";
		}else {
			return "common/error";
		}	
	}
//	@RequestMapping("gooutwork.do")
//	public String gooutworkCheck() {
//		if (attendanceService.goCheck() > 0)
//			return "common/footer";
//
//		return "common/click";
//	}
//
//	@RequestMapping("asd.do")
//	public ModelAndView asd(ModelAndView mv) {
//		return mv;
//	}
}

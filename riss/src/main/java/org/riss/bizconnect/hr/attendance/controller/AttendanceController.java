package org.riss.bizconnect.hr.attendance.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.hr.attendance.model.dto.Attendance;
import org.riss.bizconnect.hr.attendance.model.service.AttendanceService;
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
	public ModelAndView moveAttendance(
			HttpSession session, 
			ModelAndView mv) {
		
		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456", "Marketing Manager");
		session.setAttribute("loginUser", member);
		
		Member loginUser = (Member) session.getAttribute("loginUser");
		Attendance gooutTime = attendanceService.selectTodayAttendance(loginUser);
		
		logger.info("확인 : " + attendanceService.insertAttendance(loginUser)); 
		if (gooutTime == null || gooutTime.getGoDate() == null) {
			mv.addObject("gooutBTN", "출 근");
			mv.addObject("URL", "goWorkCheck.do");
			logger.info("insert => go 활성화");
			mv.addObject("common/error");
		}else if(gooutTime.getOutDate() == null){
			mv.addObject("gooutBTN", "퇴 근");
			mv.addObject("URL", "outWorkCheck.do");
			logger.info("out 활성화");
		} else {
			logger.info("모든 버튼 비활성화");
		}

		mv.setViewName("hr/attendance");
		//session.invalidate();
		return mv;
	}
	@RequestMapping("goWorkCheck.do")
	public String goWork(
			HttpSession session) {
		
		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456", "Marketing Manager");
		session.setAttribute("loginUser", member);
	
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		if(attendanceService.updateGoD(loginUser) > 0) {
			return "redirect:moveAttendance.do";
		}else {
			return "common/error";
		}
	}
	
	@RequestMapping("outWorkCheck.do")
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
	
	@RequestMapping("moveAttendanceCheck.do")
	public ModelAndView moveAttendanceCheck(
			HttpSession session, 
			ModelAndView mv) {
		
		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456", "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);
		
		
		Member loginUser = (Member) session.getAttribute("loginUser");
		ArrayList<Attendance> myAttendance = attendanceService.selectMyAttendance(loginUser);
		  
		
		mv.addObject("list",myAttendance);
		 		
		mv.setViewName("hr/attendanceCheck");
		return mv;
	}

}

package org.riss.bizconnect.hr.attendance.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.attendance.model.dto.Attendance;
import org.riss.bizconnect.hr.attendance.model.service.AttendanceService;
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
	public ModelAndView moveAttendance(HttpSession session, ModelAndView mv) {

		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		Attendance attendance = attendanceService.selectTodayAttendance(loginUser);

		logger.info("확인 : " + attendanceService.insertAttendance(attendance));
		if (attendance == null || attendance.getGoDate() == null) {
			mv.addObject("gooutBTN", "출 근");
			mv.addObject("URL", "goWorkCheck.do");
			logger.info("insert => go 활성화");
			mv.addObject("common/error");
		} else if (attendance.getOutDate() == null) {
			mv.addObject("gooutBTN", "퇴 근");
			mv.addObject("URL", "outWorkCheck.do");
			logger.info("out 활성화");
		} else {
			logger.info("모든 버튼 비활성화");
		} 

		mv.setViewName("hr/attendance");
		// session.invalidate();
		return mv;
	}

	@RequestMapping("goWorkCheck.do")
	public String goWork(HttpSession session) {

		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);

		Member loginUser = (Member) session.getAttribute("loginUser");
		Attendance attendance = attendanceService.selectTodayAttendance(loginUser);
		attendance.setGoDate(new Timestamp (System.currentTimeMillis()));

		if (attendanceService.updateGoD(attendance) > 0) {
			return "redirect:moveAttendance.do";
		} else {
			return "common/error";
		}
	}

	@RequestMapping("outWorkCheck.do")
	public String outWork(HttpSession session) {

		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);

		Member loginUser = (Member) session.getAttribute("loginUser");
		Attendance attendance = attendanceService.selectTodayAttendance(loginUser);
		attendance.setOutDate(new Timestamp(System.currentTimeMillis()));
		attendance.calTimestamp();
		
		if (attendanceService.updateOutD(attendance) > 0) {
			return "redirect:moveAttendance.do";
		} else {
			return "common/error";
		}
	}

	@RequestMapping("moveAttendanceCheck.do")
	public ModelAndView moveAttendanceCheck(HttpSession session, ModelAndView mv, 
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit) {

		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);

		
		Member loginUser = (Member) session.getAttribute("loginUser");
		// 페이징 처리
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}

		// 총 목록갯수 조회해서 총 페이지 수 계산함
		int listCount = attendanceService.selectListCount();
		// 페이지 관련 항목 계산 처리
		Paging paging = new Paging(loginUser.getgId(), loginUser.getComCode(), listCount, limit, currentPage, "moveAttendanceCheck.do");
		paging.calculate();

		
		ArrayList<Attendance> list = attendanceService.selectMyAttendance(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.setViewName("hr/attendanceCheck");
		} else {
			mv.addObject("message", currentPage + " 페이지 목록 조회 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}

/*	@RequestMapping("moveAttendanceUpdate.do")
	public ModelAndView moveAttendanceUpdate(HttpSession session, ModelAndView mv) {

		Member member = new Member("GID010", "COM010", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);

		Member loginUser = (Member) session.getAttribute("loginUser");
		ArrayList<Attendance> myAttendance = attendanceService.selectMyAttendance(loginUser);

		mv.addObject("list", myAttendance);

		mv.setViewName("hr/attendanceCheck");
		return mv;
	}*/
}

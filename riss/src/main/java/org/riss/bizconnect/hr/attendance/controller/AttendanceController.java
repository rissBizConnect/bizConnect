package org.riss.bizconnect.hr.attendance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
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
	public ModelAndView moveAttendance(HttpServletRequest request, ModelAndView mv) {
		request.setAttribute("loginUser", new Member("COM010", "GID010", "password012", "Ella Harris", "861010-0123456", "Full-time", "Marketing Manager"));
		
		HttpSession session = request.getSession(false);
		
		Member logginUser = (Member) request.getAttribute("loginUser");
		GooutTime gooutTime = attendanceService.gooutCheck(logginUser);
		
		logger.info("gooutTime  : " + gooutTime);
//		if (logginUser == null) {
//			mv.addObject("gooutBTN", "go");
//			logger.info("go 활성화");
//		} else if (logginUser.getOutDate() == null) {
//			mv.addObject("gooutBTN", "out");
//			logger.info("out 활성화");
//		} else {
//			mv.addObject("gooutBTN", "finish");
//			logger.info("모든 버튼 비활성화");
//		}

		mv.setViewName("hr/attendance");
		session.invalidate();
		return mv;
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

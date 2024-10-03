package org.riss.bizconnect.hr.attendance.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttendanceController {

	@RequestMapping("moveAttendance.do")
	public ModelAndView moveAttendance (ModelAndView mv) {
		
		mv.setViewName("hr/attendance");
		return mv;
	}
}

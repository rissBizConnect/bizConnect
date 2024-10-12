package org.riss.bizconnect.hr.attendance.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
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

		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		Attendance attendance = attendanceService.selectTodayAttendance(loginUser);
		logger.info("attendance : " + attendance);
		
		logger.info("확인 : " + attendanceService.insertAttendance(loginUser));
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

		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
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

		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);

		Member loginUser = (Member) session.getAttribute("loginUser");
		Attendance attendance = attendanceService.selectTodayAttendance(loginUser);
		attendance.setOutDate(new Timestamp(System.currentTimeMillis()));
		attendance.calTimestamp();
		logger.info("attendance : " + attendance);
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

		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);

		
		Member loginUser = (Member) session.getAttribute("loginUser");

		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}

		int listCount = attendanceService.selectListCount(loginUser);

		Paging paging = new Paging(loginUser.getgId(), loginUser.getComCode(), listCount, limit, currentPage, "moveAttendanceCheck.do");
		paging.calculate();

		
		ArrayList<Attendance> list = attendanceService.selectMyAttendance(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.setViewName("hr/attendanceCheck");
		} else {
			mv.addObject("error", "조회 정보가 없습니다.");
			mv.setViewName("hr/attendanceUpdateM");
		}
		return mv;
	}
	
	@RequestMapping("moveAttendanceUpdateM.do")
	public ModelAndView moveAttendanceUpdateM(
			HttpSession session, 
			ModelAndView mv,
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit,
			@RequestParam(name = "fileter", required = false) String fileter,
			@RequestParam(name = "smember", required = false) String smember,
			@RequestParam(name = "begin", required = false) Date begin,
			@RequestParam(name = "end", required = false) Date end,
			@RequestParam(name = "work", required = false) String work) {
		Member mm = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", mm);
		logger.info("page : " + page);
		logger.info("limit : " + slimit);
		logger.info("fileter : " + fileter);
		logger.info("smember : " + smember);
		logger.info("begin : " + begin);
		logger.info("end : " + end);
		logger.info("work : " + work);
		
		int listCount = 0, currentPage = 1, limit = 10;
		ArrayList<Attendance> list = new ArrayList<Attendance>();
		ArrayList<String> memberlist = new ArrayList<String>();
		Search search = new Search();
		if(fileter == null) {
			fileter = "all";
		}
		
		Member member = (Member) session.getAttribute("loginUser");
		memberlist = attendanceService.selectComMListCount(member.getComCode());
		
		if(smember != null) {
			member.setgId(smember);
		} 
		
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}

		if(fileter.equals("date") && begin != null && end != null) {
			search.setBegin(begin);
			search.setEnd(end);
			search.setComCode(member.getComCode());
		}
		
		if(fileter == null || fileter.equals("all")) {
			listCount = attendanceService.selectComListCount(member);
		} else if(fileter.equals("member")) {
			listCount = attendanceService.selectComFileterMListCount(member);
		} else if(fileter.equals("date")) {
			listCount = attendanceService.selectComDateMListCount(search);
		} else if(fileter.equals("work")) {
			ArrayList<Attendance> tlist = attendanceService.selectComList(member);
			for(Attendance l : tlist) {
				if(work.equals("nwork") && l.calHTimestamp() >= 8) {
					listCount++;
				} else if(work.equals("abwork") && l.calHTimestamp() < 8) {
					listCount++;
				}
			}
		} else {
			mv.setViewName("common/error");
		} 
		
		Paging paging = new Paging(member.getgId(), member.getComCode(), listCount, limit, currentPage, "moveAttendanceUpdateM.do");
		paging.calculate();
		
		
		if(fileter == null || fileter.equals("all")) {
			list = attendanceService.selectComAttendance(paging);
		} else if(fileter.equals("member")) {
			list = attendanceService.selectComFileterMAttendance(paging);
		}  else if(fileter.equals("date")) {
			search.setStartRow(paging.getStartRow());
			search.setEndRow(paging.getEndRow());
			list = attendanceService.selectComDateAttendance(search);
		} else if(fileter.equals("work")){
			list = attendanceService.selectComAttendance(paging);
			ArrayList<Attendance> tlist = new ArrayList<Attendance>();
			for(Attendance l : list) {
				if(work.equals("nwork") && l.calHTimestamp() >= 8) {
					logger.info("calHTimestamp1 " + l.calHTimestamp());
					tlist.add(l);
				} else if(work.equals("abwork") && l.calHTimestamp() < 8) {
					logger.info("calHTimestamp2 " + l.calHTimestamp());
					tlist.add(l);
				}
			}
			logger.info("tlist " + tlist);
			list = tlist;
		} else {
			mv.setViewName("common/error");
		}
		
		mv.addObject("list", list);
		mv.addObject("paging", paging);
		mv.addObject("currentPage", currentPage);
		mv.addObject("fileter", fileter);
		mv.addObject("memberlist", memberlist);
		mv.addObject("smember", smember);
		mv.addObject("work", work);
		if(fileter.equals("date")) {
			mv.addObject("begin", search.getBegin());
			mv.addObject("end", search.getEnd());
		}
		mv.setViewName("hr/attendanceUpdateM");
		if (list == null && list.size() == 0) {	
			mv.addObject("error", "조회 정보가 없습니다.");
		} 
		return mv;
	}
	
	@RequestMapping("attendanceUpdatePop.do")
	public ModelAndView moveAttendanceUpdatePop(
			ModelAndView mv,
			@RequestParam(name = "gId", required = false) String gId,
			@RequestParam(name = "day", required = false) Date day,
			@RequestParam(name = "goDate", required = false) Timestamp goDate,
			@RequestParam(name = "outDate", required = false) Timestamp outDate
			) {
		logger.info("gId : " + gId);
		logger.info("day : " + day);
		logger.info("goDate : " + goDate);
		logger.info("outDate : " + outDate);
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String goDateTime = sdf.format(goDate);
		
		
		String outDateTime = sdf.format(outDate);
		
		
		mv.addObject("gId", gId);
		mv.addObject("day", day);
		mv.addObject("goDate", goDateTime);
		mv.addObject("outDate", outDateTime);
		mv.setViewName("hr/attendanceUpdatePop");
		
		return mv;
	}
	
	@RequestMapping("updateAttendance.do")
	public String updateAttendance(
			HttpSession session, 
			Attendance attendance,
			@RequestParam(name = "goD", required = false) String goD,
			@RequestParam(name = "outD", required = false) String outD
			) {
		Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager");
		session.setAttribute("loginUser", member);
		
		Timestamp goDTS = Timestamp.valueOf(attendance.getDay().toString() + " " + goD + ":00.0");
		Timestamp outDTS = Timestamp.valueOf(attendance.getDay().toString() + " " + outD + ":00.0");
		
		attendance.setComCode(((Member)session.getAttribute("loginUser")).getComCode());
		attendance.setGoDate(goDTS);
		attendance.setOutDate(outDTS);
		
		attendance.calTimestamp();
		logger.info("attendance : " + attendance);
		int as = attendanceService.updateAttendnce(attendance);
		logger.info("as : " + as);
		if(as == 1) {
			return "redirect:moveAttendanceUpdateM.do";
		}
		
		return "common/error";
	}
}

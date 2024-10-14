package org.riss.bizconnect.hr.retire.model.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.attendance.controller.AttendanceController;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.riss.bizconnect.hr.retire.model.service.RetireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RetireController {

	private static final Logger logger = LoggerFactory.getLogger(RetireController.class);

	@Autowired
	private RetireService retireService; // RetireService 의존성 주입

	// 퇴직자 목록을 조회하는 메서드
	@RequestMapping("retList.do")
	public ModelAndView selectRetireList(HttpServletRequest request, 
			@RequestParam(required = false) String gid,
			@RequestParam(required = false) String comCode, @RequestParam(required = false) String retNo,
			@RequestParam(required = false) Date userEntryDate, @RequestParam(required = false) Date retDate,
			@RequestParam(required = false) String retType, @RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "slimit", required = false) String slimit, HttpSession session) {
		Member mm = new Member("GID009", "COM010", "password012", "Ella Harris", "861010-0123456",
				Date.valueOf("2023-10-10"), "Full-time", "Marketing Manager", "N");
		session.setAttribute("loginUser", mm);

		Member member = (Member) session.getAttribute("loginUser");

		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		int pageSize = 3;
		if (slimit != null) {
			pageSize = Integer.parseInt(slimit);
		}
		ModelAndView mv = new ModelAndView("hr/retireList"); // 뷰 이름 설정
		Retire retire = new Retire(retNo, gid, retDate, retType, comCode, userEntryDate);

		retire.setComCode(member.getComCode());
		int listCount = retireService.selectRetireCount(retire); // 총 목록 수 조회

		// Paging 객체 생성
		Paging paging = new Paging(gid, member.getComCode(), listCount, pageSize, currentPage, "retList.do");

		// 퇴직자 목록 조회
		ArrayList<Retire> list = retireService.selectRetireList(paging);
		logger.info("list : " + list);

		// 페이징 정보 추가
		mv.addObject("list", list); // 퇴직자 목록 추가
		mv.addObject("paging", paging); // 페이징 정보 추가
		mv.addObject("fileter", "all");

		return mv; // 뷰 반환
	}

	// 새로운 퇴직자를 추가하는 뷰를 표시합니다.
	@RequestMapping("retireAddForm.do")
	public String showAddRetireForm(Retire retire) {
		logger.info("retire" + retire);
//        mav = new ModelAndView("hr/retireAddForm"); // 퇴직자 추가 뷰 이름 설정
//        mav.setViewName("hr/retireAddForm");
		return "hr/retireAddForm"; // 뷰 반환
	}

	// 퇴직자를 추가합니다.
	@RequestMapping("retAdd.do")
	public ModelAndView insertRetire(Retire retire) {
		logger.info("retire : " + retire);
		retireService.insertRetire(retire); // 서비스 호출하여 퇴직자 추가
		return new ModelAndView("redirect:/retList.do"); // 목록 페이지로 리다이렉트
	}

	// 퇴직자를 수정하기 위한 폼을 표시합니다.
	@RequestMapping(value = "retireEditForm.do", method = RequestMethod.GET)
	public ModelAndView showEditRetireForm(@RequestParam("retNo") String retNo) {
		ModelAndView mv = new ModelAndView("hr/retireEditForm"); // 수정 뷰 이름 설정
		Retire retire = retireService.selectRetireByRetNo(retNo); // 퇴직자 정보 조회
		mv.addObject("retire", retire); // 퇴직자 정보 추가
		return mv; // 뷰 반환
	}

	// 퇴직자를 수정합니다.
	@RequestMapping("retEdit.do")
	public ModelAndView updateRetire(Retire retire) {
		retireService.updateRetire(retire); // 서비스 호출하여 퇴직자 수정
		return new ModelAndView("redirect:/retList.do"); // 목록 페이지로 리다이렉트
	}

	// 퇴직자를 삭제합니다.
	@RequestMapping("retDelete.do")
	public ModelAndView deleteRetire(@RequestParam("retNo") String retNo) {
		retireService.deleteRetire(retNo); // 서비스 호출하여 퇴직자 삭제
		return new ModelAndView("redirect:/retList.do"); // 목록 페이지로 리다이렉트
	}
}
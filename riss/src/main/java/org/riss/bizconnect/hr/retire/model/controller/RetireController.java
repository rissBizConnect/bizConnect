package org.riss.bizconnect.hr.retire.model.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.riss.bizconnect.hr.retire.model.service.RetireService;
import org.riss.bizconnect.main.member.model.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RetireController {
    private static final Logger logger = LoggerFactory.getLogger(RetireController.class);
    
    @Autowired
    private RetireService retireService;

    @RequestMapping("allRetirees.do")
    public ModelAndView showAllRetirees(HttpSession session, ModelAndView mv) {
        // 세션에서 로그인 사용자 정보를 가져옵니다.
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            mv.setViewName("common/error");
            return mv;
        }

        // 전체 퇴사자 목록 조회
        ArrayList<Retire> retireList = retireService.selectAllRetirees(user.getComCode());

        if (retireList != null && !retireList.isEmpty()) {
            mv.addObject("retireList", retireList);
            mv.setViewName("hr/allRetireeList"); // 전체 퇴사자 목록 JSP 파일 이름
        } else {
            mv.addObject("message", "퇴사자 목록이 없습니다.");
            mv.setViewName("common/error");
        }

        return mv;
    }
    
    @RequestMapping("moveRetireList.do")
    public ModelAndView moveRetireeList(
            HttpSession session,
            ModelAndView mv,
            @RequestParam(name = "page", required = false) String page,
            @RequestParam(name = "limit", required = false) String slimit) {
        
        // 세션에서 로그인 사용자 정보를 가져옵니다.
        User user = (User) session.getAttribute("loginUser"); // User로 캐스팅
        if (user == null) {
            // 로그인 사용자 정보가 없는 경우 처리
            mv.setViewName("common/error");
            return mv;
        }
        
        // Member 객체로 변환 (필요한 경우)
        Member member = new Member();
        member.setgId(user.getgID()); // User의 GID를 Member에 설정
        member.setComCode(user.getComCode()); // User의 회사 코드를 Member에 설정

        // 페이지 번호 및 페이지당 항목 수 설정
        int currentPage = (page != null) ? Integer.parseInt(page) : 1;
        int limit = (slimit != null) ? Integer.parseInt(slimit) : 10;

        // 전체 퇴직자 수 조회
        int listCount = retireService.selectListCount(member);

        // Paging 객체 생성
        Paging paging = new Paging(member.getgId(), member.getComCode(), listCount, limit, currentPage, "moveRetireeList.do");
        
        // 퇴직자 목록 조회
        ArrayList<Retire> retireList = retireService.selectRetireList(paging);

        if (retireList != null && !retireList.isEmpty()) {
            mv.addObject("retireList", retireList);
            mv.addObject("paging", paging);
            mv.addObject("currentPage", currentPage);
            mv.setViewName("hr/retireList"); // JSP 파일 이름
        } else {
            mv.addObject("message", currentPage + " 페이지 목록 조회 실패!");
            mv.setViewName("common/error");
        }

        return mv;
    }


    // 퇴직자 추가
    @RequestMapping("retadd.do")
    public String addRetire(Retire retire) {
        retireService.addRetire(retire);
        return "redirect:moveRetireeList.do"; // 추가 후 목록으로 리다이렉트
    }

    // 퇴직자 수정
    @RequestMapping("retupdate.do")
    public String updateRetire(Retire retire) {
        retireService.updateRetire(retire);
        return "redirect:moveRetireeList.do"; // 수정 후 목록으로 리다이렉트
    }

    // 퇴직자 삭제
    @RequestMapping("retdelete.do")
    public String deleteRetire(@RequestParam("retNo") String retNo) {
        retireService.deleteRetire(retNo);
        return "redirect:moveRetireeList.do"; // 삭제 후 목록으로 리다이렉트
    }
}

package org.riss.bizconnect.main.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {

    // 개인정보 변경 페이지
    @GetMapping("/profileUpdate.do")
    public String profileUpdatePage() {
        return "mypage/profileUpdate"; // Returns profileUpdate.jsp
    }

    // 기업 등록 및 정보 페이지
    @GetMapping("/companyInfo.do")
    public String companyInfoPage() {
        return "mypage/companyInfo"; // Returns companyInfo.jsp
    }

 // 공지사항 목록 페이지 이동
    @GetMapping("/noticeList.do")
    public String noticeList() {
        return "notice/noticeListView"; // Returns noticeList.jsp
    }

    // 공지사항 작성 페이지 이동
    @GetMapping("/noticeWrite.do")
    public String noticeWritePage() {
        return "notice/noticeWriteForm"; // 공지사항 작성 페이지 (noticeWriteForm.jsp)로 이동
    }

    // 공지사항 상세 페이지 이동
    @GetMapping("/noticeDetail.do")
    public ModelAndView noticeDetail(@RequestParam("no") int noticeNo, ModelAndView mv) {
        mv.addObject("noticeNo", noticeNo); // 상세보기할 공지사항 번호 전달
        mv.setViewName("notice/noticeDetailView"); // 상세보기 페이지로 이동
        return mv;
    }

    // 공지사항 수정 페이지 이동
    @GetMapping("/noticeUpdate.do")
    public ModelAndView noticeUpdate(@RequestParam("no") int noticeNo, ModelAndView mv) {
        mv.addObject("noticeNo", noticeNo); // 수정할 공지사항 번호 전달
        mv.setViewName("notice/noticeUpdateView"); // 수정 페이지로 이동
        return mv;
    }
}

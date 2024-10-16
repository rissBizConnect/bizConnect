package org.riss.bizconnect.main.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    // 고객센터(게시판) 페이지
    @GetMapping("/supportCenter.do")
    public String supportCenterPage() {
        return "mypage/supportCenter"; // Returns supportCenter.jsp
    }
}

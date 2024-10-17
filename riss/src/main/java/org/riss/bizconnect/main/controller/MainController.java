package org.riss.bizconnect.main.controller;

import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/main.do")
    public String showMainPage(HttpSession session, Model model) {
        // 세션에서 로그인된 유저 정보 가져오기
        Member member = (Member) session.getAttribute("loginUser");

        // 유저가 로그인되지 않았을 경우 로그인 페이지로 리디렉션
        if (member == null) {
            return "redirect:/loginPage.do";
        }

        // 유저 정보를 모델에 추가하여 JSP에서 출력할 수 있도록 전달
        model.addAttribute("user", member);

        // main.jsp로 포워딩
        return "main";
    }
}

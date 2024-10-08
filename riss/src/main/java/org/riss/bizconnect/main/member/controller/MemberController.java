package org.riss.bizconnect.main.member.controller;

import javax.servlet.http.HttpSession;

import org.riss.bizconnect.main.member.model.dto.User;
import org.riss.bizconnect.main.member.model.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; // 추가
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberservice;

    // 로그인 페이지로 이동
    @RequestMapping(value = "loginPage.do")
    public String moveLoginPage() {
        return "common/loginPage";
    }

    // login.do GET 요청을 처리하고 로그인 페이지로 리다이렉트
    @GetMapping("/login.do")  // 추가
    public String redirectToLoginPage() {
        return "redirect:/loginPage.do";  // GET 요청을 로그인 페이지로 리다이렉트
    }

    // 로그인 처리 메소드 (POST 요청)
    @PostMapping("/login.do")
    public String loginMethod(User user, HttpSession session, SessionStatus status, Model model) {
        // 서비스에서 로그인 처리 후 결과 받음
        User loginUser = memberservice.selectLogin(user);

        if (loginUser != null && user.getUserPw().equals(loginUser.getUserPw())) {
            // 로그인 성공
            session.setAttribute("loginUser", loginUser);
            status.setComplete();
            return "main";
        } else {
            // 로그인 실패
        	logger.info("loginUser : " + loginUser);
            model.addAttribute("message", "로그인 실패! 아이디나 암호를 다시 확인하세요.");
            return "common/error";
        }
    }
}

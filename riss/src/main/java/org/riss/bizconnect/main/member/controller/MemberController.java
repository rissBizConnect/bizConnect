package org.riss.bizconnect.main.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.main.member.model.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    // 로그인 페이지로 이동
    @RequestMapping(value = "loginPage.do")
    public String moveLoginPage() {
        return "common/loginPage";
    }

    // login.do GET 요청을 처리하고 로그인 페이지로 리다이렉트
    @GetMapping("/login.do")
    public String redirectToLoginPage() {
        return "redirect:/loginPage.do";  // GET 요청을 로그인 페이지로 리다이렉트
    }

    // 로그인 처리 메소드 (POST 요청)
    @PostMapping("/login.do")
    public String loginMethod(Member user, HttpSession session, SessionStatus status, Model model) {
        // 서비스에서 로그인 처리 후 결과 받음
    	Member loginUser = memberService.selectLogin(user);

        // 로그인 성공 시
        if (loginUser != null && user.getUserPW().equals(loginUser.getUserPW())) {
            session.setAttribute("loginUser", loginUser); // 유저 정보를 세션에 저장
            status.setComplete();

            // 사용자의 역할에 따른 분기 처리
            if ("developer".equalsIgnoreCase(loginUser.getUserRole())) {
                return "redirect:/developerPage.do"; // 개발자 페이지로 리다이렉트
            } else {
                return "redirect:/main.do";  // 일반 사용자는 메인 페이지로 리다이렉트
            }
        } else {
            // 로그인 실패
            logger.info("loginUser : " + loginUser);
            model.addAttribute("message", "로그인 실패! 아이디나 암호를 다시 확인하세요.");
            return "common/error";
        }
    }

    // main.do에서 사용자 마이페이지로 이동하는 메소드
    @GetMapping("/main.do")
    public String showMyPage(HttpSession session, Model model) {
        // 세션에서 로그인된 사용자 정보를 가져옴
    	Member loginUser = (Member) session.getAttribute("loginUser");

        if (loginUser == null) {
            // 로그인이 되어있지 않다면 로그인 페이지로 리다이렉트
            return "redirect:/loginPage.do";
        }

        // 사용자 정보를 모델에 추가하여 JSP에 전달
        model.addAttribute("user", loginUser);

        // main.jsp (마이페이지)로 이동
        return "main";
    }
    
    @RequestMapping("logout.do")
	public String logoutMethod(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		// request 에 기록된 세션ID를 가지고, sessionScope (세션저장소)에 가서
		// 해당 ID와 일치하는 세션객체를 찾아서 반환받음
		// false 이면 세션객체가 있으면 해당 객체를 리턴받고, 없으면 null 리턴

		if (session != null) { // 세션객체가 있다면
			session.invalidate(); // 세션객체 없앰
			return "common/loginPage";
		} else { // 세션객체가 없다면
			model.addAttribute("message", "로그인 세션이 존재하지 않습니다.");
			return "common/error";
		}
	}
}

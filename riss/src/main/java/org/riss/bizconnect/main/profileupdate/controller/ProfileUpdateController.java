package org.riss.bizconnect.main.profileupdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.riss.bizconnect.main.member.model.dto.User;
import org.riss.bizconnect.main.member.model.service.MemberService;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class ProfileUpdateController {

    @Autowired
    private MemberService memberService;

    // 비밀번호 확인 페이지로 이동 (GET 요청)
    @GetMapping("/passwordCheck.do")
    public String moveToPasswordCheck() {
        return "mypage/passwordCheck"; // 비밀번호 확인 페이지로 이동
    }

    // 비밀번호 확인 메소드 (POST 요청)
    @PostMapping("/profileUpdateCheck.do")
    public String checkPassword(@RequestParam("userPw") String userPw, HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");

        // 입력받은 비밀번호와 실제 비밀번호 비교
        if (memberService.validateLogin(loginUser.getgID(), userPw, loginUser.getComCode())) {
            model.addAttribute("loginUser", loginUser);
            return "mypage/profileUpdateForm"; // 프로필 업데이트 폼으로 이동
        } else {
            model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            return "mypage/passwordCheck"; // 비밀번호 확인 페이지로 다시 이동
        }
    }

    // 프로필 업데이트 메소드 (POST 요청)
    @PostMapping("/updateProfile.do")
    public String updateProfile(@ModelAttribute User user, 
                                @RequestParam("oldPw") String oldPw,
                                @RequestParam("newPw") String newPw, 
                                @RequestParam("confirmPw") String confirmPw, 
                                HttpSession session, 
                                Model model) {
        User loginUser = (User) session.getAttribute("loginUser");

        // 로그 추가
        System.out.println("getUserName 값: " + user.getUserName());
        System.out.println("getComCode 값: " + user.getComCode());
        System.out.println("getUserPhone 값: " + user.getUserPhone());
        System.out.println("getUserAddr 값: " + user.getUserAddr());

        // 세션에서 GID를 가져와 user 객체에 설정
        user.setgID(loginUser.getgID());

        // 비밀번호 변경 로직
        if (!oldPw.isEmpty() && !newPw.isEmpty() && newPw.equals(confirmPw)) {
            if (!memberService.validateLogin(loginUser.getgID(), oldPw, loginUser.getComCode())) {
                model.addAttribute("errorMessage", "기존 비밀번호가 일치하지 않습니다.");
                return "mypage/profileUpdateForm";
            }
            user.setUserPw(newPw); // 비밀번호 업데이트
        }

        // 개인정보 업데이트
        memberService.updateProfile(user);
        
        // 세션에 최신 정보를 저장
        session.setAttribute("loginUser", user);

        model.addAttribute("successMessage", "개인정보가 성공적으로 업데이트되었습니다.");
        return "mypage/profileUpdateSuccess"; // 성공 페이지로 리디렉션
    }



    // 업데이트 성공 후 GET 요청 처리
    @GetMapping("/profileUpdateCheck.do")
    public String profileUpdateSuccess(@RequestParam("successMessage") String successMessage, Model model) {
        model.addAttribute("successMessage", successMessage);
        return "mypage/profileUpdateSuccess"; // 성공 메시지 페이지
    }

}

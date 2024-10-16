package org.riss.bizconnect.main.developer.controller;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.main.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeveloperController {

    @Autowired
    private MemberService memberService;

    // 개발자 페이지로 이동하는 메소드
    @GetMapping("/developerPage.do")
    public String showDeveloperPage(Model model) {
        List<Member> userList = memberService.getAllUsers();
        model.addAttribute("userList", userList);  // 여기서 "userList"가 잘 전달되고 있는지 확인
        return "developerPage";  // JSP 파일명 반환
    }



    // 사용자 세부 정보를 JSON으로 반환하는 메소드 (AJAX)
    @GetMapping("/developer/viewUserDetails.do")
    @ResponseBody
    public Member viewUserDetails(@RequestParam("userId") String userId) {
        return memberService.getUserById(userId);  // JSON으로 사용자 정보 반환
    }

    // 선택한 사용자의 세부 정보를 HTML로 반환하는 메소드
    @GetMapping("/developer/viewUserDetailsPage.do")
    public String viewUserDetails(@RequestParam("userId") String userId, Model model) {
    	Member selectedUser = memberService.getUserById(userId);
        model.addAttribute("selectedUser", selectedUser);
        return "developerPage";  // 사용자 세부 정보를 표시한 페이지로 이동
    }

    // 수정된 사용자 정보를 저장하는 메소드
    @PostMapping("/developer/saveUserDetails.do")
    public String saveUserDetails(Member user) {
        memberService.updateUserDetails(user);
        
        return "redirect:/developerPage.do";
    }
}

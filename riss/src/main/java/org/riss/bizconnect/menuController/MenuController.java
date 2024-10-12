package org.riss.bizconnect.menuController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	// Main page (MyPage)
    @GetMapping("/main.do")
    public String mainPage() {
        return "main"; // This should point to main.jsp
    }

    @GetMapping("/menu.do")
    public String menuPage() {
        return "menu";
    }

    // 인사관리 페이지
    @GetMapping("/hrManagement.do")
    public String hrManagement() {
        return "hr/attendance"; // hrManagement.jsp로 이동
    }

    // 재고관리 페이지
    @GetMapping("/prManagement.do")
    public String prManagement() {
        return "prManagement"; // prManagement.jsp로 이동
    }
}
package org.riss.bizconnect.menuController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    // 메뉴 메인 페이지
    @GetMapping("/menuMain.do")  // 기존 main.do에서 menuMain.do로 변경
    public String menuMainPage() {
        return "main"; // main.jsp로 이동
    }

    // 메뉴 페이지
    @GetMapping("/menu.do")
    public String menuPage() {
        return "menu";  // menu.jsp로 이동
    }

    // 인사관리 페이지
    @GetMapping("/hrManagement.do")
    public String hrManagement() {
        return "hrManagement";  // hrManagement.jsp로 이동
    }

    // 재고관리 페이지
    @GetMapping("/prManagement.do")
    public String prManagement() {
        return "prManagement";  // prManagement.jsp로 이동
    }
}

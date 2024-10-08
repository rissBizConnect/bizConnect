package org.riss.bizconnect.hr.retiree.model.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.riss.bizconnect.hr.retiree.model.dto.RetireDTO;
import org.riss.bizconnect.hr.retiree.model.service.RetireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/retire") // URL 매핑
public class RetireController {
    @Autowired
    private RetireService retireService; // 서비스 의존성 주입

    @GetMapping("/detail/{retNo}")
    public String detail(@PathVariable("retNo") Long retNo, Model model, HttpServletRequest request) {
        RetireDTO retiree = retireService.getRetireeById(retNo);
        request.setAttribute("retiree", retiree); // request에 retiree 객체를 설정
        return "retiree/retireeDetail"; // 뷰 이름을 반환
    }
    @GetMapping("/{retNo}/{comCode}")
    public String getRetireInfo(@PathVariable int retNo, @PathVariable String comCode, Model model) {
        RetireDTO retire = retireService.findRetire(retNo, comCode);
        model.addAttribute("retire", retire); // 모델에 퇴직자 정보 추가
        return "retireDetail"; // JSP 파일로 리턴
    }

    @GetMapping("/list")
    public String getAllRetires(Model model) {
        List<RetireDTO> retireList = retireService.findAllRetires();
        model.addAttribute("retireList", retireList); // 모델에 퇴직자 목록 추가
        return "retireList"; // JSP 파일로 리턴
    }

    @PostMapping("/add")
    public String addRetire(@ModelAttribute RetireDTO retire) {
        retireService.registerRetire(retire); // 퇴직자 등록
        return "redirect:/retire/list"; // 퇴직자 목록으로 리디렉션
    }

    @PostMapping("/update")
    public String updateRetire(@ModelAttribute RetireDTO retire) {
        retireService.modifyRetire(retire); // 퇴직자 수정
        return "redirect:/retire/list"; // 퇴직자 목록으로 리디렉션
    }
}

package org.riss.bizconnect.hr.retire.model.controller;

import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.riss.bizconnect.hr.retire.model.service.RetireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/retire")
public class RetireController {

    private final RetireService retireService;

    @Autowired
    public RetireController(RetireService retireService) {
        this.retireService = retireService;
    }

    @GetMapping("/list")
    public String listRetires(Model model) {
        List<Retire> retireList = retireService.getAllRetires();
        model.addAttribute("retireList", retireList); // 퇴직자 목록을 모델에 추가
        return "retire/list"; // 반환할 JSP 경로
    }
}

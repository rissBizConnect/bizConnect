package org.riss.bizconnect.hr.retiree.model.controller;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.hr.retiree.model.dto.RetireDTO;
import org.riss.bizconnect.hr.retiree.model.service.RetireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class RetireController {

    @Autowired
    private RetireService retireService;
    @RequestMapping("main.do")
    public String RetireMainView(
    		Model model
    		) {
    	return "retiree/retireeList";
    	
    }
}

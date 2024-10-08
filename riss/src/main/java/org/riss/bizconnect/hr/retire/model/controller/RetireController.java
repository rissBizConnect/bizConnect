package org.riss.bizconnect.hr.retire.model.controller;

import java.util.List;

import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.riss.bizconnect.hr.retire.model.service.RetireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RetireController {
	
	@Autowired
    private RetireService retireService;

	@RequestMapping("retire.do")
	public String retirePage() {
		return "hr/retireList";
	}
	
    public RetireController(RetireService retireService) {
        this.retireService = retireService;
    }

    // 퇴직자 변환 페이지 호출
    @RequestMapping(value = "/convertRetire.do", method = RequestMethod.GET)
    public String showConvertPage(Model model) {
        // 필요한 데이터 처리
        List<Retire> retireeList = retireService.getAllRetires();  // 모든 퇴직자 정보 가져오기
        model.addAttribute("retireeList", retireeList);
        return "retire/retireConvert"; // retireConvert.jsp 호출
    }

    // 사원을 퇴직자로 변환
    @RequestMapping(value = "/convertToRetire.do", method = RequestMethod.POST)
    public String convertToRetire(@RequestParam("gid") String gid) {
        // GID를 통해 사원을 퇴직자로 변환
        retireService.convertToRetire(gid);
        return "redirect:/retire/convertRetire.do"; // 변환 후 페이지 리로드
    }

    // 퇴직자를 사원으로 복원
    @RequestMapping(value = "/convertToWorker.do", method = RequestMethod.POST)
    public String convertToWorker(@RequestParam("gid") String gid) {
        // GID를 통해 퇴직자를 사원으로 복원
        retireService.convertToWorker(gid);
        return "redirect:/retire/convertRetire.do"; // 변환 후 페이지 리로드
    }
}

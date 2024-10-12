package org.riss.bizconnect.hr.retire.model.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.riss.bizconnect.hr.retire.model.service.RetireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RetireController {
	
	private static final Logger logger = LoggerFactory.getLogger(RetireController.class);
	
	@Autowired
    private RetireService retireService;

	// 퇴직자 목록을 가져오는 메서드
    @RequestMapping("retList.do")
    public ModelAndView retireList(
    		ModelAndView mv, 
    		@RequestParam("comCode") String comCode) {
        logger.info("Fetching retiree list");
        // 서비스 메서드를 호출하여 퇴직자 목록을 가져옴
        List<Retire> retireList = retireService.getRetireList(comCode);
        mv.addObject("retireList", retireList); // 모델에 퇴직자 목록 추가
        mv.setViewName("hr/retireList"); // 반환할 뷰 이름 설정
        return mv; // ModelAndView 반환
    }

    // 퇴직자를 추가하는 메서드
    @RequestMapping("retAdd.do")
    public ModelAndView addRetire(
    		@ModelAttribute Retire retire) {
        retireService.addRetire(retire); // 서비스 메서드를 호출하여 퇴직자 추가
        return new ModelAndView("redirect:/retire/list"); // 추가 후 목록 페이지로 리다이렉트
    }

    // 퇴직자를 수정하는 메서드
    @RequestMapping("retUpdate.do")
    public ModelAndView updateRetire(
    		@ModelAttribute Retire retire) {
        retireService.updateRetire(retire); // 서비스 메서드를 호출하여 퇴직자 수정
        return new ModelAndView("redirect:/retire/list"); // 수정 후 목록 페이지로 리다이렉트
    }

    // 퇴직자를 삭제하는 메서드
    @RequestMapping("delete.do")
    public ModelAndView deleteRetire(
    		@RequestParam("retNo") String retNo) {
        retireService.deleteRetire(retNo); // 서비스 메서드를 호출하여 퇴직자 삭제
        return new ModelAndView("redirect:/retire/list"); // 삭제 후 목록 페이지로 리다이렉트
    }
	
       // 퇴직자 변환 페이지 호출
       @RequestMapping("convertRetire.do")
       public ModelAndView showConvertPage(
    		   HttpServletRequest request, ModelAndView mv) {
           // 필요한 데이터 처리
           List<Retire> retireeList = retireService.selectRetireList();  // 모든 퇴직자 정보 가져오기
           mv.addObject("retireeList", retireeList);
           mv.setViewName("retire/retireConvert"); // retireConvert.jsp 호출
           return mv;
       }

       // 사원을 퇴직자로 변환
       @RequestMapping("convertToRetire.do")
       public ModelAndView convertToRetire(
               HttpServletRequest request, 
               @RequestParam("gid") String gid, 
               ModelAndView mv) {
           
           // GID를 통해 사원을 퇴직자로 변환
           retireService.convertToRetire(gid);

           // 변환 후 페이지 리로드
           mv.setViewName("redirect:/convertRetire.do");
           return mv;
       }

       // 퇴직자를 사원으로 복원
       @RequestMapping("convertToWorker.do")
       public ModelAndView convertToWorker(
               HttpServletRequest request, 
               @RequestParam("gid") String gid, 
               ModelAndView mv) {
           
           // GID를 통해 퇴직자를 사원으로 복원
           retireService.convertToWorker(gid);

           // 복원 후 페이지 리로드
           mv.setViewName("redirect:/convertRetire.do");
           return mv;
       }
   }

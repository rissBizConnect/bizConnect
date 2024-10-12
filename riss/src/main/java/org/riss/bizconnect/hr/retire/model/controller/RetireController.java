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

	 @RequestMapping("retire.do")
	    public String retirePage() {
		 logger.info("adad");
	        return "hr/retireList";
	    }
	
    public RetireController(RetireService retireService) {
        this.retireService = retireService;
    }


    @RequestMapping("retireList.do")
    public ModelAndView retirePage(ModelAndView mv) {
    	logger.info("ada");
        List<Retire> retireList = retireService.getAllRetires();
        mv.addObject("retireList", retireList);
        mv.setViewName("hr/retireList");
        return mv;
    }
    
    @RequestMapping("retupdate.do")
    public ModelAndView updateRetire(@ModelAttribute Retire retire, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("redirect:/retire/list");
        try {
            retireService.updateRetire(retire);
        } catch (Exception e) {
            mav.addObject("errorMessage", "Error updating retire: " + e.getMessage());
        }
        return mav;
    }
    
    @RequestMapping(value = "/retire/delete", method = RequestMethod.POST)
    public ModelAndView deleteRetire(@RequestParam("retNo") String retNo, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("redirect:/retire/list");
        try {
            retireService.deleteRetire(retNo);
        } catch (Exception e) {
            mav.addObject("errorMessage", "Error deleting retire: " + e.getMessage());
        }
        return mav;
    }

       // 퇴직자 변환 페이지 호출
       @RequestMapping("convertRetire.do")
       public ModelAndView showConvertPage(
    		   HttpServletRequest request, ModelAndView mv) {
           // 필요한 데이터 처리
           List<Retire> retireeList = retireService.getAllRetires();  // 모든 퇴직자 정보 가져오기
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

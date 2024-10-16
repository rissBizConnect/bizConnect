package org.riss.bizconnect.hr.info.controller;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.hr.attendance.controller.AttendanceController;
import org.riss.bizconnect.hr.info.model.service.InfoService;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.riss.bizconnect.hr.retire.model.service.RetireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {

   private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
   
   @Autowired
   private BCryptPasswordEncoder bcryptPasswordEncoder;

   @Autowired
   private InfoService infoService;
   
   @Autowired
   private RetireService retireService;

   @RequestMapping("moveInfo.do")
   public ModelAndView moveInfo(
         HttpSession session, 
         @RequestParam(name = "page", required = false) String page,
         @RequestParam(name = "limit", required = false) String slimit,
         @RequestParam(name = "fileter", required = false) String fileter,
         @RequestParam(name = "keyword", required = false) String keyword,
         HttpServletRequest request,
         ModelAndView mv) {

      Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
            Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
      session.setAttribute("loginUser", member);

      String myCom = ((Member) session.getAttribute("loginUser")).getComCode();
      int currentPage = 1;
      if (page != null) {
         currentPage = Integer.parseInt(page);
      }

      int limit = 10;
      if (slimit != null) {
         limit = Integer.parseInt(slimit);
      }
      if (fileter == null) {
         fileter = "all";
      }
      
      if(keyword != null && keyword.length() > 0) {
         Search search = new Search();
         search.setKeyword("%"+ keyword +"%");
         search.setComCode(myCom);
         
         int listCount = infoService.selectKeywordCount(search);
         Paging paging = new Paging(myCom, listCount, limit, currentPage, "moveInfo.do");
         search.setStartRow(paging.getStartRow());
         search.setEndRow(paging.getEndRow());
         
         ArrayList<Member> list = infoService.selectKeyword(search);
         
         mv.addObject("fileter", fileter);
         mv.addObject("keyword", keyword);
         mv.addObject("list", list);
         mv.addObject("paging", paging);
      }else {
         int listCount = infoService.selectAllMemeberCount(myCom);   
         Paging paging = new Paging(myCom, listCount, limit, currentPage, "moveInfo.do");
         ArrayList<Member> list = infoService.selectAllMemeber(paging);

         mv.addObject("list", list);
         mv.addObject("paging", paging);
      }

      mv.addObject("fileter", fileter);

      mv.setViewName("hr/info");
      return mv;
   }

   @RequestMapping("moveInfoInsert.do")
   public ModelAndView moveInfoInsert(HttpSession session, ModelAndView mv, Member mem) {
      mv.setViewName("hr/infoInsert");
      return mv;
   }

   @RequestMapping(value = "InfoInsert.do", method = RequestMethod.POST)
   public String InfoInsert(
         HttpSession session,
         HttpServletRequest request,
         Member mem,
         @RequestParam(name = "muserFacePictPath", required = false) MultipartFile muserFacePictPath){
      
      
      Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
            Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
      session.setAttribute("loginUser", member);
      
      String myCom = ((Member)session.getAttribute("loginUser")).getComCode();
      mem.setComCode(myCom);


      String muserFacePictSavePath = request.getSession().getServletContext().getRealPath("resources/face_files/") 
            + mem.getComCode() + "_" + mem.getgId() + "_FacePict" 
            + muserFacePictPath.getOriginalFilename().substring(muserFacePictPath.getOriginalFilename().lastIndexOf("."));
      
      Retire retire = new Retire();
      retire.setComCode(mem.getComCode());
      retire.setGid(mem.getgId());
      retire.setUserEntryDate(mem.getUserEntry());
      
      mem.setUserFacePictPath(muserFacePictPath.getOriginalFilename().substring(muserFacePictPath.getOriginalFilename().lastIndexOf(".")));
      if(infoService.insertMember(mem) != 1) {
         return "common/error";
      }
      retireService.insertRetire(retire);
      
      if (!muserFacePictPath.isEmpty()) {
         try {
            muserFacePictPath.transferTo(new File(muserFacePictSavePath));
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
      return "redirect:moveInfo.do";
   }
   
   @RequestMapping("infoDelete.do")
   public String infoDelete(
         HttpSession session,
         HttpServletRequest request,
         @RequestParam("gId") String gId) {
      
      Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
            Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
      session.setAttribute("loginUser", member);
      
      String myCom = ((Member)session.getAttribute("loginUser")).getComCode();
      Member mem = new Member();
      
      mem.setComCode(myCom);
      mem.setgId(gId);
      
      mem = infoService.selectMember(mem);
      
      if(infoService.deleteMember(mem) != 1) {
         return "common/error";
      }
      
      if(mem.getUserFacePictPath() != null && mem.getUserFacePictPath().length() > 0) {
         String muserFacePictSavePath = request.getSession().getServletContext().getRealPath("resources/face_files/")
               + mem.getComCode() + "_" + mem.getgId() + "_FacePict" + mem.getUserFacePictPath();
         
         File file = new File(muserFacePictSavePath);
         if(file.exists()) {
            if(file.delete()) {
               logger.info("FacePict 파일삭제");
            }else {
               logger.info("Error : FacePict 파일삭제");
               return "FacePict/error";
            }
         }else {
            logger.info("FacePict 저장 파일 없음");
         }
      }

      return "redirect:moveInfo.do";
   }
   
   @RequestMapping("moveInfoUpdate.do")
   public ModelAndView moveInfoUpdate(
         HttpSession session,
         HttpServletRequest request,
         @RequestParam("gId") String gId,
         ModelAndView mv) {
   
      Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
            Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
      session.setAttribute("loginUser", member);
      
      String myCom = ((Member)session.getAttribute("loginUser")).getComCode();
      Member mem = new Member();
      
      mem.setComCode(myCom);
      mem.setgId(gId);
      
      mem = infoService.selectMember(mem);
      mv.addObject("member", mem);
      mv.setViewName("hr/infoUpdate");
      return mv;
      
   }
   
   @RequestMapping("InfoUpdate.do")
   public String moveInfoUpdate(
         HttpSession session,
         HttpServletRequest request,
         Member mem,
         @RequestParam(name = "muserFacePictPath", required = false) MultipartFile muserFacePictPath,
         @RequestParam(name = "oFacePictPath", required = false) String oFacePictPath) {
      
      Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
            Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
      session.setAttribute("loginUser", member);
      
      String myCom = ((Member)session.getAttribute("loginUser")).getComCode();
      mem.setComCode(myCom);

      
      if(!muserFacePictPath.isEmpty() && muserFacePictPath.getOriginalFilename() != null && muserFacePictPath.getOriginalFilename().length() > 0) {
         mem.setUserFacePictPath(muserFacePictPath.getOriginalFilename().substring(muserFacePictPath.getOriginalFilename().lastIndexOf(".")));
      }else {
         mem.setUserFacePictPath(oFacePictPath);
      }

      if(infoService.updateMember(mem) != 1) {
         return "common/error";
      }

      
      if(!muserFacePictPath.isEmpty() && muserFacePictPath.getOriginalFilename() != null && muserFacePictPath.getOriginalFilename().length() > 0) {
         try {
            String muserFacePictSavePath = request.getSession().getServletContext().getRealPath("resources/face_files/") 
                  + mem.getComCode() + "_" + mem.getgId() + "_FacePict" 
                  + muserFacePictPath.getOriginalFilename().substring(muserFacePictPath.getOriginalFilename().lastIndexOf("."));

            muserFacePictPath.transferTo(new File(muserFacePictSavePath));
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
      return "redirect:moveInfo.do";
   }
   
   @RequestMapping("memberRetireUpdate.do")
   public String memberRetireUpdate(
         HttpSession session,
         @RequestParam("gId") String gId) {
      
      Member member = new Member("GID009", "COM009", "password012", "Ella Harris", "861010-0123456",
            Date.valueOf("2023-10-10"), "Marketing Manager", "Y");
      session.setAttribute("loginUser", member);
      
      Member mem = new Member();
      mem.setComCode(((Member)session.getAttribute("loginUser")).getComCode());
      mem.setgId(gId);
      
      if(infoService.memberRetireChage(mem) != 1) {
         return "common/error";
      }
      return "redirect:moveInfo.do";
   }
}

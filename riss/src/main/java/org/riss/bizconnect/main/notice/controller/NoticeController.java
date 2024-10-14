package org.riss.bizconnect.main.notice.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.main.notice.model.dto.Notice;
import org.riss.bizconnect.main.notice.model.service.NoticeService;
import org.riss.bizconnect.main.user.model.dto.User; // User VO가 필요함
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {

    private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    @Autowired
    private NoticeService noticeService;

    // 공지사항 목록 보기
    @RequestMapping("noticeList.do")
    public ModelAndView noticeListMethod(ModelAndView mv) {
        ArrayList<Notice> list = noticeService.selectList();
        if (list != null && !list.isEmpty()) {
            mv.addObject("list", list);
            mv.setViewName("notice/noticeListView");
        } else {
            mv.addObject("message", "공지사항 목록 조회 실패!");
            mv.setViewName("common/error");
        }
        return mv;
    }

    // 공지사항 상세 보기
    @RequestMapping("noticeDetail.do")
    public ModelAndView noticeDetailMethod(@RequestParam("no") int noticeNo, ModelAndView mv) {
        Notice notice = noticeService.selectNotice(noticeNo);
        if (notice != null) {
            mv.addObject("notice", notice);
            mv.setViewName("notice/noticeDetailView");
        } else {
            mv.addObject("message", noticeNo + "번 공지사항 조회 실패!");
            mv.setViewName("common/error");
        }
        return mv;
    }

    // 새 공지사항 등록 페이지 이동
    @RequestMapping("moveNoticeWrite.do")
    public String moveNoticeWritePage() {
        return "notice/noticeWriteForm";
    }

    // 새 공지사항 등록 처리
    @RequestMapping(value = "insertNotice.do", method = RequestMethod.POST)
    public String insertNotice(Notice notice, @RequestParam(name = "uploadFile", required = false) MultipartFile file,
            HttpServletRequest request, Model model, HttpSession session) {
        // 세션에서 로그인된 사용자 정보 가져오기
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            model.addAttribute("message", "로그인이 필요합니다.");
            return "common/error";
        }

        // 로그인된 사용자의 COM_CODE 설정
        notice.setComCode(loginUser.getComCode());

        // 중요도 값이 없는 경우 기본값 설정
        if (notice.getImportance() == null || notice.getImportance().isEmpty()) {
            notice.setImportance("N"); // 기본값 'N' 설정
        }

        // 파일 업로드 처리
        if (file != null && !file.isEmpty()) {
            String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles");
            String fileName = file.getOriginalFilename();
            File saveFile = new File(savePath, fileName);

            try {
                file.transferTo(saveFile);
                notice.setOriginalFilePath(fileName);
                notice.setRenameFilePath(fileName); // 파일명을 동일하게 설정
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("message", "파일 업로드 실패!");
                return "common/error";
            }
        }

        // 공지사항 저장
        if (noticeService.insertNotice(notice) > 0) {
            return "redirect:noticeList.do";
        } else {
            model.addAttribute("message", "공지사항 등록 실패!");
            return "common/error";
        }
    }

    // 공지사항 삭제 처리
    @RequestMapping("deleteNotice.do")
    public String deleteNotice(@RequestParam("no") int noticeNo, HttpServletRequest request, Model model) {
        if (noticeService.deleteNotice(noticeNo) > 0) {
            return "redirect:noticeList.do";
        } else {
            model.addAttribute("message", "공지사항 삭제 실패!");
            return "common/error";
        }
    }
}

package org.riss.bizconnect.support.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.riss.bizconnect.common.model.dto.FileDownloadView;
import org.riss.bizconnect.common.model.dto.FileNameChange;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.support.model.dto.Support;
import org.riss.bizconnect.support.service.SupportService;
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
public class SupportController {

	private static final Logger logger = LoggerFactory.getLogger(SupportController.class);

	@Autowired
	private SupportService supportService;

	// 공지사항 수정 페이지로 이동
	@RequestMapping("supportUpdateForm.do")
	public ModelAndView moveUpdatePage(@RequestParam("no") int supportNo, ModelAndView mv) {
		Support support = supportService.selectSupport(supportNo);

		if (support != null) {
			mv.addObject("support", support);
			mv.setViewName("support/supportUpdateView"); // 수정 페이지로 이동
		} else {
			mv.addObject("message", supportNo + "번 공지사항 수정 페이지로 이동 실패!");
			mv.setViewName("common/error");
		}

		return mv;
	}

	// 공지사항 목록 보기 (selectList)
	@RequestMapping("supportList.do")
	public ModelAndView selectSupportList(@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit, HttpSession session, ModelAndView mv) {

		logger.info("공지사항 목록 조회 시작");

		int currentPage = 1;

		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}

		// 총 목록갯수 조회해서 총 페이지 수 계산함
		int listCount = supportService.selectListCount();
		
		//Member loginUser = (Member) session.getAttribute("loginUser");
		
		// 페이지 관련 항목 계산 처리
		String comCode = ((Member) session.getAttribute("loginUser")).getComCode();
		Paging paging = new Paging(comCode, listCount, limit, currentPage, "supportList.do");
		paging.calculate();

		// 서비스롤 목록 조회 요청하고 결과 받기
		ArrayList<Support> list = supportService.selectList(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);

			mv.setViewName("support/supportListView");
		} else {
			mv.addObject("message", "목록 조회 실패!");
			mv.setViewName("common/error");
		}

		return mv;

	}

	// 공지사항 상세 보기 (selectSupport)
	@RequestMapping("supportDetail.do")
	public ModelAndView supportDetailMethod(
			@RequestParam("no") int supportNo, 
			ModelAndView mv, 
			HttpSession session) {
		logger.info("supportdetail.do : " + supportNo);

		Support support = supportService.selectSupport(supportNo);

		supportService.updateAddReadCount(supportNo);

		if (support != null) {
			mv.addObject("support", support);

			Member loginUser = (Member) session.getAttribute("loginUser");
			if (loginUser != null && loginUser.getUserRole().equals("developer")) {
				mv.setViewName("support/supportDeveloperView");
			} else {
				mv.setViewName("support/supportDetailView");
			}
		} else {
			mv.addObject("message", supportNo + "번 공지사항 조회 실패!");
			mv.setViewName("common/error");
		}
		
		return mv;
	}

	// 새 공지사항 등록 페이지 이동
	@RequestMapping("supportWriteForm.do")
	public String upportSupportWritePage() {
		return "support/supportWriteForm";
	}

	// 새 공지사항 등록 처리 (insertSupport)
	@RequestMapping(value = "insertSupport.do", method = RequestMethod.POST)
	public String insertSupport(Support support,
			@RequestParam(name = "uploadFile", required = false) 
			MultipartFile file, 
			HttpServletRequest request,
			Model model, 
			HttpSession session) {

		// 세션에서 로그인된 사용자 정보 가져오기 (실제 로그인 구현에 따라 수정)
		Member loginUser = (Member) session.getAttribute("loginUser");
		if (loginUser == null) {
			model.addAttribute("message", "로그인이 필요합니다.");
			return "common/error";
		}

		support.setComCode(loginUser.getComCode());
		if (support.getImportance() == null || support.getImportance().isEmpty()) {
			support.setImportance("N");
		}

		// 파일 업로드 처리
		if (file != null && !file.isEmpty()) {
			String savePath = request.getSession().getServletContext().getRealPath("/resources/Support_upfiles");
			String fileName = file.getOriginalFilename();
			File saveFile = new File(savePath, fileName);

			try {
				file.transferTo(saveFile);
				support.setOriginalFilePath(fileName);
				support.setRenameFilePath(fileName);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "파일 업로드 실패!");
				return "common/error";
			}
		}

		if (supportService.insertSupport(support) > 0) {
			return "redirect:supportList.do";
		} else {
			model.addAttribute("message", "공지사항 등록 실패!");
			return "common/error";
		}
	}

	// 공지사항 수정 처리
	@RequestMapping(value = "updateSupport.do", method = RequestMethod.POST)
	public String supportUpdateMethod(Support support, Model model, HttpServletRequest request,
			@RequestParam(name = "deleteFlag", required = false) String delFlag,
			@RequestParam(name = "uploadFile", required = false) MultipartFile file) {

		// 중요도 체크 안한 경우 처리
		if (support.getImportance() == null) {
			support.setImportance("N");
		}

		// 첨부파일 관련 변경 사항 처리
		String savePath = request.getSession().getServletContext().getRealPath("/resources/support_upfiles");

		if (support.getOriginalFilePath() != null && support.getOriginalFilePath().length() == 0) {
			support.setOriginalFilePath(null);
			support.setRenameFilePath(null);
		}

		// 기존 파일 삭제 플래그가 있거나 새 파일이 업로드된 경우
		if ((support.getOriginalFilePath() != null && support.getOriginalFilePath().length() > 0)
				&& (delFlag != null && delFlag.equals("yes")) || (file != null && !file.isEmpty())) {
			new File(savePath + "\\" + support.getRenameFilePath()).delete(); // 기존 파일 삭제
			support.setOriginalFilePath(null); // 파일 경로 초기화
			support.setRenameFilePath(null);
		}

		// 새로운 파일 업로드
		if (file != null && !file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			String renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");

			try {
				file.transferTo(new File(savePath + "\\" + renameFileName)); // 파일 저장
				support.setOriginalFilePath(fileName);
				support.setRenameFilePath(renameFileName);
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("message", "파일 업로드 실패!");
				return "common/error";
			}
		}
		logger.info("공지사항 수정 처리 출력 : " + support);
		// 공지사항 수정 처리
		if (supportService.updateSupport(support) > 0) {
			return "redirect:supportDetail.do?no=" + support.getSupportNo();
		} else {
			model.addAttribute("message", support.getSupportNo() + "번 공지사항 수정 실패!");
			return "common/error";
		}
	}

	// 공지사항 삭제 처리
	@RequestMapping("deleteSupport.do")
	public String supportDeleteMethod(@RequestParam("no") int supportNo,
			@RequestParam(name = "rfile", required = false) String renameFileName, HttpServletRequest request,
			Model model) {

		Support support = supportService.selectSupport(supportNo);

		if (supportService.deleteSupport(supportNo) > 0) { // 공지사항 삭제 성공 시
			if (renameFileName != null && renameFileName.length() > 0) { // 첨부파일이 있으면 파일 삭제
				String savePath = request.getSession().getServletContext().getRealPath("/resources/support_upfiles");
				new File(savePath + "\\" + renameFileName).delete(); // 파일 삭제
			}

			return "redirect:supportList.do";
		} else {
			model.addAttribute("message", supportNo + "번 공지사항 삭제 실패!");
			return "common/error";
		}
	}

	// 공지글 제목 검색용 (페이징 처리 포함)
	@RequestMapping("supportsearchTitle.do")
	public ModelAndView searchSupportTitleMethod(ModelAndView mv, 
			@RequestParam("action") String action,
			@RequestParam("keyword") String keyword, 
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit) {

		// page : 출력할 페이지, limit : 한 페이지에 출력할 목록 갯수

		// 페이징 처리
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}

		// 검색결과가 적용된 총 목록갯수 조회해서 총 페이지 수 계산함
		int listCount = supportService.selectSearchTitleCount(keyword);
		// 페이지 관련 항목 계산 처리
		Paging paging = new Paging(listCount, limit, currentPage, "supportsearchTitle.do");
		paging.calculate();

		// 마이바티스 매퍼에서 사용되는 메소드는 Object 1개만 전달할 수 있음
		// paging.startRow, paging.endRow + keyword 같이 전달해야 하므로 => 하나의 객체로 만들어야 함
		Search search = new Search();
		search.setKeyword(keyword);
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());

		// 서비스롤 목록 조회 요청하고 결과 받기
		ArrayList<Support> list = supportService.selectSearchTitle(search);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("action", action);
			mv.addObject("keyword", keyword);

			mv.setViewName("support/supportListView");
		} else {
			mv.addObject("message", action + "에 대한 " + keyword + " 검색 결과가 존재하지 않습니다.");
			mv.setViewName("common/error");
		}

		return mv;
	}

	// 공지글 제목 검색 (페이징 포함)
	@RequestMapping("supportSearchTitle.do")
	public ModelAndView searchSupportTitleMethod(HttpSession session, ModelAndView mv,
			@RequestParam("action") String action,
			@RequestParam("keyword") String keyword, 
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit) {

		// 페이징 처리
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}

		int listCount = supportService.selectSearchTitleCount(keyword);

		String comCode = ((Member) session.getAttribute("loginUser")).getComCode();
		Paging paging = new Paging(comCode, listCount, limit, currentPage, "supportSearchTitle.do");
		paging.calculate();
		
		Search search = new Search();
		search.setKeyword(keyword);
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		
		ArrayList<Support> list = supportService.selectSearchTitle(search);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("keyword", keyword);
			mv.setViewName("support/supportListView");
		} else {
			mv.addObject("message", "검색 결과가 없습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}

	// 공지글 내용 검색 (페이징 포함)
	@RequestMapping("supportSearchContent.do")
	public ModelAndView searchSupportContentMethod(HttpSession session, ModelAndView mv,
			@RequestParam("action") String action, @RequestParam("keyword") String keyword,
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit) {

		// 페이징 처리
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}

		int listCount = supportService.selectSearchContentCount(keyword);
		String comCode = ((Member) session.getAttribute("loginUser")).getComCode();

		Paging paging = new Paging(comCode, listCount, limit, currentPage, "supportSearchContent.do");
		paging.calculate();
		
		Search search = new Search();
		search.setKeyword(keyword);
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		
		ArrayList<Support> list = supportService.selectSearchContent(search);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("keyword", keyword);
			mv.setViewName("support/supportListView");
		} else {
			mv.addObject("message", "검색 결과가 없습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}

	// 공지글 등록 날짜 검색 (페이징 포함)
	@RequestMapping("supportSearchDate.do")
	public ModelAndView searchSupportDateMethod(
			ModelAndView mv, Search search,
			@RequestParam("action") String action,
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String slimit, 
			HttpSession session) {

		// 페이징 처리
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지에 출력할 공지 갯수 10개로 지정
		int limit = 10;
		if (slimit != null) {
			limit = Integer.parseInt(slimit);
		}
		
		int listCount = supportService.selectSearchDateCount(search);
		
		String comCode = ((Member) session.getAttribute("loginUser")).getComCode();
		Paging paging = new Paging(comCode, listCount, limit, currentPage, "supportSearchDate.do");
		paging.calculate();
		
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		
		ArrayList<Support> list = supportService.selectSearchDate(search);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("action", action);
			mv.addObject("begin", search.getBegin());
			mv.addObject("end", search.getEnd());
			
			mv.setViewName("support/supportListView");
		} else {
			mv.addObject("message", action + "에 대한 " + search.getBegin() + "부터 " 
					+ search.getEnd() + "기간 사이에 등록한 공지글 검색 결과가 존재하지 않습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}
}
package org.riss.bizconnect.hr.document.model.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.riss.bizconnect.hr.document.model.dto.Contracts;
import org.riss.bizconnect.hr.document.model.service.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContractsController {
    
    @Autowired
    private ContractsService contractsService; // 서비스 주입
    
 // 증명서 목록 조회
    @GetMapping("/conList.do")
    public String selectContractss(Model model) {
        List<Contracts> contractsList = contractsService.selectContractss();
        model.addAttribute("contractsList", contractsList);
        return "hr/ContractsList"; // JSP 페이지 이름
    }

    @RequestMapping(value = "/conView.do", method = RequestMethod.POST) 
    public String selectContractsById(@RequestParam("contractsId") String contractsId, Model model) {
        // POST 요청 처리 로직
        Contracts contracts = contractsService.selectContractsById(contractsId);
        model.addAttribute("contracts", contracts);
        return "hr/contractsDetail"; // 상세보기 JSP 페이지 이름
    }

    // 증명서 추가 페이지로 이동
    @GetMapping("/conAddView.do")
    public String addContractsForm() {
        return "hr/contractsAdd"; // 추가 페이지 JSP 이름
    }

        @PostMapping("/conAdd.do")
        public String addContracts(@RequestParam("contractsTitle") String title,
                                     @RequestParam("contractsDescription") String description,
                                     @RequestParam("file") MultipartFile file,
                                     Model model) {
            // 파일 저장 로직
            if (!file.isEmpty()) {
                try {
                    // 파일 저장 경로 설정
                    String uploadDir = "src/main/webapp/resources/contracts_files/";
                    String fileName = file.getOriginalFilename();
                    File saveFile = new File(uploadDir + fileName);
                    
                    // 파일을 지정된 경로에 저장
                    file.transferTo(saveFile);
                    
                    // 필요시 저장된 파일 경로 DB에 저장하는 로직 추가
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("message", "파일 업로드 실패");
                    return "common/errorPage"; // 에러 페이지로 이동
                }
            }

            // 비즈니스 로직 처리 후 목록 페이지로 리다이렉트
            return "redirect:/conList.do";
        }
        
    // 상세 수정 페이지 이동
    @PostMapping("/conDetailUpdate.do")
    public String updateContracts(
    		@RequestParam("contractsId") String contractsId, Model model) {
        Contracts contracts = contractsService.selectContractsById(contractsId);
        model.addAttribute("contracts", contracts);
        return "hr/contractsUpdate"; // 수정 페이지로 이동
    }
    
    // 증명서 수정
    @PostMapping("/conUpdate.do")
    public String updateContracts(
    		@ModelAttribute Contracts contracts, 
    		@RequestParam("file") MultipartFile file) {
        // 파일이 비어있지 않은 경우
        if (!file.isEmpty()) {
            // 파일 저장 경로 (JSP에서 접근할 수 있는 경로로 설정)
            String filePath = "/resources/contracts_files/" + file.getOriginalFilename();
            try {
                // 파일 저장
                file.transferTo(new File("src/main/webapp" + filePath));
                contracts.setContractsFile(filePath); // DTO에 파일 경로 설정
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 증명서 업데이트 서비스 호출
        contractsService.updateContracts(contracts);
        
        // 목록 페이지로 리다이렉트
        return "redirect:/conList.do";
    }

    @RequestMapping(value = "/conDelete.do", method = RequestMethod.POST)
    public ModelAndView deleteContracts(
            @RequestParam("contractsId") String contractsId) {
        // 문자열 ID를 사용하여 삭제
        contractsService.deleteContracts(contractsId); // 서비스 호출

        // 목록 페이지로 리다이렉트
        return new ModelAndView("redirect:/conList.do");
    }
}
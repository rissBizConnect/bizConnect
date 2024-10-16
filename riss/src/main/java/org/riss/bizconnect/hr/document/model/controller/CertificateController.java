package org.riss.bizconnect.hr.document.model.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.riss.bizconnect.hr.document.model.dto.Certificate;
import org.riss.bizconnect.hr.document.model.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CertificateController {
    
    @Autowired
    private CertificateService certificateService; // 서비스 주입
    
    // 증명서 목록 조회
    @GetMapping("cerList.do")
    public String selectCertificates(Model model) {
        List<Certificate> certificateList = certificateService.selectCertificates();
        model.addAttribute("certificateList", certificateList);
        return "hr/certificateList"; // JSP 페이지 이름
    }

    // 증명서 상세보기 메서드
    @GetMapping("cerView.do/{contractId}")
    public String selectCertificateById(@PathVariable String contractId, Model model) {
        Certificate certificate = certificateService.selectCertificateById(contractId);
        model.addAttribute("certificate", certificate);
        return "hr/certificateDetail"; // 상세보기 JSP 페이지 이름
    }
    
    // 증명서 추가 페이지로 이동
    @GetMapping("cerAdd.do")
    public String addCertificateForm() {
        return "hr/certificateAdd"; // 추가 페이지 JSP 이름
    }
    // 증명서 추가
    @PostMapping("cerAdd.do")
    public String insertCertificate(@ModelAttribute Certificate certificate, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String filePath = "resources/certificate_files/" + file.getOriginalFilename();
            try {
                file.transferTo(new File(filePath));
                certificate.setCertificateFile(filePath); // DTO에 파일 경로 설정
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        certificateService.insertCertificate(certificate);
        return "redirect:cerList.do"; // 목록 페이지로 리다이렉트
    }
 
    // 증명서 수정
    @PostMapping("/cerUpdate.do")
    public String updateCertificate(@ModelAttribute Certificate certificate, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String filePath = "src/main/webapp/resources/certificate_files/" + file.getOriginalFilename();
            try {
                file.transferTo(new File(filePath));
                certificate.setCertificateFile(filePath); // DTO에 파일 경로 설정
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        certificateService.updateCertificate(certificate);
        return "redirect:/certificate/cerList.do"; // 목록 페이지로 리다이렉트
    }

    // 증명서 삭제
    @PostMapping("cerDelete.do")
    public String deleteCertificate(@PathVariable int contractId) {
        certificateService.deleteCertificate(contractId);
        return "redirect:/cerList.do";
    }
}

package org.riss.bizconnect.pd.pomgmt.model.controller;

import org.riss.bizconnect.pd.ordreport.model.dto.OrdreportDTO;
import org.riss.bizconnect.pd.ordreport.model.service.OrdreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordreport")
public class OrdreportController {
	// REST APi의 엔드포인트를 제공하는 컨트롤러
	// HTTP 요청 받고 응답을 처리

    private final OrdreportService ordreportService;

    @Autowired
    public OrdreportController(OrdreportService ordreportService) {
        this.ordreportService = ordreportService;
    }

    @PostMapping
    public ResponseEntity<String> createOrdreport(@RequestBody OrdreportDTO ordreport) {
        ordreportService.createOrdreport(ordreport);
        return ResponseEntity.ok("거래명세서가 생성되었습니다.");
    }

    @DeleteMapping("/{orderCd}")
    public ResponseEntity<String> deleteOrdreport(@PathVariable Long orderCd) {
        ordreportService.deleteOrdreport(orderCd);
        return ResponseEntity.ok("거래명세서가 삭제되었습니다.");
    }

    @PutMapping
    public ResponseEntity<String> updateOrdreport(@RequestBody OrdreportDTO ordreport) {
        ordreportService.updateOrdreport(ordreport);
        return ResponseEntity.ok("거래명세서가 수정되었습니다.");
    }

    @GetMapping("/{orderCd}")
    public ResponseEntity<OrdreportDTO> findOrdreportById(@PathVariable Long orderCd) {
        OrdreportDTO ordreport = ordreportService.findOrdreportById(orderCd);
        return ResponseEntity.ok(ordreport);
    }

    @GetMapping("/payment-history/{orderCd}")
    public ResponseEntity<List<OrdreportDTO>> findPaymentHistory(@PathVariable Long orderCd) {
        List<OrdreportDTO> paymentHistory = ordreportService.findPaymentHistory(orderCd);
        return ResponseEntity.ok(paymentHistory);
    }

    @GetMapping("/check-payment-status/{orderCd}")
    public ResponseEntity<Boolean> checkPaymentStatus(@PathVariable Long orderCd) {
        boolean status = ordreportService.checkPaymentStatus(orderCd);
        return ResponseEntity.ok(status);
    }
}
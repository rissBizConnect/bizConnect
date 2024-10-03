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
	// REST APi�� ��������Ʈ�� �����ϴ� ��Ʈ�ѷ�
	// HTTP ��û �ް� ������ ó��

    private final OrdreportService ordreportService;

    @Autowired
    public OrdreportController(OrdreportService ordreportService) {
        this.ordreportService = ordreportService;
    }

    @PostMapping
    public ResponseEntity<String> createOrdreport(@RequestBody OrdreportDTO ordreport) {
        ordreportService.createOrdreport(ordreport);
        return ResponseEntity.ok("�ŷ������� �����Ǿ����ϴ�.");
    }

    @DeleteMapping("/{orderCd}")
    public ResponseEntity<String> deleteOrdreport(@PathVariable Long orderCd) {
        ordreportService.deleteOrdreport(orderCd);
        return ResponseEntity.ok("�ŷ������� �����Ǿ����ϴ�.");
    }

    @PutMapping
    public ResponseEntity<String> updateOrdreport(@RequestBody OrdreportDTO ordreport) {
        ordreportService.updateOrdreport(ordreport);
        return ResponseEntity.ok("�ŷ������� �����Ǿ����ϴ�.");
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
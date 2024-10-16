package org.riss.bizconnect.hr.document.model.service;

import java.util.List;

import org.riss.bizconnect.hr.document.model.dto.Certificate;

public interface CertificateService {
	   
	// 증명서 목록 조회
    List<Certificate> selectCertificates();

    // 증명서 상세 조회
    Certificate selectCertificateById(String certificateId);

    // 증명서 추가
    int insertCertificate(Certificate certificate);

    // 증명서 수정
    int updateCertificate(Certificate certificate);

    // 증명서 삭제
	int deleteCertificate(String certificateId);

    
}

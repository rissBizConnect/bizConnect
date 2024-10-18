package org.riss.bizconnect.hr.document.model.service;

import java.util.List;

import org.riss.bizconnect.hr.document.model.dto.Contracts;

public interface ContractsService {
	   
	// 증명서 목록 조회
    List<Contracts> selectContracts();

    // 증명서 상세 조회
    Contracts selectContractsById(String contractsId);

    // 증명서 추가
    int insertContracts(Contracts contracts);

    // 증명서 수정
    int updateContracts(Contracts contracts);

    // 증명서 삭제
	int deleteContracts(String contractsId);

    
}

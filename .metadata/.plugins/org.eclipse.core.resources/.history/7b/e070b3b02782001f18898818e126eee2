package org.riss.bizconnect.hr.retiree.model.service;

import org.riss.bizconnect.hr.retiree.model.dto.RetireDTO;

import java.util.List;

public interface RetireService {
    RetireDTO findRetire(int retNo, String comCode);      // 퇴직자 정보 조회
    List<RetireDTO> findAllRetires();                     // 모든 퇴직자 정보 조회
    void registerRetire(RetireDTO retire);                // 퇴직자 정보 등록
    void modifyRetire(RetireDTO retire);                  // 퇴직자 정보 수정
}

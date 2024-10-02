package org.riss.bizconnect.hr.retiree.model.dao;

import org.riss.bizconnect.hr.retiree.model.dto.RetireDTO;

import java.util.List;

public interface RetireDAO {
    RetireDTO getRetireInfo(int retNo, String comCode); // 퇴직자 정보 조회
    List<RetireDTO> getAllRetires();                    // 모든 퇴직자 정보 조회
    void addRetire(RetireDTO retire);                    // 퇴직자 정보 추가
    void updateRetire(RetireDTO retire);                 // 퇴직자 정보 수정
}
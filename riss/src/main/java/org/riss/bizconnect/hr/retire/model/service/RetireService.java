package org.riss.bizconnect.hr.retire.model.service;

import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RetireService {
	List<Retire> selectRetireList(); // 퇴직자 목록 조회
    List<Retire> selectAllRetirees(); // 모든 퇴직자 조회
    int selectListCount(); // 퇴직자 수 조회
    
    void addRetire(Retire retire); // 퇴직자 추가
    void updateRetire(Retire retire); // 퇴직자 수정
    void deleteRetire(String retNo); // 퇴직자 삭제
    Retire getRetireById(String retNo); // 퇴직자 ID로 조회
    
    // 사원 -> 퇴직자 변환
    boolean convertToRetire(String gid);
    boolean convertToWorker(String retNo);
	List<Retire> getRetireList(String comCode);
	
}

package org.riss.bizconnect.hr.retire.model.service;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.retire.model.dto.Retire;

import java.util.ArrayList;
import java.util.List;

public interface RetireService {
	
	List<Retire> getRetireList(Paging paging); // 페이징 처리된 퇴직자 목록
    int getRetireListCount(); // 총 퇴직자 수
	int addRetire(Retire retire);
    int updateRetire(Retire retire);
    int deleteRetire(String retNo);

    //페이징 처리
	ArrayList<Retire> selectRetireList(Paging paging);
	int selectListCount(Member member);
	ArrayList<Retire> selectAllRetirees(String comCode);
}

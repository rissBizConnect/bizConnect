package org.riss.bizconnect.hr.retire.model.service;

import java.util.ArrayList;
import java.util.Date;

import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.retire.model.dto.Retire;

public interface RetireService {
	    void insertRetire(Retire retire);
	    Retire selectRetireByRetNo(String retNo);
	    void updateRetire(Retire retire);
	    void deleteRetire(String retNo);
		int selectRetireCount(Retire retire);
		ArrayList<Retire> selectRetireList(Paging paging);
		void updateRetireToMember(Retire retire);
	
		// 상태 변환 메소드: 퇴직자 → 사원, 사원 → 퇴직자
	    int insertRetireChange(Retire retire);
	    int updateRetireChange(Retire retire);		
		int convertRetireToMember(Retire retire);
		Retire selectRetireByGidAndComCode(Retire retire);
		int deleteRetireChange(Retire retire);
		// 총근무일
		int calculateTotalWorkingDays(Date userEntryDate, Date retDate);
	    void addRetire(Retire retire);
}

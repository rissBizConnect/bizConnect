package org.riss.bizconnect.hr.retire.model.service;

import java.util.ArrayList;
import java.util.List;

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
	
}

package org.riss.bizconnect.hr.retire.model.service;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.retire.model.dao.RetireDAO;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("retireService")
public class RetireServiceImpl implements RetireService {
    
	@Autowired
	private RetireDAO retireDAO;
	
	

	    @Override
	    public void insertRetire(Retire retire) {
	        retireDAO.insertRetire(retire);
	    }

	    @Override
	    public Retire selectRetireByRetNo(String retNo) {
	        return retireDAO.selectRetireByRetNo(retNo);
	    }

	    @Override
	    public void updateRetire(Retire retire) {
	        retireDAO.updateRetire(retire);
	    }

	    @Override
	    public void deleteRetire(String retNo) {
	        retireDAO.deleteRetire(retNo);
	    }

		@Override
		public int selectRetireCount(Retire retire) {
			return retireDAO.selectRetireCount(retire);
		}

		@Override
		public ArrayList<Retire> selectRetireList(Paging paging) {
			return retireDAO.selectRetireList(paging);
		}

		
		//퇴직자 사원 변환
		@Override
		public void updateRetireToMember(Retire retire) {
			retireDAO.updateRetireToMember(retire);
			
		}

		
		
		

 
	
}

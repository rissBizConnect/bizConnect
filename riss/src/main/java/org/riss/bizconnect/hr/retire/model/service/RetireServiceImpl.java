package org.riss.bizconnect.hr.retire.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.retire.model.dao.RetireDAO;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.riss.bizconnect.main.member.model.dao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("retireService")
public class RetireServiceImpl implements RetireService {

	@Autowired
	private RetireDAO retireDAO;
	
	@Autowired
	private MemberDAO memberDAO;

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

	//퇴직자 -> 사원
	@Override
	public Retire selectRetireByGidAndComCode(Retire retire) {
		return retireDAO.selectRetireList(retire);
	}

	@Override
	public int insertRetireChange(Retire retire) {
		return retireDAO.insertRetireChange(retire);
	}

	@Override
	public int updateRetireChange(Retire retire) {
		return retireDAO.updateRetireChange(retire);
	}

	@Override
	public int deleteRetireChange(Retire retire) {
		return retireDAO.deleteRetireChange(retire);
	}


	@Override
	public int convertRetireToMember(Retire retire) {
		return retireDAO.convertRetireToMember(retire);
		
	}


	
}
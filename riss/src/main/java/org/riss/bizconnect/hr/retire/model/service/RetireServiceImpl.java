package org.riss.bizconnect.hr.retire.model.service;

import java.util.ArrayList;
import java.util.List;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.retire.model.controller.RetireController;
import org.riss.bizconnect.hr.retire.model.dao.RetireDAO;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("RetireService")
public class RetireServiceImpl implements RetireService {

    @Autowired
    private RetireDAO retireDAO;
    private static final Logger logger = LoggerFactory.getLogger(RetireController.class);
	@Override
	
	public List<Retire> getRetireList(Paging paging) {
		return retireDAO.getRetireList(paging);
	}
	@Override
	public int getRetireListCount() {
		return retireDAO.getRetireListCount();
	}
	@Override
	public int addRetire(Retire retire) {
		return retireDAO.addRetire(retire);
	}
	@Override
	public int updateRetire(Retire retire) {
		return retireDAO.updateRetire(retire);
	}
	@Override
	public int deleteRetire(String retNo) {
		return retireDAO.deleteRetire(retNo);
	}
	@Override
	public ArrayList<Retire> selectRetireList(Paging paging) {
		return retireDAO.selectRetireList(paging);
	}
	@Override
	public int selectListCount(Member member) {
		return retireDAO.selectListCount(member);
	}
	@Override
	public ArrayList<Retire> selectAllRetirees(String comCode) {
		return retireDAO.selectAllRetirees(comCode);
	}
    
  
}
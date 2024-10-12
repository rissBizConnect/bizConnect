package org.riss.bizconnect.hr.retire.model.service;

import java.util.List;

import org.riss.bizconnect.hr.retire.model.dao.RetireDAO;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("retireService")
public class RetireServiceImpl implements RetireService {
    
	@Autowired
	private RetireDAO retireDAO;
	
	@Override
	public List<Retire> selectRetireList() {
		return retireDAO.selectRetireList();
	}

	@Override
	public List<Retire> selectAllRetirees() {
		return retireDAO.selectAllRetirees();
	}

	@Override
	public List<Retire> getRetireList(String comCode) {
		return retireDAO.selectRetireList(comCode);
	}
	
	@Override
	public int selectListCount() {
		return retireDAO.selectListCount();
	}
	
    @Override
    public void addRetire(Retire retire) {
        retireDAO.addRetire(retire);
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
    public Retire getRetireById(String retNo) {
        return retireDAO.getRetireById(retNo);
    }
   
    // 사원 -> 퇴직자 변환
    @Override
    public boolean convertToRetire(String gid) {
        return retireDAO.updateToRetire(gid) > 0;
    }
    // 퇴직자 -> 사원 변환
    @Override
    public boolean convertToWorker(String retNo) {
        return retireDAO.updateToWorker(retNo) > 0;
    }

	

	
	
}

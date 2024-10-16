package org.riss.bizconnect.pd.check.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.check.model.dao.CheckDAO;
import org.riss.bizconnect.pd.check.model.dto.CheckDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("checkService")
public class CheckServiceImpl implements CheckService {
	
	@Autowired
	private CheckDAO checkDAO;

	public CheckDAO getCheckDAO() {
		return checkDAO;
	}

	public void setCheckDAO(CheckDAO checkDAO) {
		this.checkDAO = checkDAO;
	}

	public ArrayList<CheckDTO> listAllChecks() {
		return null;
	}
	
	public Optional<CheckDTO> selectorderNo() {
		return null;
	}

	@Override
	public Optional<CheckDTO> selectorderNo(String OrderNo) {
		// TODO Auto-generated method stub
		return null;
	}
}

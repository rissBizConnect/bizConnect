package org.riss.bizconnect.pd.porder.service;

import java.util.ArrayList;

import org.riss.bizconnect.pd.porder.dao.PorderDAO;
import org.riss.bizconnect.pd.porder.dto.PorderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("poderService")
public class PorderServiceImpl implements PorderService {

	@Autowired
	private PorderDAO poderDAO;
	
	@Override
	public ArrayList<PorderDTO> selectList() {
		return poderDAO.selectList();
	}
	
}

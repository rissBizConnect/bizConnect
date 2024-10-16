package org.riss.bizconnect.pd.porder.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.porder.model.dto.PorderDTO;
import org.riss.bizconnect.pd.porder.model.dao.PorderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("porderService")
public class PorderServiceImpl implements PorderService {

	@Autowired
	private PorderDAO porderDAO;
	
	public PorderDTO getPorderNo(int PorderNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<PorderDTO> listAllPorders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPorder(PorderDTO porder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePorder(PorderDTO porder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePorder(int porderNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<PorderDTO> selectPorderNo(int PorderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertporder(PorderDTO pord) {
		return porderDAO.insertporder(pord);
	}

	/*
	@Override
	public ArrayList<PorderDTO> selectList() {
		return poderDAO.selectList();
	}*/
	
}

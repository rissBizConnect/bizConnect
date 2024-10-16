package org.riss.bizconnect.pd.ref.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.ref.model.dao.RefDAO;
import org.riss.bizconnect.pd.ref.model.dto.RefDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("refService")
public class RefServiceImpl implements RefService {

	@Autowired
	private RefDAO refDAO;
	
	public RefDAO getRefDAO() {
		return refDAO;
	}

	public void setRefDAO(RefDAO refDAO) {
		this.refDAO = refDAO;
	}

	@Override
	public ArrayList<RefDTO> listAllRefs() {
		return null;
	}
}

package org.riss.bizconnect.hr.document.model.service;

import java.util.List;

import org.riss.bizconnect.hr.document.model.dao.ContractsDAO;
import org.riss.bizconnect.hr.document.model.dto.Contracts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ContractsService")
public class ContractsServiceImpl implements ContractsService {
	
	@Autowired
	private ContractsDAO contractsDAO;

	@Override
    public List<Contracts> selectContractss() {
        return contractsDAO.selectContractss();
    }

    @Override
    public Contracts selectContractsById(String contractsId) {
        return contractsDAO.selectContractsById(contractsId);
    }

    @Override
    public int insertContracts(Contracts contracts) {
        return contractsDAO.insertContracts(contracts);
    }

    @Override
    public int updateContracts(Contracts contracts) {
        return contractsDAO.updateContracts(contracts);
    }

	@Override
	public int deleteContracts(String contractsId) {
		return contractsDAO.deleteContracts(contractsId);
	}

	
   

	
}
package org.riss.bizconnect.pd.client.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.client.model.dao.ClientDAO;
import org.riss.bizconnect.pd.client.model.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;

	@Override
	public int insertclient(ClientDTO clientDTO) {
		return clientDAO.insertclient(clientDTO);
	}

	@Override
	public ArrayList<ClientDTO> selectAll(String myCom) {
		return clientDAO.selectAll(myCom);
	}

	@Override
	public int deleteClient(ClientDTO client) {
		return clientDAO.deleteClient(client);
	}

	@Override
	public ClientDTO selectClientOne(ClientDTO clientDTO) {
		return clientDAO.selectClientOne(clientDTO);
	}

	@Override
	public int update(ClientDTO client) {
		return clientDAO.update(client);
	}
	
	
}

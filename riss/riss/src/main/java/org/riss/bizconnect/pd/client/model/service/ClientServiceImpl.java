package org.riss.bizconnect.pd.client.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.client.model.dao.ClientDAO;
import org.riss.bizconnect.pd.client.model.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;

	@Override
	public ArrayList<ClientDTO> listAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ClientDTO> getclients(String ClientCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertclient(ClientDTO client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateclient(String ClientCode, ClientDTO client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteclient(String ClientCode) {
		// TODO Auto-generated method stub
		
	}
	
	
}

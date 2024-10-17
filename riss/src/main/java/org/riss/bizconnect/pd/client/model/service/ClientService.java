package org.riss.bizconnect.pd.client.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.client.model.dto.ClientDTO;

public interface ClientService {

	int insertclient(ClientDTO clientDTO);

	ArrayList<ClientDTO> selectAll(String myCom);

	int deleteClient(ClientDTO client);

	ClientDTO selectClientOne(ClientDTO clientDTO);

	int update(ClientDTO client);


}

package org.riss.bizconnect.pd.client.model.service;

import java.util.ArrayList;
import java.util.Optional;

import org.riss.bizconnect.pd.client.model.dto.ClientDTO;

public interface ClientService {
	ArrayList<ClientDTO> listAllClients();
	Optional<ClientDTO> getclients(String ClientCode);
	void insertclient(ClientDTO client);
	void updateclient(String ClientCode, ClientDTO client);
	void deleteclient(String ClientCode);
}

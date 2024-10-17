package org.riss.bizconnect.pd.client.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.client.model.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("clientDAO")
public class ClientDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ArrayList<ClientDTO> selectAllList() {
		List<ClientDTO> list = sqlSessionTemplate.selectList("clientMapper.select");
		return (ArrayList<ClientDTO>)list;
	}

	public int insertclient(ClientDTO client) {
		return sqlSessionTemplate.insert("clientMapper.insertclient", client);
	}

	public ArrayList<ClientDTO> selectAll(String myCom) {
		List<ClientDTO> list = sqlSessionTemplate.selectList("clientMapper.selectAll", myCom);
		return (ArrayList<ClientDTO>)list;
	}

	public int deleteClient(ClientDTO client) {
		return sqlSessionTemplate.delete("clientMapper.deleteClient", client);
	}

	public ClientDTO selectClientOne(ClientDTO clientDTO) {
		return sqlSessionTemplate.selectOne("clientMapper.selectClientOne", clientDTO);
	}

	public int update(ClientDTO client) {
		return sqlSessionTemplate.update("clientMapper.update", client);
	}
}

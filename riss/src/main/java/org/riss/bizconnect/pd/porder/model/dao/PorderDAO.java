package org.riss.bizconnect.pd.porder.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.porder.model.dto.PorderDTO;
import org.riss.bizconnect.product.model.dto.Testa4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("porderDAO")
public class PorderDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ArrayList<PorderDTO> selectList() {
		List<PorderDTO> list = sqlSessionTemplate.selectList("porderMapper.select");
		return (ArrayList<PorderDTO>)list;
	}

	public int insertporder(PorderDTO pord) {
		return sqlSessionTemplate.insert("porderMapper.insertporder", pord);
	}
	
//	public int insertporder(PorderDTO pord) {
//		return sqlSessionTemplate.insert("porderMapper.insertporder", pord);
//	}

	
	
	
	
	
	/*
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public ArrayList<PorderDTO> selectList() {
		List<PorderDTO> list = sqlSessionTemplate.selectList("porderMapper.select");
		return (ArrayList<PorderDTO>)list;
	}*/
	
}

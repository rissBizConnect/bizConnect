package org.riss.bizconnect.pd.porder.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.porder.dto.PorderDTO;
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
	
	
	
	
	
	
	
	/*
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public ArrayList<PorderDTO> selectList() {
		List<PorderDTO> list = sqlSessionTemplate.selectList("porderMapper.select");
		return (ArrayList<PorderDTO>)list;
	}*/
	
}

package org.riss.bizconnect.pd.check.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.check.model.dto.CheckDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CheckDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public ArrayList<CheckDTO> selectList() {
		List<CheckDTO> list = sqlSessionTemplate.selectList("checkMapper.select");
		return (ArrayList<CheckDTO>)list;
	}
}

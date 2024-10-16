package org.riss.bizconnect.pd.ref.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.pd.ref.model.dto.RefDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RefDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public int insertRef(RefDTO ref) {
		return sqlSessionTemplate.insert("refMapper.insertRef", ref);
	}

	public ArrayList<RefDTO> selectList(String porderNo) {
	    List<RefDTO> list = sqlSessionTemplate.selectList("refMapper.OrderByPorder", porderNo);
	    return (ArrayList<RefDTO>) list;
	}
}

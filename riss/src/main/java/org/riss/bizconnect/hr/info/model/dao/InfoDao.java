package org.riss.bizconnect.hr.info.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("infoDao")
public class InfoDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
}

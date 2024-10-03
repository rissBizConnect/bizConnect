package org.riss.bizconnect.hr.attendance.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("attendanceDao")
public class AttendanceDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int goCheck() {
		return sqlSessionTemplate.insert("attendanceMapper.insertGoCheck");
	}
}

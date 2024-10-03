package org.riss.bizconnect.hr.attendance.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.hr.model.dto.GooutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("attendanceDao")
public class AttendanceDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public GooutTime gooutCheck(Member logginUser) {
		return sqlSessionTemplate.selectOne("attendanceMapper.selectGooutCheck",logginUser);
	}

	public String test() {
		return sqlSessionTemplate.selectOne("attendanceMapper.selecttest");
	}
}

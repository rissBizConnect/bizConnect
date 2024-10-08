package org.riss.bizconnect.hr.attendance.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.hr.attendance.model.dto.GooutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("attendanceDao")
public class AttendanceDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public GooutTime selectTodayGOTime(Member loginUser) {
		return sqlSessionTemplate.selectOne("attendanceMapper.selectTodayGOTime",loginUser);
	}

	public int insertGOTime(Member loginUser) {
		return sqlSessionTemplate.insert("attendanceMapper.insertGOTime",loginUser);
	}

	public int updateGoD(Member loginUser) {
		return sqlSessionTemplate.update("attendanceMapper.updateGoD",loginUser);
	}

	public int updateOutD(Member loginUser) {
		return sqlSessionTemplate.update("attendanceMapper.updateOutD",loginUser);
	}
}

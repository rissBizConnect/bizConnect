package org.riss.bizconnect.hr.attendance.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.hr.attendance.controller.AttendanceController;
import org.riss.bizconnect.hr.attendance.model.dto.Attendance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("attendanceDao")
public class AttendanceDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
	
	@Transactional
	public Attendance selectTodayAttendance(Member loginUser) {
		return sqlSessionTemplate.selectOne("attendanceMapper.selectTodayAttendance",loginUser);
	}
	
	@Transactional
	public int insertAttendance(Member loginUser) {
		return sqlSessionTemplate.insert("attendanceMapper.insertAttendance",loginUser);
	}
	
	@Transactional
	public int updateGoD(Member loginUser) {
		return sqlSessionTemplate.update("attendanceMapper.updateGoD",loginUser);
	}
	
	@Transactional
	public int updateOutD(Member loginUser) {
		return sqlSessionTemplate.update("attendanceMapper.updateOutD",loginUser);
	}

	public ArrayList<Attendance> selectMyAttendance(Member loginUser) {
		List<Attendance> list = sqlSessionTemplate.selectList("attendanceMapper.selectMyAttendance",loginUser);
		return (ArrayList<Attendance>)list;
	}
}

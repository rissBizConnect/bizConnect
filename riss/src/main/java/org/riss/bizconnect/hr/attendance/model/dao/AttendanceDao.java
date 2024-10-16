package org.riss.bizconnect.hr.attendance.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
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

	public Attendance selectTodayAttendance(Member member) {
		return sqlSessionTemplate.selectOne("attendanceMapper.selectTodayAttendance",member);
	}
	
	public int insertAttendance(Member member) {
		return sqlSessionTemplate.insert("attendanceMapper.insertAttendance",member);
	}

	public int updateGoD(Attendance loginUser) {
		return sqlSessionTemplate.update("attendanceMapper.updateGoD",loginUser);
	}
	
	public int updateOutD(Attendance loginUser) {
		return sqlSessionTemplate.update("attendanceMapper.updateOutD",loginUser);
	}

	public ArrayList<Attendance> selectMyAttendance(Paging paging) {
		List<Attendance> list = sqlSessionTemplate.selectList("attendanceMapper.selectMyAttendance",paging);
		return (ArrayList<Attendance>)list;
	}

	public int selectListCount(Member loginUser) {
		return sqlSessionTemplate.selectOne("attendanceMapper.selectListCount", loginUser);
	}

	public int selectComListCount(Member loginUser) {
		return sqlSessionTemplate.selectOne("attendanceMapper.selectComListCount", loginUser);
	}

	public ArrayList<Attendance> selectComAttendance(Paging paging) {
		List<Attendance> list = sqlSessionTemplate.selectList("attendanceMapper.selectComAttendance",paging);
		return (ArrayList<Attendance>)list;
	}

	public int selectComFileterMListCount(Member loginUser) {
		return sqlSessionTemplate.selectOne("attendanceMapper.selectComFileterMListCount", loginUser);
	}

	public ArrayList<Attendance> selectComFileterMAttendance(Paging paging) {
		List<Attendance> list = sqlSessionTemplate.selectList("attendanceMapper.selectComFileterMAttendance",paging);
		return (ArrayList<Attendance>)list;
	}

	public ArrayList<String> selectComMListCount(String comCode) {
		List<String> list = sqlSessionTemplate.selectList("attendanceMapper.selectComMListCount", comCode);
		return (ArrayList<String>)list;
	}

	public int selectComDateMListCount(Search search) {
		return sqlSessionTemplate.selectOne("attendanceMapper.selectComDateMListCount", search);
	}

	public ArrayList<Attendance> selectComDateAttendance(Search search) {
		List<Attendance> list = sqlSessionTemplate.selectList("attendanceMapper.selectComDateAttendance", search);
		return (ArrayList<Attendance>)list;
	}

	public int selectComFileterWorkNListCount(Member member) {
		return sqlSessionTemplate.selectOne("attendanceMapper.selectComFileterWorkNListCount", member);
	}

	public int selectComFileterWorkANListCount(Member member) {
		return sqlSessionTemplate.selectOne("attendanceMapper.selectComFileterWorkANListCount", member);
	}

	public ArrayList<Attendance> selectComFileterWorkNAttendance(Paging paging) {
		List<Attendance> list = sqlSessionTemplate.selectList("attendanceMapper.selectComFileterWorkNAttendance",paging);
		return (ArrayList<Attendance>)list;
	}

	public ArrayList<Attendance> selectComFileterWorkANAttendance(Paging paging) {
		List<Attendance> list = sqlSessionTemplate.selectList("attendanceMapper.selectComFileterWorkANAttendance",paging);
		return (ArrayList<Attendance>)list;
	}

	public ArrayList<Attendance> selectComList(Member member) {
		List<Attendance> list = sqlSessionTemplate.selectList("attendanceMapper.selectComList",member);
		return (ArrayList<Attendance>)list;
	}

	public int updateAttendnce(Attendance attendance) {
		return sqlSessionTemplate.update("attendanceMapper.updateAttendnce",attendance);
	}
}

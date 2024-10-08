package org.riss.bizconnect.hr.attendance.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.attendance.controller.AttendanceController;
import org.riss.bizconnect.hr.attendance.model.dao.AttendanceDao;
import org.riss.bizconnect.hr.attendance.model.dto.Attendance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
	private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);
	@Autowired
	private AttendanceDao attendanceDao;

	@Override
	public Attendance selectTodayAttendance(Member member) {
		return attendanceDao.selectTodayAttendance(member);
	}

	@Override
	public int insertAttendance(Member member) {
		return attendanceDao.insertAttendance(member);
	}

	@Override
	public int updateGoD(Attendance attendance) {
		return attendanceDao.updateGoD(attendance);
	}

	@Override
	public int updateOutD(Attendance attendance) {
		return attendanceDao.updateOutD(attendance);
	}

	@Override
	public ArrayList<Attendance> selectMyAttendance(Paging paging) {
		return attendanceDao.selectMyAttendance(paging);
	}

	@Override
	public int selectListCount(Member loginUser) {
		return attendanceDao.selectListCount(loginUser);
	}
}

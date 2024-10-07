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
	public Attendance selectTodayAttendance(Member loginUser) {
		return attendanceDao.selectTodayAttendance(loginUser);
	}

	@Override
	public int insertAttendance(Member loginUser) {
		return attendanceDao.insertAttendance(loginUser);
	}

	@Override
	public int updateGoD(Member loginUser) {
		return attendanceDao.updateGoD(loginUser);
	}

	@Override
	public int updateOutD(Member loginUser) {
		return attendanceDao.updateOutD(loginUser);
	}

	@Override
	public ArrayList<Attendance> selectMyAttendance(Paging paging) {
		return attendanceDao.selectMyAttendance(paging);
	}

	@Override
	public int selectListCount() {
		return attendanceDao.selectListCount();
	}
}

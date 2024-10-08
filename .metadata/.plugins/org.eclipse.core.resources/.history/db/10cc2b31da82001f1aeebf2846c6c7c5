package org.riss.bizconnect.hr.attendance.model.service;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.hr.attendance.model.dao.AttendanceDao;
import org.riss.bizconnect.hr.attendance.model.dto.GooutTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private AttendanceDao attendanceDao;

	@Override
	public GooutTime selectTodayGOTime(Member loginUser) {
		return attendanceDao.selectTodayGOTime(loginUser);
	}

	@Override
	public int insertGOTime(Member loginUser) {
		return attendanceDao.insertGOTime(loginUser);
	}

	@Override
	public int updateGoD(Member loginUser) {
		return attendanceDao.updateGoD(loginUser);
	}

	@Override
	public int updateOutD(Member loginUser) {
		return attendanceDao.updateOutD(loginUser);
	}
}

package org.riss.bizconnect.hr.attendance.model.service;

import org.riss.bizconnect.hr.attendance.model.dao.AttendanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private AttendanceDao attendanceDao;
	
	@Override
	public int goCheck() {
		return attendanceDao.goCheck();
	}

}

package org.riss.bizconnect.hr.attendance.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.attendance.model.dto.Attendance;

public interface AttendanceService {

	Attendance selectTodayAttendance(Member loginUser);

	int insertAttendance(Member loginUser);

	int updateGoD(Member loginUser);
	int updateOutD(Member loginUser);

	ArrayList<Attendance> selectMyAttendance(Paging paging);

	int selectListCount();



}

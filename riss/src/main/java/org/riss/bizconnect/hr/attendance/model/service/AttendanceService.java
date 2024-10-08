package org.riss.bizconnect.hr.attendance.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.attendance.model.dto.Attendance;

public interface AttendanceService {

	Attendance selectTodayAttendance(Member member);

	int insertAttendance(Member member);

	int updateGoD(Attendance attendance);
	int updateOutD(Attendance attendance);

	ArrayList<Attendance> selectMyAttendance(Paging paging);

	int selectListCount(Member loginUser);



}

package org.riss.bizconnect.hr.attendance.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.hr.attendance.model.dto.Attendance;

public interface AttendanceService {

	Attendance selectTodayAttendance(Member member);

	int insertAttendance(Member member);

	int updateGoD(Attendance attendance);
	
	int updateOutD(Attendance attendance);

	ArrayList<Attendance> selectMyAttendance(Paging paging);

	int selectListCount(Member loginUser);

	int selectComListCount(Member loginUser);

	ArrayList<Attendance> selectComAttendance(Paging paging);

	int selectComFileterMListCount(Member loginUser);

	ArrayList<Attendance> selectComFileterMAttendance(Paging paging);

	ArrayList<String> selectComMListCount(String comCode);

	int selectComDateMListCount(Search search);

	ArrayList<Attendance> selectComDateAttendance(Search search);

	ArrayList<Attendance> selectComList(Member member);

	int updateAttendnce(Attendance attendance);

}

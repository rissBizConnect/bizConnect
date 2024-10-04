package org.riss.bizconnect.hr.attendance.model.service;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.hr.model.dto.GooutTime;

public interface AttendanceService {

	GooutTime selectTodayGOTime(Member loginUser);

	int insertGOTime(Member loginUser);

	int updateGoD(Member loginUser);
	int updateOutD(Member loginUser);



}

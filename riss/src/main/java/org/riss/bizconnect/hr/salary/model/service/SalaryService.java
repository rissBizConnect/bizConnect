package org.riss.bizconnect.hr.salary.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.hr.salary.model.dto.Salary;

public interface SalaryService {

	int selectAllCount(String comCode);

	ArrayList<Salary> selectAll(Paging paging);

	int selectKeywordCount(Search search);

	ArrayList<Salary> selectKeyword(Search search);

	Salary selectMember(Salary salary);

	int deleteMember(Salary salary);

	int insertSalary(Salary salary);

	int updateSalary(Salary salary);

}

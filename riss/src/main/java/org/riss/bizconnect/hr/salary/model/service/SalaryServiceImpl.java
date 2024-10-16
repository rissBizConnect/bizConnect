package org.riss.bizconnect.hr.salary.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.hr.salary.model.dao.SalaryDao;
import org.riss.bizconnect.hr.salary.model.dto.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {
	@Autowired
	private SalaryDao salaryDao;

	@Override
	public int selectAllCount(String comCode) {
		return salaryDao.selectAllCount(comCode);
	}

	@Override
	public ArrayList<Salary> selectAll(Paging paging) {
		return salaryDao.selectAll(paging);
	}

	@Override
	public int selectKeywordCount(Search search) {
		return salaryDao.selectKeywordCount(search);
	}

	@Override
	public ArrayList<Salary> selectKeyword(Search search) {
		return salaryDao.selectKeyword(search);
	}

	@Override
	public Salary selectMember(Salary salary) {
		return salaryDao.selectMember(salary);
	}

	@Override
	public int deleteMember(Salary salary) {
		return salaryDao.deleteMember(salary);
	}
}

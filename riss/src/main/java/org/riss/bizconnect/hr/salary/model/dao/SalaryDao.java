package org.riss.bizconnect.hr.salary.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.hr.salary.model.dto.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("salaryDao")
public class SalaryDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public ArrayList<Salary> selectAll(Salary salary) {
		List<Salary> list = sqlSessionTemplate.selectList("salaryMapper.selectAll", salary);
		return (ArrayList<Salary>)list;
	}

	public int selectAllCount(String comCode) {
		return sqlSessionTemplate.selectOne("salaryMapper.selectAllCount", comCode);
	}

	public ArrayList<Salary> selectAll(Paging paging) {
		List<Salary> list = sqlSessionTemplate.selectList("salaryMapper.selectAll", paging);
		return (ArrayList<Salary>)list;
	}

	public int selectKeywordCount(Search search) {
		return sqlSessionTemplate.selectOne("salaryMapper.selectKeywordCount", search);
	}

	public ArrayList<Salary> selectKeyword(Search search) {
		List<Salary> list = sqlSessionTemplate.selectList("salaryMapper.selectKeyword", search);
		return (ArrayList<Salary>)list;
	}

	public Salary selectMember(Salary salary) {
		return sqlSessionTemplate.selectOne("salaryMapper.selectMember", salary);
	}

	public int deleteMember(Salary salary) {
		return sqlSessionTemplate.delete("salaryMapper.deleteMember", salary);
	}

	public int insertSalary(Salary salary) {
		return sqlSessionTemplate.insert("salaryMapper.insertSalary", salary);
	}

	public int updateSalary(Salary salary) {
		return sqlSessionTemplate.update("salaryMapper.updateSalary", salary);
	}

}

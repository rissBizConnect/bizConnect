package org.riss.bizconnect.hr.retire.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.attendance.model.dto.Attendance;
import org.riss.bizconnect.hr.retire.model.controller.RetireController;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("RetireDAO")
public class RetireDAO {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RetireController.class);
    
    
    public Retire selectRetireById(String retNo) {
        return sqlSessionTemplate.selectOne("retireMapper.selectRetireById", retNo);
    }

    public int insertRetire(Retire retire) {
        return sqlSessionTemplate.insert("retireMapper.insertRetire", retire);
    }

    public int updateRetire(Retire retire) {
        return sqlSessionTemplate.update("retireMapper.updateRetire", retire);
    }

    public int deleteRetire(String retNo) {
        return sqlSessionTemplate.delete("retireMapper.deleteRetire", retNo);
    }

	public ArrayList<Retire> selectRetireList(Paging paging) {
		List<Retire> list = sqlSessionTemplate.selectList("retireMapper.selectRetireList",paging);
		return (ArrayList<Retire>)list;
	}

	public int selectListCount(Member member) {
		return sqlSessionTemplate.selectOne("retireMapper.selectListCount", member);
	}

	public int getRetireListCount() {
		return sqlSessionTemplate.selectOne("retireMapper.getRetireListCount");
	}

	public List<Retire> getRetireList(Paging paging) {
		List<Retire> list = sqlSessionTemplate.selectList("retireMapper.getRetireList",paging);
		return (ArrayList<Retire>)list;
	}

	public int addRetire(Retire retire) {
		return sqlSessionTemplate.insert("retireMapper.addRetire", retire);
	}

	public ArrayList<Retire> selectAllRetirees(String comCode) {
		List<Retire> list = sqlSessionTemplate.selectList("retireMapper.selectAllRetirees", comCode);
		return (ArrayList<Retire>)list;
	}
}



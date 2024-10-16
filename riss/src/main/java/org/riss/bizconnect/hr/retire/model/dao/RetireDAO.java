package org.riss.bizconnect.hr.retire.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("retireDAO")
public class RetireDAO {
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	// 퇴직자 목록 조회
    public List<Retire> selectRetireList(Map<String, Object> params) {
        return sqlSessionTemplate.selectList("retireMapper.selectRetireList", params);
    }

    // 퇴직자 수 계산
    public int selectRetireCount(Map<String, Object> params) {
        return sqlSessionTemplate.selectOne("retireMapper.selectRetireCount", params);
    }

    // 퇴직자 정보 추가
    public void insertRetire(Retire retire) {
    	sqlSessionTemplate.insert("retireMapper.insertRetire", retire);
    }

    // 퇴직자 정보 조회
    public Retire selectRetireByRetNo(String retNo) {
        return sqlSessionTemplate.selectOne("retireMapper.selectRetireByRetNo", retNo);
    }

    // 퇴직자 정보 수정
    public void updateRetire(Retire retire) {
    	sqlSessionTemplate.update("retireMapper.updateRetire", retire);
    }

    // 퇴직자 정보 삭제
    public void deleteRetire(String retNo) {
    	sqlSessionTemplate.delete("retireMapper.deleteRetire", retNo);
    }

	public int selectRetireCount(Retire retire) {
		return sqlSessionTemplate.selectOne("retireMapper.selectRetireCount", retire);
	}

	public ArrayList<Retire> selectRetireList(Paging paging) {
		List<Retire> list = sqlSessionTemplate.selectList("retireMapper.selectRetireList", paging);
		return (ArrayList<Retire>)list;
	}
	
	//퇴직자 사원 변환
	public int updateRetireToMember(Retire retire) {
		return sqlSessionTemplate.update("retireMapper.updateRetireToMember", retire);
		
	}
  
   
}

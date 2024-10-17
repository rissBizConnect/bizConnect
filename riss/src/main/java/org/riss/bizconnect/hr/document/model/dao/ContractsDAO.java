package org.riss.bizconnect.hr.document.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.attendance.model.dto.Attendance;
import org.riss.bizconnect.hr.document.model.dto.Contracts;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("contractsDAO")
public class ContractsDAO {

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	// 증명서 목록 조회
    public List<Contracts> selectContractss() {
        return sqlSessionTemplate.selectList("contractssMapper.selectContractss");
    }

    // 증명서 상세 조회
    public Contracts selectContractsById(String contractsId) {
        return sqlSessionTemplate.selectOne("contractssMapper.selectContractsById", contractsId);
    }

    // 증명서 추가
    public int insertContracts(Contracts contracts) {
        return sqlSessionTemplate.insert("contractssMapper.insertContracts", contracts);
    }

    // 증명서 수정
    public int updateContracts(Contracts contracts) {
        return sqlSessionTemplate.update("contractssMapper.updateContracts", contracts);
    }
    
    // 증명서 삭제
	public int deleteContracts(String contractsId) {
		return sqlSessionTemplate.delete("ContractssMapper.deleteContracts", contractsId);
	}

    
	


}
	

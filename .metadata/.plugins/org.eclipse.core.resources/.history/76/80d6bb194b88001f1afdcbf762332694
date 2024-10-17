package org.riss.bizconnect.hr.retire.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("retireDAO")
public class RetireDAO {
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    public List<Retire> getAllRetires() {
        return sqlSessionTemplate.selectList("RetireMapper.getAllRetires");
    }

    public void addRetire(Retire retire) {
    	sqlSessionTemplate.insert("RetireMapper.addRetire", retire);
    }

    public void updateRetire(Retire retire) {
    	sqlSessionTemplate.update("RetireMapper.updateRetire", retire);
    }

    public void deleteRetire(String retNo) {
    	sqlSessionTemplate.delete("RetireMapper.deleteRetire", retNo);
    }

    public Retire getRetireById(String retNo) {
        return sqlSessionTemplate.selectOne("RetireMapper.getRetireById", retNo);
    }
    
    //회원 --> 퇴직자 변경
    public int updateToRetire(String gid) {
        return sqlSessionTemplate.update("RetireMapper.convertToRetire", gid);
    }

    public int updateToWorker(String retNo) {
        return sqlSessionTemplate.update("RetireMapper.convertToWorker", retNo);
    }

    public List<Retire> selectRetireList() {
        return sqlSessionTemplate.selectList("RetireMapper.selectRetireList");
    }
}

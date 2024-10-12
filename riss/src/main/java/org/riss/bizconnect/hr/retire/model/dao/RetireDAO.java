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
	
	public List<Retire> selectRetireList() {
	        return sqlSessionTemplate.selectList("retireMapper.selectRetireList");
	    }

	public List<Retire> selectAllRetirees() {
		return sqlSessionTemplate.selectList("retireMapper.selectAllRetirees");
	}

	public List<Retire> selectRetireList(String comCode) {
        return sqlSessionTemplate.selectList("retireMapper.selectRetireList", comCode); // Mapper에서 정의한 SQL 쿼리 실행
    }
	
    public void addRetire(Retire retire) {
    	sqlSessionTemplate.insert("retireMapper.addRetire", retire);
    }

    public void updateRetire(Retire retire) {
    	sqlSessionTemplate.update("retireMapper.updateRetire", retire);
    }

    public void deleteRetire(String retNo) {
    	sqlSessionTemplate.delete("retireMapper.deleteRetire", retNo);
    }

    public Retire getRetireById(String retNo) {
        return sqlSessionTemplate.selectOne("retireMapper.getRetireById", retNo);
    }
    
    public int updateToRetire(String gid) {
        return sqlSessionTemplate.update("retireMapper.convertToRetire", gid);
    }

    public int updateToWorker(String retNo) {
        return sqlSessionTemplate.update("retireMapper.convertToWorker", retNo);
    }

	

   
}

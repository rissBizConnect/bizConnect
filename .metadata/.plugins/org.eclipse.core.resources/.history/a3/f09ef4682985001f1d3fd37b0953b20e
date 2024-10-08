package org.riss.bizconnect.hr.retire.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RetireDAO {

    private final SqlSession sqlSession;

    @Autowired
    public RetireDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSession = sqlSessionFactory.openSession();
    }

    public List<Retire> getAllRetires() {
        return sqlSession.selectList("RetireMapper.getAllRetires");
    }

    public void addRetire(Retire retire) {
        sqlSession.insert("RetireMapper.addRetire", retire);
    }

    public void updateRetire(Retire retire) {
        sqlSession.update("RetireMapper.updateRetire", retire);
    }

    public void deleteRetire(String retNo) {
        sqlSession.delete("RetireMapper.deleteRetire", retNo);
    }

    public Retire getRetireById(String retNo) {
        return sqlSession.selectOne("RetireMapper.getRetireById", retNo);
    }
}

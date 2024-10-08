package org.riss.bizconnect.main.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.main.member.model.dto.Member;
import org.riss.bizconnect.main.member.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public Member selectMember(String userId) {
        return sqlSessionTemplate.selectOne("memberMapper.selectMember", userId);
    }

    public User selectLogin(User user) {
        return sqlSessionTemplate.selectOne("memberMapper.selectLogin", user);
    }
}


/*
 * package org.riss.bizconnect.main.member.model.dao;
 * 
 * import org.mybatis.spring.SqlSessionTemplate; import
 * org.riss.bizconnect.main.member.model.dto.User; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository;
 * 
 * @Repository("memberDAO") public class MemberDAO {
 * 
 * @Autowired private SqlSessionTemplate sqlSessionTemplate;
 * 
 * public User selectLogin(User user) { return
 * sqlSessionTemplate.selectOne("memberMapper.selectLogin", user); } }
 */
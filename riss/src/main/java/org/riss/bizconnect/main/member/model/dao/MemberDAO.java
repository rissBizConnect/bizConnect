package org.riss.bizconnect.main.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public Member selectMember(String userId) {
        return sqlSessionTemplate.selectOne("memberMapper.selectMember", userId);
    }

    public Member selectLogin(Member user) {
        return sqlSessionTemplate.selectOne("memberMapper.selectLogin", user);
    }

    // GID가 null이 아닌지 확인하고 업데이트 실행
    public int updateProfile(Member user) {
        if (user.getgId() != null) {
            return sqlSessionTemplate.update("memberMapper.updateProfile", user); // 업데이트 실행
        } else {
            // GID 값이 없으면 로그 출력
            System.out.println("GID 값이 없습니다. 업데이트할 수 없습니다.");
            throw new IllegalArgumentException("유효한 GID가 필요합니다."); // 예외 던지기
        }
    }
    // 모든 사용자를 조회하는 DAO 메소드
    public List<Member> findAllUsers() {
        return sqlSessionTemplate.selectList("memberMapper.findAllUsers");
    }

    // 사용자 ID로 특정 사용자를 조회하는 DAO 메소드
    public Member findUserById(String userId) {
        return sqlSessionTemplate.selectOne("memberMapper.findUserById", userId);
    }

    // 사용자 정보를 업데이트하는 DAO 메소드
    public void updateUser(Member user) {
        sqlSessionTemplate.update("memberMapper.updateUser", user);
    }
}


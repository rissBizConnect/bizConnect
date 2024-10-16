package org.riss.bizconnect.main.member.model.service;

import org.riss.bizconnect.main.member.model.dao.MemberDAO;
import org.riss.bizconnect.common.model.dto.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public Member selectMember(String gId) {
        return memberDAO.selectMember(gId);
    }

    @Override
    public Member selectLogin(Member user) {
        return memberDAO.selectLogin(user); // memberDAO에서 로그인 사용자 조회
    }

    @Override
    public boolean validateLogin(String gId, String userPW, String comCode) {
    	Member user = new Member(gId, userPW, comCode);
    	Member foundUser = memberDAO.selectLogin(user);

        // 비밀번호를 암호화하지 않고 원본 그대로 비교
        return foundUser != null && userPW.equals(foundUser.getUserPW());
    }

    @Override
    public void updateProfile(Member user) {
        memberDAO.updateProfile(user); // User 업데이트 메소드 호출
    }

    // 모든 사용자 목록을 조회하는 메소드
    @Override
    public List<Member> getAllUsers() {
        return memberDAO.findAllUsers(); // DAO에서 모든 사용자 조회
    }

    // 사용자 ID로 특정 사용자를 조회하는 메소드
    @Override
    public Member getUserById(String userId) {
        return memberDAO.findUserById(userId); // DAO에서 특정 사용자 조회
    }

    // 사용자 정보를 업데이트하는 메소드
    @Override
    public void updateUserDetails(Member user) {
        memberDAO.updateUser(user); // DAO에서 사용자 정보 업데이트
    }
}

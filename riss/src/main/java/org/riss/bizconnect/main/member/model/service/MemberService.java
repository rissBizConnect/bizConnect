package org.riss.bizconnect.main.member.model.service;

import org.riss.bizconnect.common.model.dto.Member;


import java.util.List;

public interface MemberService {
    Member selectMember(String userId); // 회원 정보 조회
    boolean validateLogin(String userId, String userPw, String comCode); // 로그인 검증
    Member selectLogin(Member user); // 로그인 사용자 조회
    void updateProfile(Member user); // 프로필 업데이트 메소드 추가
    
    // 추가 메소드
    List<Member> getAllUsers(); // 모든 사용자 조회
    Member getUserById(String userId); // 특정 사용자 조회
    void updateUserDetails(Member user); // 사용자 정보 업데이트
    
    
}

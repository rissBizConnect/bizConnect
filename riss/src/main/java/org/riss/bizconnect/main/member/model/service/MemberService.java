package org.riss.bizconnect.main.member.model.service;

import org.riss.bizconnect.main.member.model.dto.Member;
import org.riss.bizconnect.main.member.model.dto.User;

import java.util.List;

public interface MemberService {
    Member selectMember(String userId); // 회원 정보 조회
    boolean validateLogin(String userId, String userPw, String comCode); // 로그인 검증
    User selectLogin(User user); // 로그인 사용자 조회
    void updateProfile(User user); // 프로필 업데이트 메소드 추가
    
    // 추가 메소드
    List<User> getAllUsers(); // 모든 사용자 조회
    User getUserById(String userId); // 특정 사용자 조회
    void updateUserDetails(User user); // 사용자 정보 업데이트
    
    
}

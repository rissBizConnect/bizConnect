package org.riss.bizconnect.main.member.model.service;

import org.riss.bizconnect.main.member.model.dto.Member;
import org.riss.bizconnect.main.member.model.dto.User;

public interface MemberService {
    Member selectMember(String userId); // 회원 정보 조회
    boolean validateLogin(String userId, String userPw, String comCode); // 로그인 검증
    User selectLogin(User user); // 로그인 사용자 조회
}

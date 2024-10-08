package org.riss.bizconnect.main.member.model.service;

import org.riss.bizconnect.main.member.model.dto.User;

public interface MemberService {
    User selectLogin(User user);
    boolean validateLogin(String userId, String userPwd, String comCode); // Login validation method
}


/*
 * package org.riss.bizconnect.main.member.model.service;
 * 
 * import org.riss.bizconnect.main.member.model.dto.User;
 * 
 * public interface MemberService { User selectLogin(User user); boolean
 * validateLogin(String userId, String userPwd, String comCode); // 로그인 검증 메소드 }
 */
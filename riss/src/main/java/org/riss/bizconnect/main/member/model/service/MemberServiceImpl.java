package org.riss.bizconnect.main.member.model.service;

import org.riss.bizconnect.main.member.model.dao.MemberDAO;
import org.riss.bizconnect.main.member.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public User selectLogin(User user) {
        return memberDAO.selectLogin(user);
    }

    @Override
    public boolean validateLogin(String userId, String userPwd, String comCode) {
        User user = new User(userId, userPwd, comCode);
        User foundUser = memberDAO.selectLogin(user);
        return foundUser != null; // Return true if user exists
    }
}


/*
 * package org.riss.bizconnect.main.member.model.service;
 * 
 * import org.riss.bizconnect.main.member.model.dao.MemberDAO; import
 * org.riss.bizconnect.main.member.model.dto.User; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * @Service("memberService") // "memberService" 빈으로 등록 public class
 * MemberServiceImpl implements MemberService {
 * 
 * @Autowired private MemberDAO memberDAO;
 * 
 * @Override public User selectLogin(User user) { return
 * memberDAO.selectLogin(user); }
 * 
 * @Override public boolean validateLogin(String userId, String userPwd, String
 * comCode) { User user = new User(userId, userPwd, comCode); User foundUser =
 * memberDAO.selectLogin(user); return foundUser != null; } }
 */
package org.riss.bizconnect.main.member.model.service;

import org.riss.bizconnect.main.member.model.dao.MemberDAO;
import org.riss.bizconnect.main.member.model.dto.Member;
import org.riss.bizconnect.main.member.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public Member selectMember(String userId) {
        return memberDAO.selectMember(userId); // memberDAO에서 회원 정보 조회
    }

    @Override
    public User selectLogin(User user) {
        return memberDAO.selectLogin(user); // memberDAO에서 로그인 사용자 조회
    }

    @Override
    public boolean validateLogin(String userId, String userPw, String comCode) {
        User user = new User(userId, userPw, comCode);
        User foundUser = memberDAO.selectLogin(user);

        // 비밀번호를 암호화하지 않고 원본 그대로 비교
        return foundUser != null && userPw.equals(foundUser.getUserPw());
    }
}



/*
@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public Member selectMember(String userId) {
        return memberDAO.selectMember(userId);
    }

    @Override
    public User selectLogin(User user) {
        return memberDAO.selectLogin(user); // memberDAO에서 selectLogin 호출
    }
}
*/


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
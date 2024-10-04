package org.riss.bizconnect.main.member.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.main.member.model.dto.Member;
import org.riss.bizconnect.main.member.model.dto.User;

public interface MemberService {
	User selectLogin(User user);
	Member selectMember(String userId);
	int selectCheckId(String userid);
	
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(String userId);
	ArrayList<Member> selectList();
}

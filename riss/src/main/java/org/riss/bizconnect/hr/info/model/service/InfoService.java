package org.riss.bizconnect.hr.info.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;

public interface InfoService {

	int insertMember(Member member);

	int selectAllMemeberCount(String myCom);

	ArrayList<Member> selectAllMemeber(Paging paging);

	Member selectMember(Member mem);

	int deleteMember(Member mem);

	int updateMember(Member mem);

	int memberRetireChage(Member mem);

	int selectKeywordCount(Search search);

	ArrayList<Member> selectKeyword(Search search);

}

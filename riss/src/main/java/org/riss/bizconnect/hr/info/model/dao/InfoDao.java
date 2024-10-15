package org.riss.bizconnect.hr.info.model.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("infoDao")

public class InfoDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int insertMember(Member member) {
		return sqlSessionTemplate.insert("infoMapper.insertMember", member);
	}

	public int selectAllMemeberCount(String myCom) {
		return sqlSessionTemplate.selectOne("infoMapper.selectAllMemeberCount", myCom);
	}

	public ArrayList<Member> selectAllMemeber(Paging paging) {
		List<Member> list = sqlSessionTemplate.selectList("infoMapper.selectAllMemeber", paging);
		return (ArrayList<Member>)list;
	}

	public Member selectMember(Member mem) {
		return sqlSessionTemplate.selectOne("infoMapper.selectMember", mem);
	}

	public int deleteMember(Member mem) {
		return sqlSessionTemplate.delete("infoMapper.deleteMember", mem);
	}

	public int updateMember(Member mem) {
		return sqlSessionTemplate.update("infoMapper.updateMember", mem);
	}

	public int memberRetireChage(Member mem) {
		return sqlSessionTemplate.update("infoMapper.memberRetireChage", mem);
	}

	public int selectKeywordCount(Search search) {
		return sqlSessionTemplate.selectOne("infoMapper.selectKeywordCount", search);
	}

	public ArrayList<Member> selectKeyword(Search search) {
		List<Member> list = sqlSessionTemplate.selectList("infoMapper.selectKeyword", search);
		return (ArrayList<Member>)list;
	}
	
	//사원 퇴직자 변환
    public Member selectMemberByGidAndComCode(Member member) {
        return sqlSessionTemplate.selectOne("MemberMapper.selectMemberByGidAndComCode", member);
    }

    public int insertMemberChange(Member member) {
        return sqlSessionTemplate.insert("MemberMapper.insertMember", member);
    }

    public int updateMemberChange(Member member) {
        return sqlSessionTemplate.update("MemberMapper.updateMember", member);
    }
    public int convertMemberToRetire(Member member) {
		return sqlSessionTemplate.update("RetireMapper.updateMemberToRetire", member);
	}

    public int deleteMemberChange(Member member) {
        return sqlSessionTemplate.delete("MemberMapper.deleteMember", member);
    }
	
}
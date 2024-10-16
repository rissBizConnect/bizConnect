package org.riss.bizconnect.hr.info.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Member;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.hr.info.model.dao.InfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("infoService")
public class InfoServiceImpl implements InfoService {
	@Autowired
	private InfoDao infoDao;

	@Override
	public int insertMember(Member member) {
		return infoDao.insertMember(member);
	}

	@Override
	public int selectAllMemeberCount(String myCom) {
		return infoDao.selectAllMemeberCount(myCom);
	}

	@Override
	public ArrayList<Member> selectAllMemeber(Paging paging) {
		return infoDao.selectAllMemeber(paging);
	}

	@Override
	public Member selectMember(Member mem) {
		return infoDao.selectMember(mem);	}

	@Override
	public int deleteMember(Member mem) {
		return infoDao.deleteMember(mem);
	}

	@Override
	public int updateMember(Member mem) {
		return infoDao.updateMember(mem);
	}

	@Override
	public int memberRetireChage(Member mem) {
		return infoDao.memberRetireChage(mem);
	}

	@Override
	public int selectKeywordCount(Search search) {
		return infoDao.selectKeywordCount(search);
	}

	@Override
	public ArrayList<Member> selectKeyword(Search search) {
		return infoDao.selectKeyword(search);
	}


}

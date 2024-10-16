package org.riss.bizconnect.support.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.support.model.dao.SupportDao;
import org.riss.bizconnect.support.model.dto.Support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("supportService")
public class SupportServiceImpl implements SupportService {
	@Autowired
	private SupportDao supportDao;

	@Override
	public int insertSupport(Support support) {
		
		return supportDao.insertSupport(support);
	}

	@Override
	public int deleteSupport(int supportNo) {
		
		return supportDao.deleteSupport(supportNo);
	}

	@Override
	public Support selectSupport(int supportNo) {
		
		return supportDao.selectSupport(supportNo);
	}

	@Override
	public int selectListCount() {

		return supportDao.selectListCount();
	}

	@Override
	public ArrayList<Support> selectList(Paging paging) {

		return supportDao.selectList(paging);
	}

	@Override
	public int updateAddReadCount(int supportNo) {

		return supportDao.updateAddReadCount(supportNo);
	}

	@Override
	public int updateSupport(Support support) {
		
		return supportDao.updateSupport(support);
	}
	// 검색용 메소드 -------------------------
	@Override
	public ArrayList<Support> selectSearchTitle(Search search) {
		return supportDao.selectSearchTitle(search);
	}

	@Override
	public int selectSearchTitleCount(String keyword) {
		return supportDao.selectSearchTitleCount(keyword);
	}

	@Override
	public ArrayList<Support> selectSearchContent(Search search) {
		return supportDao.selectSearchContent(search);
	}

	@Override
	public int selectSearchContentCount(String keyword) {
		return supportDao.selectSearchContentCount(keyword);
	}

	@Override
	public ArrayList<Support> selectSearchDate(Search search) {
		return supportDao.selectSearchDate(search);
	}

	@Override
	public int selectSearchDateCount(Search search) {
		return supportDao.selectSearchDateCount(search);
	}

	
	
}
package org.riss.bizconnect.support.service;

import java.util.ArrayList;

import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.support.model.dto.Support;

public interface SupportService {



	int insertSupport(Support support);

	int deleteSupport(int supportNo);

	Support selectSupport(int supportNo);

	int selectListCount();

	ArrayList<Support> selectList(Paging paging);

	int updateAddReadCount(int supportNo);

	int updateSupport(Support support);

	ArrayList<Support> selectSearchTitle(Search search);
	int selectSearchTitleCount(String keyword);
	ArrayList<Support> selectSearchContent(Search search);
	int selectSearchContentCount(String keyword);
	ArrayList<Support> selectSearchDate(Search search);
	int selectSearchDateCount(Search search);



	
	

	
	

	
}
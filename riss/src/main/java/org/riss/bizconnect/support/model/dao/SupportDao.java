package org.riss.bizconnect.support.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.support.model.dto.Support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("supportDao")
public class SupportDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public Support selectSupport(int supportNo) {
        return sqlSessionTemplate.selectOne("supportMapper.selectSupport", supportNo);
    }

    public int insertSupport(Support support) {
        return sqlSessionTemplate.insert("supportMapper.insertSupport", support);
    }

    
    
    // 삭제
    public int deleteSupport(int supportNo) {
        return sqlSessionTemplate.delete("supportMapper.deleteSupport", supportNo);
    }


	public int selectListCount() {
		return sqlSessionTemplate.selectOne("supportMapper.selectListCount");
	}


	public ArrayList<Support> selectList(Paging paging) {
		List<Support> list = sqlSessionTemplate.selectList("supportMapper.selectList", paging);
        return (ArrayList<Support>)list;
	}

	public int updateAddReadCount(int supportNo) {
		return sqlSessionTemplate.update("supportMapper.updateAddReadCount", supportNo);
	}

	public int updateSupport(Support support) {
			return sqlSessionTemplate.update("supportMapper.updateSupport", support);
	}
	
	// 검색 관련 메소드 ----------------------
	public ArrayList<Support> selectSearchTitle(Search search) {
		List<Support> list = sqlSessionTemplate.selectList("supportMapper.selectSearchTitle", search);
		return (ArrayList<Support>)list;
	}

	public int selectSearchTitleCount(String keyword) {
		return sqlSessionTemplate.selectOne("supportMapper.selectSearchTitleCount", keyword);
	}

	public ArrayList<Support> selectSearchContent(Search search) {
		List<Support> list = sqlSessionTemplate.selectList("supportMapper.selectSearchContent", search);
		return (ArrayList<Support>)list;
	}

	public int selectSearchContentCount(String keyword) {
		return sqlSessionTemplate.selectOne("supportMapper.selectSearchContentCount", keyword);
	}

	public ArrayList<Support> selectSearchDate(Search search) {
		List<Support> list = sqlSessionTemplate.selectList("supportMapper.selectSearchDate", search);
		return (ArrayList<Support>)list;
	}

	public int selectSearchDateCount(Search search) {
		return sqlSessionTemplate.selectOne("supportMapper.selectSearchDateCount", search);
	}
	
	
	


}
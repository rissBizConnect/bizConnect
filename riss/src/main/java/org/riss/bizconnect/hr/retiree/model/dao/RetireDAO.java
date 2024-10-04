package org.riss.bizconnect.hr.retiree.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.riss.bizconnect.hr.retiree.model.dto.RetireDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class retireDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 

	public int deleteRetiree(String retireId) {
		return sqlSessionTemplate.selectOne("boardMapper.deleteRetiree", retireId);
	}

	public int updateRetiree(RetireDTO retiree) {
		return sqlSessionTemplate.selectOne("boardMapper.updateRetiree", retiree);
	}

	public ArrayList<RetireDTO> selectAllRetirees(Paging paging) {
		List<RetireDTO> list = sqlSessionTemplate.selectList("boardMapper.selectAllRetirees", paging);
		return (ArrayList<RetireDTO>)list;
	}

	public int insertRetiree(RetireDTO retiree) {
		return sqlSessionTemplate.selectOne("boardMapper.insertRetiree", retiree);
	}

	public int selectRetireeCount() {
		return sqlSessionTemplate.selectOne("boardMapper.selectRetireeCount");
	}

	public ArrayList<RetireDTO> searchRetireesByName(Search search) {
		List<RetireDTO> list = sqlSessionTemplate.selectList("boardMapper.searchRetireesByName", search);
		return (ArrayList<RetireDTO>)list;
	}

	public int searchRetireesByNameCount(String keyword) {
		return sqlSessionTemplate.selectOne("boardMapper.searchRetireesByNameCount", keyword);
	}

	public ArrayList<RetireDTO> searchRetireesByDate(Search search) {
		List<RetireDTO> list = sqlSessionTemplate.selectList("boardMapper.searchRetireesByDate", search);
		return (ArrayList<RetireDTO>)list;
	}

	public int searchRetireesByDateCount(Search search) {
		return sqlSessionTemplate.selectOne("boardMapper.searchRetireesByDateCount", search);
	}

	public RetireDTO selectRetiree(String retireId) {
		return sqlSessionTemplate.selectOne("boardMapper.selectRetiree", retireId);
	}

}

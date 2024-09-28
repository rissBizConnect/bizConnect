package org.myweb.first.notice.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.Not;
import org.mybatis.spring.SqlSessionTemplate;
import org.myweb.first.notice.model.dto.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("noticeDao")
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTmplate;
	
	//ajax 테스트용 : 마지막 등록된 최근 공지글 한 개 조회용 메소드
	public Notice selectLast() {
		return sqlSessionTmplate.selectOne("noticeMapper.selectLast");
	}
	
	//ajax : 최근 등록 공지글 3개 조회용
	public ArrayList<Notice> selectTop3(){
		List<Notice> list = sqlSessionTmplate.selectList("noticeMapper.selectTop3");
		return (ArrayList<Notice>)list;
	}
	
	//상세보기 처리를 위한 공지글 1개 조회용
	public Notice selectNotice(int noticeNO) {
		return sqlSessionTmplate.selectOne("noticeMapper.selectNotice", noticeNO);
	}
	//공지 제목 검색
	public ArrayList<Notice> selectSearchTitle(String keyword){
		List<Notice> list = sqlSessionTmplate.selectList("noticeMapper.selectSearchTitleKeyword", keyword);
		return (ArrayList<Notice>)list;
	}
	
	//새 공지글 등록
	public int insertNotice(Notice notice) {
		return sqlSessionTmplate.insert("noticeMapper.insertNotice", notice);
	}

	//조회수 1중거 초라
	public int updateAddReadCount(int noticeNo) {
		return sqlSessionTmplate.update("noticeMapper.updateAddReadCount", noticeNo);
	}

	public ArrayList<Notice> selectList() {
		List<Notice> list = sqlSessionTmplate.selectList("noticeMapper.selectList");
		return (ArrayList<Notice>)list;
	}
}

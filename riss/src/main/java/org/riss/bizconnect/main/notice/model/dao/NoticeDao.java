package org.riss.bizconnect.main.notice.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.main.notice.model.dto.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("noticeDao")
public class NoticeDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public ArrayList<Notice> selectList() {
        List<Notice> list = sqlSessionTemplate.selectList("noticeMapper.selectList");
        return (ArrayList<Notice>) list;
    }

    public Notice selectNotice(int noticeNo) {
        return sqlSessionTemplate.selectOne("noticeMapper.selectNotice", noticeNo);
    }

    public int insertNotice(Notice notice) {
        return sqlSessionTemplate.insert("noticeMapper.insertNotice", notice);
    }

    public int deleteNotice(int noticeNo) {
        return sqlSessionTemplate.delete("noticeMapper.deleteNotice", noticeNo);
    }
}

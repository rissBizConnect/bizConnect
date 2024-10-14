package org.riss.bizconnect.main.notice.model.service;

import java.util.ArrayList;
import org.riss.bizconnect.main.notice.model.dao.NoticeDao;
import org.riss.bizconnect.main.notice.model.dto.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public ArrayList<Notice> selectList() {
        return noticeDao.selectList();
    }

    @Override
    public Notice selectNotice(int noticeNo) {
        return noticeDao.selectNotice(noticeNo);
    }

    @Override
    public int insertNotice(Notice notice) {
        return noticeDao.insertNotice(notice);
    }

    @Override
    public int deleteNotice(int noticeNo) {
        return noticeDao.deleteNotice(noticeNo);
    }
}

package org.riss.bizconnect.main.notice.model.service;

import java.util.ArrayList;
import org.riss.bizconnect.main.notice.model.dto.Notice;

public interface NoticeService {
    ArrayList<Notice> selectList();
    Notice selectNotice(int noticeNo);
    int insertNotice(Notice notice);
    int deleteNotice(int noticeNo);
}

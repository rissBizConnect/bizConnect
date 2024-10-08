package org.riss.bizconnect.hr.retiree.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.hr.retiree.model.dto.RetireDTO;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;

public interface RetireService {
    RetireDTO selectRetiree(String retireId);
    ArrayList<RetireDTO> selectAllRetirees(Paging paging);
    int insertRetiree(RetireDTO retiree);
    int updateRetiree(RetireDTO retiree);
    int deleteRetiree(String retireId);
    int selectRetireeCount();
    ArrayList<RetireDTO> searchRetireesByName(Search search);
    int searchRetireesByNameCount(String keyword);
    ArrayList<RetireDTO> searchRetireesByDate(Search search);
    int searchRetireesByDateCount(Search search);
}

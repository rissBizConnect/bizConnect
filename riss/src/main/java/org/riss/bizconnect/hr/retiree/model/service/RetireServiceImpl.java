package org.riss.bizconnect.hr.retiree.model.service;

import java.util.ArrayList;

import org.riss.bizconnect.hr.retiree.model.dao.retireDao;
import org.riss.bizconnect.hr.retiree.model.dto.RetireDTO;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.common.model.dto.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("retireService")
public class RetireServiceImpl implements RetireService {

    @Autowired
    private retireDao retireDao;

    @Override
    public RetireDTO selectRetiree(String retireId) {
        return retireDao.selectRetiree(retireId);
    }

    @Override
    public ArrayList<RetireDTO> selectAllRetirees(Paging paging) {
        return retireDao.selectAllRetirees(paging);
    }

    @Override
    public int insertRetiree(RetireDTO retiree) {
        return retireDao.insertRetiree(retiree);
    }

    @Override
    public int updateRetiree(RetireDTO retiree) {
        return retireDao.updateRetiree(retiree);
    }

    @Override
    public int deleteRetiree(String retireId) {
        return retireDao.deleteRetiree(retireId);
    }

    @Override
    public int selectRetireeCount() {
        return retireDao.selectRetireeCount();
    }

    @Override
    public ArrayList<RetireDTO> searchRetireesByName(Search search) {
        return retireDao.searchRetireesByName(search);
    }

    @Override
    public int searchRetireesByNameCount(String keyword) {
        return retireDao.searchRetireesByNameCount(keyword);
    }

    @Override
    public ArrayList<RetireDTO> searchRetireesByDate(Search search) {
        return retireDao.searchRetireesByDate(search);
    }

    @Override
    public int searchRetireesByDateCount(Search search) {
        return retireDao.searchRetireesByDateCount(search);
    }
}

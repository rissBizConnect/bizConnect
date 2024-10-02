package org.riss.bizconnect.hr.retiree.model.service;

import org.riss.bizconnect.hr.retiree.model.dao.RetireDAO;
import org.riss.bizconnect.hr.retiree.model.dto.RetireDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetireServiceImpl implements RetireService {
    @Autowired
    private RetireDAO retireDAO; // DAO 의존성 주입

    @Override
    public RetireDTO findRetire(int retNo, String comCode) {
        return retireDAO.getRetireInfo(retNo, comCode); // DAO 메서드 호출
    }

    @Override
    public List<RetireDTO> findAllRetires() {
        return retireDAO.getAllRetires(); // DAO 메서드 호출
    }

    @Override
    public void registerRetire(RetireDTO retire) {
        retireDAO.addRetire(retire); // DAO 메서드 호출
    }

    @Override
    public void modifyRetire(RetireDTO retire) {
        retireDAO.updateRetire(retire); // DAO 메서드 호출
    }
}

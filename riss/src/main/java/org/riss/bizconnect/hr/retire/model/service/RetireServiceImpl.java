package org.riss.bizconnect.hr.retire.model.service;

import java.util.List;

import org.riss.bizconnect.hr.retire.model.dao.RetireDAO;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.stereotype.Service;

@Service("RetireService")
public class RetireServiceImpl implements RetireService {
    private RetireDAO retireDAO;

    @Override
    public List<Retire> getAllRetires() {
        return retireDAO.getAllRetires();
    }

    @Override
    public void addRetire(Retire retire) {
        retireDAO.addRetire(retire);
    }

    @Override
    public void updateRetire(Retire retire) {
        retireDAO.updateRetire(retire);
    }

    @Override
    public void deleteRetire(String retNo) {
        retireDAO.deleteRetire(retNo);
    }

    @Override
    public Retire getRetireById(String retNo) {
        return retireDAO.getRetireById(retNo);
    }
}

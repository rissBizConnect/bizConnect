package org.riss.bizconnect.hr.retire.model.service;

import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RetireService")
public interface RetireService {
    List<Retire> getAllRetires();
    void addRetire(Retire retire);
    void updateRetire(Retire retire);
    void deleteRetire(String retNo);
    Retire getRetireById(String retNo);
}

package org.riss.bizconnect.pd.ordreport.model.dao;

import org.riss.bizconnect.pd.ordreport.model.dto.OrdreportDTO;
import java.util.List;

public interface OrdreportDAO {
    void createOrdreport(OrdreportDTO ordreport);
    void deleteOrdreport(Long orderCd);
    void updateOrdreport(OrdreportDTO ordreport);
    OrdreportDTO findOrdreportById(Long orderCd);
    List<OrdreportDTO> findPaymentHistory(Long orderCd);
    boolean checkPaymentStatus(Long orderCd);
}
package org.riss.bizconnect.pd.ordreport.model.service;

import org.riss.bizconnect.pd.ordreport.model.dto.OrdreportDTO;
import java.util.List;

public interface OrdreportService {
	
	// ���� ���¿� crud �۾� ����
    void createOrdreport(OrdreportDTO ordreport);
    void deleteOrdreport(Long orderCd);
    void updateOrdreport(OrdreportDTO ordreport);
    OrdreportDTO findOrdreportById(Long orderCd);
    List<OrdreportDTO> findPaymentHistory(Long orderCd);
    boolean checkPaymentStatus(Long orderCd);
}
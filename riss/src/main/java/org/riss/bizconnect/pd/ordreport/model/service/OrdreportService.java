package org.riss.bizconnect.pd.ordreport.model.service;

import org.riss.bizconnect.pd.ordreport.model.dto.OrdreportDTO;
import java.util.List;

public interface OrdreportService {
	
	// 결제 상태와 crud 작업 정의
    void createOrdreport(OrdreportDTO ordreport);
    void deleteOrdreport(Long orderCd);
    void updateOrdreport(OrdreportDTO ordreport);
    OrdreportDTO findOrdreportById(Long orderCd);
    List<OrdreportDTO> findPaymentHistory(Long orderCd);
    boolean checkPaymentStatus(Long orderCd);
}
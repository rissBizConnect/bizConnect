package org.riss.bizconnect.pd.ordreport.model.service;

import org.riss.bizconnect.pd.ordreport.model.dao.OrdreportDAO;
import org.riss.bizconnect.pd.ordreport.model.dto.OrdreportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdreportServiceImpl implements OrdreportService {
	
	// 서비스 로직 구현, DAO와 통신하여 데이터베이스 작업 수행
    private final OrdreportDAO ordreportDAO;
    
    // OrdreportDAO를 주입받는 생성자
    @Autowired
    public OrdreportServiceImpl(OrdreportDAO ordreportDAO) {
        this.ordreportDAO = ordreportDAO;
    }
    
 // 거래명세서 생성
    @Override
    public void createOrdreport(OrdreportDTO ordreport) {
        ordreportDAO.createOrdreport(ordreport);
    }
    
    // 거래명세서 삭제
    @Override
    public void deleteOrdreport(Long orderCd) {
        ordreportDAO.deleteOrdreport(orderCd);
    }

    // 거래명세서 수정
    @Override
    public void updateOrdreport(OrdreportDTO ordreport) {
        ordreportDAO.updateOrdreport(ordreport);
    }

 // 거래명세서 ID로 조회
    @Override
    public OrdreportDTO findOrdreportById(Long orderCd) {
        return ordreportDAO.findOrdreportById(orderCd);
    }

 // 결제 이력 조회
    @Override
    public List<OrdreportDTO> findPaymentHistory(Long orderCd) {
        return ordreportDAO.findPaymentHistory(orderCd);
    }

    
 // 결제 상태 확인
    @Override
    public boolean checkPaymentStatus(Long orderCd) {
        return ordreportDAO.checkPaymentStatus(orderCd);
    }
}
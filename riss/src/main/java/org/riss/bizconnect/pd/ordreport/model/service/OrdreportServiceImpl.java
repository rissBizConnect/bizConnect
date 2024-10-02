package org.riss.bizconnect.pd.ordreport.model.service;

import org.riss.bizconnect.pd.ordreport.model.dao.OrdreportDAO;
import org.riss.bizconnect.pd.ordreport.model.dto.OrdreportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdreportServiceImpl implements OrdreportService {
	
	// ���� ���� ����, DAO�� ����Ͽ� �����ͺ��̽� �۾� ����
    private final OrdreportDAO ordreportDAO;
    
    // OrdreportDAO�� ���Թ޴� ������
    @Autowired
    public OrdreportServiceImpl(OrdreportDAO ordreportDAO) {
        this.ordreportDAO = ordreportDAO;
    }
    
 // �ŷ����� ����
    @Override
    public void createOrdreport(OrdreportDTO ordreport) {
        ordreportDAO.createOrdreport(ordreport);
    }
    
    // �ŷ����� ����
    @Override
    public void deleteOrdreport(Long orderCd) {
        ordreportDAO.deleteOrdreport(orderCd);
    }

    // �ŷ����� ����
    @Override
    public void updateOrdreport(OrdreportDTO ordreport) {
        ordreportDAO.updateOrdreport(ordreport);
    }

 // �ŷ����� ID�� ��ȸ
    @Override
    public OrdreportDTO findOrdreportById(Long orderCd) {
        return ordreportDAO.findOrdreportById(orderCd);
    }

 // ���� �̷� ��ȸ
    @Override
    public List<OrdreportDTO> findPaymentHistory(Long orderCd) {
        return ordreportDAO.findPaymentHistory(orderCd);
    }

    
 // ���� ���� Ȯ��
    @Override
    public boolean checkPaymentStatus(Long orderCd) {
        return ordreportDAO.checkPaymentStatus(orderCd);
    }
}
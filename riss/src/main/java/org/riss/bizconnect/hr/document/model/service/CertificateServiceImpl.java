package org.riss.bizconnect.hr.document.model.service;

import java.util.List;

import org.riss.bizconnect.hr.document.model.dao.CertificateDAO;
import org.riss.bizconnect.hr.document.model.dto.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("certificateService")
public class CertificateServiceImpl implements CertificateService {
	
	@Autowired
	private CertificateDAO certificateDAO;

	@Override
    public List<Certificate> selectCertificates() {
        return certificateDAO.selectCertificates();
    }

    @Override
    public Certificate selectCertificateById(String certificateId) {
        return certificateDAO.selectCertificateById(certificateId);
    }

    @Override
    public int insertCertificate(Certificate certificate) {
        return certificateDAO.insertCertificate(certificate);
    }

    @Override
    public int updateCertificate(Certificate certificate) {
        return certificateDAO.updateCertificate(certificate);
    }

	@Override
	public int deleteCertificate(String certificateId) {
		return certificateDAO.deleteCertificate(certificateId);
	}

	
   

	
}
package org.riss.bizconnect.hr.document.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.riss.bizconnect.common.model.dto.Paging;
import org.riss.bizconnect.hr.attendance.model.dto.Attendance;
import org.riss.bizconnect.hr.document.model.dto.Certificate;
import org.riss.bizconnect.hr.retire.model.dto.Retire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("documentDao")
public class CertificateDAO {

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	// 증명서 목록 조회
    public List<Certificate> selectCertificates() {
        return sqlSessionTemplate.selectList("certificatesMapper.selectCertificates");
    }

    // 증명서 상세 조회
    public Certificate selectCertificateById(String comCode) {
        return sqlSessionTemplate.selectOne("certificatesMapper.selectCertificateById", comCode);
    }

    // 증명서 추가
    public int insertCertificate(Certificate certificate) {
        return sqlSessionTemplate.insert("certificatesMapper.insertCertificate", certificate);
    }

    // 증명서 수정
    public int updateCertificate(Certificate certificate) {
        return sqlSessionTemplate.update("certificatesMapper.updateCertificate", certificate);
    }

    // 증명서 삭제
    public int deleteCertificate(int contractId) {
        return sqlSessionTemplate.delete("certificatesMapper.deleteCertificate", contractId);
    }

}
	

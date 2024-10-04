package org.riss.bizconnect.hr.retireepay.model.service;

import org.springframework.stereotype.Service;

@Service
public class RetirePayServiceImpl implements RetirePayService {

    @Override
    public double calculateRetirePay(double baseSalary, int yearsOfService) {
        // 퇴직금 계산 로직: 기본급 * 근무연수 * 비율 (예: 0.5)
        return baseSalary * yearsOfService * 0.5;
    }
}
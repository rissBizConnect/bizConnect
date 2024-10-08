package org.riss.bizconnect.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.riss.bizconnect.login.dao.UserDAO;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    // 사용자가 유효한지 검증하는 메소드
    public boolean validateUser(String userId, String userPwd, String comCode) {
        return userDAO.isUserValid(userId, userPwd, comCode);
    }
}

package org.riss.bizconnect.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 사용자가 존재하는지 확인하는 메소드
    public boolean isUserValid(String userId, String userPwd, String comCode) {
        String sql = "SELECT COUNT(*) FROM TB_USERINFO WHERE GID = ? AND USER_PW = ? AND COM_CODE = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{userId, userPwd, comCode}, Integer.class);
        return count != null && count > 0;
    }
}

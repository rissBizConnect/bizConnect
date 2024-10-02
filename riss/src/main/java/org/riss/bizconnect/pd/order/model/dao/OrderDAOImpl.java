package org.riss.bizconnect.pd.order.model.dao;

import org.riss.bizconnect.pd.order.model.dto.OrderDTO;
//jdbc템플릿, 매퍼, repository 어디로 불러야할지 물어보기. 아직 감이 다 안잡힘.
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private final JdbcTemplate jdbcTemplate;

    public OrderDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createOrder(OrderDTO order) {
        String sql = "INSERT INTO TB_ORDER (ORDER_CD, ORDER_TYPE, ORDER_DATE, ORDER_RECIEVE_DATE, ORDER_AMOUNT, ORDER_TAX, ORDER_PAYMENT_YN, ORDER_CANCEL_YN, PRODUCT_CD, COM_CODE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getOrderCd(), order.getOrderType(), order.getOrderDate(), order.getOrderReceiveDate(), order.getOrderAmount(), order.getOrderTax(), order.getOrderPaymentYn(), order.getOrderCancelYn(), order.getProductCd(), order.getComCode());
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        String sql = "SELECT * FROM TB_ORDER";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    @Override
    public OrderDTO getOrderById(Long orderCd) {
        String sql = "SELECT * FROM TB_ORDER WHERE ORDER_CD = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderCd}, new OrderRowMapper());
    }

    @Override
    public void updateOrder(OrderDTO order) {
        String sql = "UPDATE TB_ORDER SET ORDER_TYPE = ?, ORDER_DATE = ?, ORDER_RECIEVE_DATE = ?, ORDER_AMOUNT = ?, ORDER_TAX = ?, ORDER_PAYMENT_YN = ?, ORDER_CANCEL_YN = ?, PRODUCT_CD = ?, COM_CODE = ? WHERE ORDER_CD = ?";
        jdbcTemplate.update(sql, order.getOrderType(), order.getOrderDate(), order.getOrderReceiveDate(), order.getOrderAmount(), order.getOrderTax(), order.getOrderPaymentYn(), order.getOrderCancelYn(), order.getProductCd(), order.getComCode(), order.getOrderCd());
    }

    @Override
    public void deleteOrder(Long orderCd) {
        String sql = "DELETE FROM TB_ORDER WHERE ORDER_CD = ?";
        jdbcTemplate.update(sql, orderCd);
    }

    // OrderDTO를 매핑하기 위한 RowMapper 클래스
    // 이거 mapper 관련 물어볼 것
    private static class OrderRowMapper implements RowMapper<OrderDTO> {
        @Override
        public OrderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderDTO order = new OrderDTO();
            order.setOrderCd(rs.getLong("ORDER_CD"));
            order.setOrderType(rs.getString("ORDER_TYPE"));
            order.setOrderDate(rs.getDate("ORDER_DATE").toLocalDate());
            order.setOrderReceiveDate(rs.getDate("ORDER_RECIEVE_DATE").toLocalDate());
            order.setOrderAmount(rs.getDouble("ORDER_AMOUNT"));
            order.setOrderTax(rs.getDouble("ORDER_TAX"));
            order.setOrderPaymentYn(rs.getString("ORDER_PAYMENT_YN").charAt(0));
            order.setOrderCancelYn(rs.getString("ORDER_CANCEL_YN").charAt(0));
            order.setProductCd(rs.getString("PRODUCT_CD"));
            order.setComCode(rs.getString("COM_CODE"));
            return order;
        }
    }
}
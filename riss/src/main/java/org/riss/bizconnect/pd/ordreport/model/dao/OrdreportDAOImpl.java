package org.riss.bizconnect.pd.ordreport.model.dao;

import org.riss.bizconnect.pd.ordreport.model.dto.OrdreportDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrdreportDAOImpl implements OrdreportDAO {

    private final JdbcTemplate jdbcTemplate;

    public OrdreportDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createOrdreport(OrdreportDTO ordreport) {
        String sql = "INSERT INTO TB_ORDREPORT (ORDER_CD, ORDER_TYPE, ORDER_DATE, ORDER_RECEIVE_DATE, " +
                     "ORDER_AMOUNT, ORDER_TAX, ORDER_PAYMENT_YN, ORDER_CANCEL_YN, " +
                     "PRODUCT_CD, COM_CODE, REPORT_TYPE, ORDER_STATUS, PAYMENT_METHOD, CUSTOMER_TYPE) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, ordreport.getOrderCd(), ordreport.getOrderType(), 
                            ordreport.getOrderDate(), ordreport.getOrderReceiveDate(), 
                            ordreport.getOrderAmount(), ordreport.getOrderTax(), 
                            ordreport.getOrderPaymentYn(), ordreport.getOrderCancelYn(), 
                            ordreport.getProductCd(), ordreport.getComCode(), 
                            ordreport.getReportType(), ordreport.getOrderStatus(), 
                            ordreport.getPaymentMethod(), ordreport.getCustomerType());
    }

    @Override
    public void deleteOrdreport(Long orderCd) {
        String sql = "DELETE FROM TB_ORDREPORT WHERE ORDER_CD = ?";
        jdbcTemplate.update(sql, orderCd);
    }

    @Override
    public void updateOrdreport(OrdreportDTO ordreport) {
        String sql = "UPDATE TB_ORDREPORT SET ORDER_TYPE = ?, ORDER_DATE = ?, ODER_RECEIVE_DATE = ?, " +
                     "ORDER_AMOUNT = ?, ORDER_TAX = ?, ORDER_PAYMENT_YN = ?, ORDER_CANCEL_YN = ?, " +
                     "PRODUCT_CD = ?, COM_CODE = ?, REPORT_TYPE = ?, ORDER_STATUS = ?, " +
                     "PAYMENT_METHOD = ?, CUSTOMER_TYPE = ? WHERE ORDER_CD = ?";
        jdbcTemplate.update(sql, ordreport.getOrderType(), ordreport.getOrderDate(), 
                            ordreport.getOrderReceiveDate(), ordreport.getOrderAmount(), 
                            ordreport.getOrderTax(), ordreport.getOrderPaymentYn(), 
                            ordreport.getOrderCancelYn(), ordreport.getProductCd(), 
                            ordreport.getComCode(), ordreport.getReportType(), 
                            ordreport.getOrderStatus(), ordreport.getPaymentMethod(), 
                            ordreport.getCustomerType(), ordreport.getOrderCd());
    }

    @Override
    public OrdreportDTO findOrdreportById(Long orderCd) {
        String sql = "SELECT * FROM TB_ORDREPORT WHERE ORDER_CD = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderCd}, new OrdreportRowMapper());
    }

    @Override
    public List<OrdreportDTO> findPaymentHistory(Long orderCd) {
        String sql = "SELECT * FROM TB_ORDREPORT WHERE ORDER_CD = ? AND ORDER_PAYMENT_YN = 'Y'";
        return jdbcTemplate.query(sql, new Object[]{orderCd}, new OrdreportRowMapper());
    }

    @Override
    public boolean checkPaymentStatus(Long orderCd) {
        String sql = "SELECT ORDER_PAYMENT_YN FROM TB_ORDREPORT WHERE ORDER_CD = ?";
        Character paymentStatus = jdbcTemplate.queryForObject(sql, new Object[]{orderCd}, Character.class);
        return paymentStatus != null && paymentStatus == 'Y';
    }

    // RowMapper Å¬·¡½º
    private static class OrdreportRowMapper implements RowMapper<OrdreportDTO> {
        @Override
        public OrdreportDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrdreportDTO ordreport = new OrdreportDTO();
            ordreport.setOrderCd(rs.getLong("ORDER_CD"));
            ordreport.setOrderType(rs.getString("ORDER_TYPE"));
            ordreport.setOrderDate(rs.getDate("ORDER_DATE").toLocalDate());
            ordreport.setOrderReceiveDate(rs.getDate("ORDER_RECEIVE_DATE").toLocalDate());
            ordreport.setOrderAmount(rs.getDouble("ORDER_AMOUNT"));
            ordreport.setOrderTax(rs.getDouble("ORDER_TAX"));
            ordreport.setOrderPaymentYn(rs.getString("ORDER_PAYMENT_YN").charAt(0));
            ordreport.setOrderCancelYn(rs.getString("ORDER_CANCEL_YN").charAt(0));
            ordreport.setProductCd(rs.getString("PRODUCT_CD"));
            ordreport.setComCode(rs.getString("COM_CODE"));
            ordreport.setReportType(rs.getString("REPORT_TYPE"));
            ordreport.setOrderStatus(rs.getString("ORDER_STATUS"));
            ordreport.setPaymentMethod(rs.getString("PAYMENT_METHOD"));
            ordreport.setCustomerType(rs.getString("CUSTOMER_TYPE"));
            return ordreport;
        }
    }
}
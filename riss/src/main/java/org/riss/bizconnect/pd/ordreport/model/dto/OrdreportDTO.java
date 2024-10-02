package org.riss.bizconnect.pd.ordreport.model.dto;

import java.time.LocalDate;


public class OrdreportDTO {
	 // �ʼ� ������
    private Long orderCd;              // �ֹ� ��ȣ
    private String orderType;          // �ֹ� ����
    private LocalDate orderDate;       // �ֹ� ��¥
    private LocalDate orderReceiveDate; // �ֹ� ���� ��¥
    private double orderAmount;         // �ֹ� �ݾ�
    private double orderTax;            // �ֹ� ����
    private char orderPaymentYn;        // ���� ���� (Y/N)
    private char orderCancelYn;         // �ֹ� ��� ���� (Y/N)
    private String productCd;           // ��ǰ �ڵ�
    private String comCode;             // ȸ�� �ڵ�

    // ���� ������
    private String reportType;          // ���� ���� (��/��/��)
    private String orderStatus;          // �ֹ� ����
    private String paymentMethod;        // ���� ���
    private String customerType;         // �� ����

    // �⺻ ������
    public OrdreportDTO() {}

    // ��� �ʵ带 �ʱ�ȭ�ϴ� ������
    public OrdreportDTO(Long orderCd, String orderType, LocalDate orderDate,
                          LocalDate orderReceiveDate, double orderAmount,
                          double orderTax, char orderPaymentYn, char orderCancelYn,
                          String productCd, String comCode, String reportType,
                          String orderStatus, String paymentMethod, String customerType) {
        this.orderCd = orderCd;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.orderReceiveDate = orderReceiveDate;
        this.orderAmount = orderAmount;
        this.orderTax = orderTax;
        this.orderPaymentYn = orderPaymentYn;
        this.orderCancelYn = orderCancelYn;
        this.productCd = productCd;
        this.comCode = comCode;
        this.reportType = reportType;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.customerType = customerType;
    }

    // Getter �� Setter
    public Long getOrderCd() {
        return orderCd;
    }

    public void setOrderCd(Long orderCd) {
        this.orderCd = orderCd;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getOrderReceiveDate() {
        return orderReceiveDate;
    }

    public void setOrderReceiveDate(LocalDate orderReceiveDate) {
        this.orderReceiveDate = orderReceiveDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(double orderTax) {
        this.orderTax = orderTax;
    }

    public char getOrderPaymentYn() {
        return orderPaymentYn;
    }

    public void setOrderPaymentYn(char orderPaymentYn) {
        this.orderPaymentYn = orderPaymentYn;
    }

    public char getOrderCancelYn() {
        return orderCancelYn;
    }

    public void setOrderCancelYn(char orderCancelYn) {
        this.orderCancelYn = orderCancelYn;
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    // toString �޼���
    @Override
    public String toString() {
        return "OrderReportDTO{" +
                "orderCd=" + orderCd +
                ", orderType='" + orderType + '\'' +
                ", orderDate=" + orderDate +
                ", orderReceiveDate=" + orderReceiveDate +
                ", orderAmount=" + orderAmount +
                ", orderTax=" + orderTax +
                ", orderPaymentYn=" + orderPaymentYn +
                ", orderCancelYn=" + orderCancelYn +
                ", productCd='" + productCd + '\'' +
                ", comCode='" + comCode + '\'' +
                ", reportType='" + reportType + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }

}

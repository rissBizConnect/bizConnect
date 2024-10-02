package org.riss.bizconnect.pd.ordreport.model.dto;

import java.time.LocalDate;


public class OrdreportDTO {
	 // 필수 데이터
    private Long orderCd;              // 주문 번호
    private String orderType;          // 주문 유형
    private LocalDate orderDate;       // 주문 날짜
    private LocalDate orderReceiveDate; // 주문 수령 날짜
    private double orderAmount;         // 주문 금액
    private double orderTax;            // 주문 세금
    private char orderPaymentYn;        // 결제 여부 (Y/N)
    private char orderCancelYn;         // 주문 취소 여부 (Y/N)
    private String productCd;           // 제품 코드
    private String comCode;             // 회사 코드

    // 선택 데이터
    private String reportType;          // 보고서 유형 (일/월/년)
    private String orderStatus;          // 주문 상태
    private String paymentMethod;        // 결제 방식
    private String customerType;         // 고객 유형

    // 기본 생성자
    public OrdreportDTO() {}

    // 모든 필드를 초기화하는 생성자
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

    // Getter 및 Setter
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

    // toString 메서드
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

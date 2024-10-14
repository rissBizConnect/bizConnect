package org.riss.bizconnect.pd.order.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.time.LocalDate;

public class OrderDTO implements Serializable {
    // 필수 데이터
    private Long orderCd;              // 주문 번호
    private String orderType;          // 주문 유형
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;       // 주문 날짜
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderReceiveDate; // 주문 수령 날짜
    private double orderAmount;         // 주문 금액
    private double orderTax;            // 주문 세금
    private char orderPaymentYn;        // 결제 여부 (Y/N)
    private char orderCancelYn;         // 주문 취소 여부 (Y/N)
    private double orderUnitPrice;      // 주문 단가
    private String orderStatus;          // 주문 상태
    private String orderCustomerInfo;    // 고객 정보
    private String orderPaymentType;     // 결제 방식
    private String orderDeletionReason;   // 삭제 사유
    private String empName;              // 직원 이름
    private String reportType;           // 보고서 유형
    private String paymentMethod;        // 결제 방식
    private String paymentStatus;        // 결제 상태
    private String productCd;           // 제품 코드
    private String comCode;             // 회사 코드

    // 기본 생성자
    public OrderDTO() {}

    // 모든 필드를 초기화하는 생성자
    public OrderDTO(Long orderCd, String orderType, LocalDate orderDate,
                    LocalDate orderReceiveDate, double orderAmount,
                    double orderTax, char orderPaymentYn, char orderCancelYn,
                    double orderUnitPrice, String orderStatus, String orderCustomerInfo,
                    String orderPaymentType, String orderDeletionReason, String empName,
                    String reportType, String paymentMethod, String paymentStatus,
                    String productCd, String comCode) {
        this.orderCd = orderCd;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.orderReceiveDate = orderReceiveDate;
        this.orderAmount = orderAmount;
        this.orderTax = orderTax;
        this.orderPaymentYn = orderPaymentYn;
        this.orderCancelYn = orderCancelYn;
        this.orderUnitPrice = orderUnitPrice;
        this.orderStatus = orderStatus;
        this.orderCustomerInfo = orderCustomerInfo;
        this.orderPaymentType = orderPaymentType;
        this.orderDeletionReason = orderDeletionReason;
        this.empName = empName;
        this.reportType = reportType;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.productCd = productCd;
        this.comCode = comCode;
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

    public double getOrderUnitPrice() {
        return orderUnitPrice;
    }

    public void setOrderUnitPrice(double orderUnitPrice) {
        this.orderUnitPrice = orderUnitPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderCustomerInfo() {
        return orderCustomerInfo;
    }

    public void setOrderCustomerInfo(String orderCustomerInfo) {
        this.orderCustomerInfo = orderCustomerInfo;
    }

    public String getOrderPaymentType() {
        return orderPaymentType;
    }

    public void setOrderPaymentType(String orderPaymentType) {
        this.orderPaymentType = orderPaymentType;
    }

    public String getOrderDeletionReason() {
        return orderDeletionReason;
    }

    public void setOrderDeletionReason(String orderDeletionReason) {
        this.orderDeletionReason = orderDeletionReason;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    // toString 메서드
    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderCd=" + orderCd +
                ", orderType='" + orderType + '\'' +
                ", orderDate=" + orderDate +
                ", orderReceiveDate=" + orderReceiveDate +
                ", orderAmount=" + orderAmount +
                ", orderTax=" + orderTax +
                ", orderPaymentYn=" + orderPaymentYn +
                ", orderCancelYn=" + orderCancelYn +
                ", orderUnitPrice=" + orderUnitPrice +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderCustomerInfo='" + orderCustomerInfo + '\'' +
                ", orderPaymentType='" + orderPaymentType + '\'' +
                ", orderDeletionReason='" + orderDeletionReason + '\'' +
                ", empName='" + empName + '\'' +
                ", reportType='" + reportType + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", productCd='" + productCd + '\'' +
                ", comCode='" + comCode + '\'' +
                '}';
    }
}

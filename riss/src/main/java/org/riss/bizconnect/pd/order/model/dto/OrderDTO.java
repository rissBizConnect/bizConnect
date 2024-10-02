package org.riss.bizconnect.pd.order.model.dto;

import java.time.LocalDate;


public class OrderDTO {
	  private Long orderCd;
	    private String orderType;
	    private LocalDate orderDate;
	    private LocalDate orderReceiveDate;
	    private double orderAmount;
	    private double orderTax;
	    private char orderPaymentYn;
	    private char orderCancelYn;
	    private String productCd;
	    private String comCode;
	
	    public OrderDTO() {}
	    
	 // 모든 필드를 초기화하는 생성자
	    public OrderDTO(Long orderCd, String orderType, LocalDate orderDate, LocalDate orderReceiveDate,
	                    double orderAmount, double orderTax, char orderPaymentYn,
	                    char orderCancelYn, String productCd, String comCode) {
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
	    }

	    // Getter, Setter
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
	                ", productCd='" + productCd + '\'' +
	                ", comCode='" + comCode + '\'' +
	                '}';
	    }

}

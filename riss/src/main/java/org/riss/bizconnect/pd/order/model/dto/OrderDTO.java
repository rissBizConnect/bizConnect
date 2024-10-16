package org.riss.bizconnect.pd.order.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderDTO implements Serializable {
    private int orderNo;
    private String licenseCode;
    private String productNo;
    private String orderType;
    private LocalDate orderDate;
    private LocalDate orderReceiveDate;
    private double orderAmount; //=orderSum
    private double orderTax;
    private char orderPaymentYn;
    private char orderCancelYn;
	
    public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(int orderNo, String licenseCode, String productNo, String orderType, LocalDate orderDate,
			LocalDate orderReceiveDate, double orderAmount, double orderTax, char orderPaymentYn, char orderCancelYn) {
		super();
		this.orderNo = orderNo;
		this.licenseCode = licenseCode;
		this.productNo = productNo;
		this.orderType = orderType;
		this.orderDate = orderDate;
		this.orderReceiveDate = orderReceiveDate;
		this.orderAmount = orderAmount;
		this.orderTax = orderTax;
		this.orderPaymentYn = orderPaymentYn;
		this.orderCancelYn = orderCancelYn;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getLicenseCode() {
		return licenseCode;
	}
	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
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
	@Override
	public String toString() {
		return "OrderDTO [orderNo=" + orderNo + ", licenseCode=" + licenseCode + ", productNo=" + productNo
				+ ", orderType=" + orderType + ", orderDate=" + orderDate + ", orderReceiveDate=" + orderReceiveDate
				+ ", orderAmount=" + orderAmount + ", orderTax=" + orderTax + ", orderPaymentYn=" + orderPaymentYn
				+ ", orderCancelYn=" + orderCancelYn + "]";
	}
	
    
    
    
}
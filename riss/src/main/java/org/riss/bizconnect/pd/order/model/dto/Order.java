package org.riss.bizconnect.pd.order.model.dto;

import java.io.Serializable;
import java.sql.Date;


public class Order implements Serializable {

	private static final long serialVersionUID = 7764335170252715653L;
	
	private String comCode;
	private int orderNo; //의미 없음 (자동생성)
	private int orderDiv; //수주번호 (max 값 받아와서 자동생성)
	private int productNoA; //제품번호
	private int orderDetailNo; //디테일 넘버
	private int orderCnt; //수주제품개수
	private int orderPay; //주문금액
	private String customerCode; //고객코드
	private Date orderDate; //주문일
	private String orderType;
	
	public Order() {
		super();
	}

	public Order(String comCode, int orderNo, int orderDiv, int productNoA, int orderDetailNo, int orderCnt,
			int orderPay, String customerCode, Date orderDate, String orderType) {
		super();
		this.comCode = comCode;
		this.orderNo = orderNo;
		this.orderDiv = orderDiv;
		this.productNoA = productNoA;
		this.orderDetailNo = orderDetailNo;
		this.orderCnt = orderCnt;
		this.orderPay = orderPay;
		this.customerCode = customerCode;
		this.orderDate = orderDate;
		this.orderType = orderType;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getOrderDiv() {
		return orderDiv;
	}

	public void setOrderDiv(int orderDiv) {
		this.orderDiv = orderDiv;
	}

	public int getProductNoA() {
		return productNoA;
	}

	public void setProductNoA(int productNoA) {
		this.productNoA = productNoA;
	}

	public int getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(int orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}

	public int getOrderCnt() {
		return orderCnt;
	}

	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}

	public int getOrderPay() {
		return orderPay;
	}

	public void setOrderPay(int orderPay) {
		this.orderPay = orderPay;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Order [comCode=" + comCode + ", orderNo=" + orderNo + ", orderDiv=" + orderDiv + ", productNoA="
				+ productNoA + ", orderDetailNo=" + orderDetailNo + ", orderCnt=" + orderCnt + ", orderPay=" + orderPay
				+ ", customerCode=" + customerCode + ", orderDate=" + orderDate + ", orderType=" + orderType + "]";
	}
	
	
}

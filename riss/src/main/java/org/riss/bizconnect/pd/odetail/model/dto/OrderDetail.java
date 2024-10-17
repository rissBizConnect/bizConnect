package org.riss.bizconnect.pd.odetail.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class OrderDetail implements Serializable {
  
	private static final long serialVersionUID = 4616815108095406280L;
	
	private String comCode;
	private int orderDetailNo;
	private int detailNo; //수주제품번호
    private int orderDiv; //수주번호 (ocontract) 자동
    private int productNo; //제품번호 (product)
    private Date orderDetailDate; //수주납기일
    private String orderDetailPayment; //수주-결제유무 (결제완료, 결제중, 미결제)
    private String orderDetailCancel; //수주-취소유무 (취소완료, 취소진행중, 결제)
	private String orderDetailStatus; //수주상태
	private int orderDetailCnt; //수주 개수
	private String orderType;
	
	public OrderDetail() {
		super();
	}

	public OrderDetail(String comCode, int orderDetailNo, int detailNo, int orderDiv, int productNo,
			Date orderDetailDate, String orderDetailPayment, String orderDetailCancel, String orderDetailStatus,
			int orderDetailCnt, String orderType) {
		super();
		this.comCode = comCode;
		this.orderDetailNo = orderDetailNo;
		this.detailNo = detailNo;
		this.orderDiv = orderDiv;
		this.productNo = productNo;
		this.orderDetailDate = orderDetailDate;
		this.orderDetailPayment = orderDetailPayment;
		this.orderDetailCancel = orderDetailCancel;
		this.orderDetailStatus = orderDetailStatus;
		this.orderDetailCnt = orderDetailCnt;
		this.orderType = orderType;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public int getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(int orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}

	public int getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(int detailNo) {
		this.detailNo = detailNo;
	}

	public int getOrderDiv() {
		return orderDiv;
	}

	public void setOrderDiv(int orderDiv) {
		this.orderDiv = orderDiv;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public Date getOrderDetailDate() {
		return orderDetailDate;
	}

	public void setOrderDetailDate(Date orderDetailDate) {
		this.orderDetailDate = orderDetailDate;
	}

	public String getOrderDetailPayment() {
		return orderDetailPayment;
	}

	public void setOrderDetailPayment(String orderDetailPayment) {
		this.orderDetailPayment = orderDetailPayment;
	}

	public String getOrderDetailCancel() {
		return orderDetailCancel;
	}

	public void setOrderDetailCancel(String orderDetailCancel) {
		this.orderDetailCancel = orderDetailCancel;
	}

	public String getOrderDetailStatus() {
		return orderDetailStatus;
	}

	public void setOrderDetailStatus(String orderDetailStatus) {
		this.orderDetailStatus = orderDetailStatus;
	}

	public int getOrderDetailCnt() {
		return orderDetailCnt;
	}

	public void setOrderDetailCnt(int orderDetailCnt) {
		this.orderDetailCnt = orderDetailCnt;
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
		return "OrderDetail [comCode=" + comCode + ", orderDetailNo=" + orderDetailNo + ", detailNo=" + detailNo
				+ ", orderDiv=" + orderDiv + ", productNo=" + productNo + ", orderDetailDate=" + orderDetailDate
				+ ", orderDetailPayment=" + orderDetailPayment + ", orderDetailCancel=" + orderDetailCancel
				+ ", orderDetailStatus=" + orderDetailStatus + ", orderDetailCnt=" + orderDetailCnt + ", orderType="
				+ orderType + "]";
	}

	

}
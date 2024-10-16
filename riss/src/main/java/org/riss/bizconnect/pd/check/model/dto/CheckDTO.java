package org.riss.bizconnect.pd.check.model.dto;

import java.time.LocalDate;

public class CheckDTO {
	private String orderNo; // 주문번호(수주)
	private String exchangeYn; // 교환여부
	private LocalDate exchangeDate; // 교환날짜
	private String refundYn; //환불여부
	private LocalDate refundDate; //환불날짜
	
	public CheckDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckDTO(String orderNo, String exchangeYn, LocalDate exchangeDate, String refundYn, LocalDate refundDate) {
		super();
		this.orderNo = orderNo;
		this.exchangeYn = exchangeYn;
		this.exchangeDate = exchangeDate;
		this.refundYn = refundYn;
		this.refundDate = refundDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getExchangeYn() {
		return exchangeYn;
	}

	public void setExchangeYn(String exchangeYn) {
		this.exchangeYn = exchangeYn;
	}

	public LocalDate getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(LocalDate exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

	public String getRefundYn() {
		return refundYn;
	}

	public void setRefundYn(String refundYn) {
		this.refundYn = refundYn;
	}

	public LocalDate getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(LocalDate refundDate) {
		this.refundDate = refundDate;
	}

	@Override
	public String toString() {
		return "CheckDTO [orderNo=" + orderNo + ", exchangeYn=" + exchangeYn + ", exchangeDate=" + exchangeDate
				+ ", refundYn=" + refundYn + ", refundDate=" + refundDate + "]";
	}
	
	
	
}

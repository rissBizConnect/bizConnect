package org.riss.bizconnect.pd.ref.model.dto;

public class RefDTO {
	private String orderNo; //수주번호
	private String porderNo; //발주번호
	
	public RefDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RefDTO(String orderNo, String porderNo) {
		super();
		this.orderNo = orderNo;
		this.porderNo = porderNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPorderNo() {
		return porderNo;
	}

	public void setPorderNo(String porderNo) {
		this.porderNo = porderNo;
	}

	@Override
	public String toString() {
		return "RefDTO [orderNo=" + orderNo + ", porderNo=" + porderNo + "]";
	}
	
	
}

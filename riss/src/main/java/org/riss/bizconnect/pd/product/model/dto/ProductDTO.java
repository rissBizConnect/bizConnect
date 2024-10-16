package org.riss.bizconnect.pd.product.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ProductDTO implements Serializable {
	
	private static final long serialVersionUID = 3765759391170591356L;
	
	private String ProductNo; //발주-제품번호
	private String LicenseCode; //회사코드
	private String PorderNo; //발주번호
	private String ClientCode; //거래처번호
	private String ProductName; //발주-제품명
	private double ProductPrice; //발주-판매단가
	private double ProductPurPrice; //발주-구매단가
	private int ProductCnt; //제품수량
	private LocalDate ProductiDate; //발주제품-입고일
	private LocalDate ProductoDate; //발주제품-출고일
	private String ProductSize; //발주제품-규격
	private String ProductStatus; //제품상태
	private String FieldNum; //창고번호
	
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String productNo, String licenseCode, String porderNo, String clientCode, String productName,
			double productPrice, double productPurPrice, int productCnt, LocalDate productiDate, LocalDate productoDate,
			String productSize, String productStatus, String fieldNum) {
		super();
		ProductNo = productNo;
		LicenseCode = licenseCode;
		PorderNo = porderNo;
		ClientCode = clientCode;
		ProductName = productName;
		ProductPrice = productPrice;
		ProductPurPrice = productPurPrice;
		ProductCnt = productCnt;
		ProductiDate = productiDate;
		ProductoDate = productoDate;
		ProductSize = productSize;
		ProductStatus = productStatus;
		FieldNum = fieldNum;
	}

	public String getProductNo() {
		return ProductNo;
	}

	public void setProductNo(String productNo) {
		ProductNo = productNo;
	}

	public String getLicenseCode() {
		return LicenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		LicenseCode = licenseCode;
	}

	public String getPorderNo() {
		return PorderNo;
	}

	public void setPorderNo(String porderNo) {
		PorderNo = porderNo;
	}

	public String getClientCode() {
		return ClientCode;
	}

	public void setClientCode(String clientCode) {
		ClientCode = clientCode;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}

	public double getProductPurPrice() {
		return ProductPurPrice;
	}

	public void setProductPurPrice(double productPurPrice) {
		ProductPurPrice = productPurPrice;
	}

	public int getProductCnt() {
		return ProductCnt;
	}

	public void setProductCnt(int productCnt) {
		ProductCnt = productCnt;
	}

	public LocalDate getProductiDate() {
		return ProductiDate;
	}

	public void setProductiDate(LocalDate productiDate) {
		ProductiDate = productiDate;
	}

	public LocalDate getProductoDate() {
		return ProductoDate;
	}

	public void setProductoDate(LocalDate productoDate) {
		ProductoDate = productoDate;
	}

	public String getProductSize() {
		return ProductSize;
	}

	public void setProductSize(String productSize) {
		ProductSize = productSize;
	}

	public String getProductStatus() {
		return ProductStatus;
	}

	public void setProductStatus(String productStatus) {
		ProductStatus = productStatus;
	}

	public String getFieldNum() {
		return FieldNum;
	}

	public void setFieldNum(String fieldNum) {
		FieldNum = fieldNum;
	}

	@Override
	public String toString() {
		return "ProductDTO [ProductNo=" + ProductNo + ", LicenseCode=" + LicenseCode + ", PorderNo=" + PorderNo
				+ ", ClientCode=" + ClientCode + ", ProductName=" + ProductName + ", ProductPrice=" + ProductPrice
				+ ", ProductPurPrice=" + ProductPurPrice + ", ProductCnt=" + ProductCnt + ", ProductiDate="
				+ ProductiDate + ", ProductoDate=" + ProductoDate + ", ProductSize=" + ProductSize + ", ProductStatus="
				+ ProductStatus + ", FieldNum=" + FieldNum + "]";
	}
	
	
	
}

package org.riss.bizconnect.pd.product.model.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = -7693740908732975146L;
	
	private int productNo; //제품번호 자동생성
	private String licenseCode; //회사코드
	private String clientCode; //거래처코드
	private String productName; //제품명
	private int productCnt; //제품개수
	private int productCri; //제품-규격기준(전체)
	private int productSize; //제품-크기
	private int productLength; //가로
	private int productWidth; //세로
	private int productHeight; //높이
	private int productWeight; //제품-중량(g)
	private int productVolume; //제품-용량(ml)
	private int productPrice; //판매가
	private int productPurPrice; //매입가
	private int productcStock; //현재재고량
	private int productStockWarn; //재고경고임계치

	private String productStatus; //제품상태
	private String fieldNum; //창고번호
	private String empName; //담당자명
	private String productImage; //제품사진
	
	public ProductDTO() {
		super();
	}

	public ProductDTO(int productNo, String licenseCode, String clientCode, String productName, int productCnt,
			int productCri, int productSize, int productLength, int productWidth, int productHeight, int productWeight,
			int productVolume, int productPrice, int productPurPrice, int productcStock, int productStockWarn,
			String productStatus, String fieldNum, String empName, String productImage) {
		super();
		this.productNo = productNo;
		this.licenseCode = licenseCode;
		this.clientCode = clientCode;
		this.productName = productName;
		this.productCnt = productCnt;
		this.productCri = productCri;
		this.productSize = productSize;
		this.productLength = productLength;
		this.productWidth = productWidth;
		this.productHeight = productHeight;
		this.productWeight = productWeight;
		this.productVolume = productVolume;
		this.productPrice = productPrice;
		this.productPurPrice = productPurPrice;
		this.productcStock = productcStock;
		this.productStockWarn = productStockWarn;
		this.productStatus = productStatus;
		this.fieldNum = fieldNum;
		this.empName = empName;
		this.productImage = productImage;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getLicenseCode() {
		return licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}

	public int getProductCri() {
		return productCri;
	}

	public void setProductCri(int productCri) {
		this.productCri = productCri;
	}

	public int getProductSize() {
		return productSize;
	}

	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}

	public int getProductLength() {
		return productLength;
	}

	public void setProductLength(int productLength) {
		this.productLength = productLength;
	}

	public int getProductWidth() {
		return productWidth;
	}

	public void setProductWidth(int productWidth) {
		this.productWidth = productWidth;
	}

	public int getProductHeight() {
		return productHeight;
	}

	public void setProductHeight(int productHeight) {
		this.productHeight = productHeight;
	}

	public int getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(int productWeight) {
		this.productWeight = productWeight;
	}

	public int getProductVolume() {
		return productVolume;
	}

	public void setProductVolume(int productVolume) {
		this.productVolume = productVolume;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductPurPrice() {
		return productPurPrice;
	}

	public void setProductPurPrice(int productPurPrice) {
		this.productPurPrice = productPurPrice;
	}

	public int getProductcStock() {
		return productcStock;
	}

	public void setProductcStock(int productcStock) {
		this.productcStock = productcStock;
	}

	public int getProductStockWarn() {
		return productStockWarn;
	}

	public void setProductStockWarn(int productStockWarn) {
		this.productStockWarn = productStockWarn;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getFieldNum() {
		return fieldNum;
	}

	public void setFieldNum(String fieldNum) {
		this.fieldNum = fieldNum;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", licenseCode=" + licenseCode + ", clientCode=" + clientCode
				+ ", productName=" + productName + ", productCnt=" + productCnt + ", productCri=" + productCri
				+ ", productSize=" + productSize + ", productLength=" + productLength + ", productWidth=" + productWidth
				+ ", productHeight=" + productHeight + ", productWeight=" + productWeight + ", productVolume="
				+ productVolume + ", productPrice=" + productPrice + ", productPurPrice=" + productPurPrice
				+ ", productcStock=" + productcStock + ", productStockWarn=" + productStockWarn + ", productStatus="
				+ productStatus + ", fieldNum=" + fieldNum + ", empName=" + empName + ", productImage=" + productImage
				+ "]";
	}
	
	
}

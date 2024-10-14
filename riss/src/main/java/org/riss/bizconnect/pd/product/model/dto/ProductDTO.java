package org.riss.bizconnect.pd.product.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ProductDTO implements Serializable {
	
	private static final long serialVersionUID = 3765759391170591356L;
	
	private String productNo; //발주-제품번호
	private String licenseCode; //회사코드
	private String porderNo; //발주번호
	private String clientCode; //거래처코드
	private String productName; //발주-제품명
	private double productPrice; //발주-판매가
	private double productPurPrice; //발주-매입가
	private double productVat; //부가세 (안 쓸지도)
	private String orderType; //발주/수주구분 (P/O)
	private int productCnt; //제품수량 (=등록할 개수)
	private int productiStock; //초기재고량
	private int productcStock; //현재재고량
	private int productStockWarn; //재고경고임계치
	private LocalDate productiDate; //발주제품-입고일
	private String productCri; //발주제품-규격기준(전체)
	private String productSize; //발주제품-크기
	private int productLength; //가로
	private int productWidth; //세로
	private int productHeight; //높이
	private String productWeight; //발주제품-중량(g)
	private String productVolume; //발주제품-용량(ml)
	private String productStatus; //제품상태
	private String fieldNum; //창고번호
	private String empName; //담당자명
	
	public String productStockStatus() {
	    if (productcStock <= productStockWarn) {
	        return "부족"; // 재고 <= 경고 임계치
	    } else {
	        return "안전"; // 재고 > 경고 임계치
	    }
	}

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String productNo, String licenseCode, String porderNo, String clientCode, String productName,
			double productPrice, double productPurPrice, double productVat, String orderType, int productCnt,
			int productiStock, int productcStock, int productStockWarn, LocalDate productiDate, String productCri,
			String productSize, int productLength, int productWidth, int productHeight, String productWeight,
			String productVolume, String productStatus, String fieldNum, String empName) {
		super();
		this.productNo = productNo;
		this.licenseCode = licenseCode;
		this.porderNo = porderNo;
		this.clientCode = clientCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productPurPrice = productPurPrice;
		this.productVat = productVat;
		this.orderType = orderType;
		this.productCnt = productCnt;
		this.productiStock = productiStock;
		this.productcStock = productcStock;
		this.productStockWarn = productStockWarn;
		this.productiDate = productiDate;
		this.productCri = productCri;
		this.productSize = productSize;
		this.productLength = productLength;
		this.productWidth = productWidth;
		this.productHeight = productHeight;
		this.productWeight = productWeight;
		this.productVolume = productVolume;
		this.productStatus = productStatus;
		this.fieldNum = fieldNum;
		this.empName = empName;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getLicenseCode() {
		return licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	public String getPorderNo() {
		return porderNo;
	}

	public void setPorderNo(String porderNo) {
		this.porderNo = porderNo;
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

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductPurPrice() {
		return productPurPrice;
	}

	public void setProductPurPrice(double productPurPrice) {
		this.productPurPrice = productPurPrice;
	}

	public double getProductVat() {
		return productVat;
	}

	public void setProductVat(double productVat) {
		this.productVat = productVat;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}

	public int getProductiStock() {
		return productiStock;
	}

	public void setProductiStock(int productiStock) {
		this.productiStock = productiStock;
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

	public LocalDate getProductiDate() {
		return productiDate;
	}

	public void setProductiDate(LocalDate productiDate) {
		this.productiDate = productiDate;
	}

	public String getProductCri() {
		return productCri;
	}

	public void setProductCri(String productCri) {
		this.productCri = productCri;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
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

	public String getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(String productWeight) {
		this.productWeight = productWeight;
	}

	public String getProductVolume() {
		return productVolume;
	}

	public void setProductVolume(String productVolume) {
		this.productVolume = productVolume;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", licenseCode=" + licenseCode + ", porderNo=" + porderNo
				+ ", clientCode=" + clientCode + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productPurPrice=" + productPurPrice + ", productVat=" + productVat + ", orderType=" + orderType
				+ ", productCnt=" + productCnt + ", productiStock=" + productiStock + ", productcStock=" + productcStock
				+ ", productStockWarn=" + productStockWarn + ", productiDate=" + productiDate + ", productCri="
				+ productCri + ", productSize=" + productSize + ", productLength=" + productLength + ", productWidth="
				+ productWidth + ", productHeight=" + productHeight + ", productWeight=" + productWeight
				+ ", productVolume=" + productVolume + ", productStatus=" + productStatus + ", fieldNum=" + fieldNum
				+ ", empName=" + empName + "]";
	}

	
	
}
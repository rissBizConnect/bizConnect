package org.riss.bizconnect.hr.salary.model.dto;

import java.io.Serializable;
import java.util.Date;

public class Salary implements Serializable {

	private static final long serialVersionUID = 8840153939446198470L;

	private String gId;		//아이디
	private String comCode;	//회사코드
	private int salaryNo;		//급여번호
	private int salaryIncomT;	//소득세
	private int salaryLocalT;	//지방세
	private int salaryNPS;		//국민연금
	private int salaryHI;		//건강보험
	private int salaryEL;		//고용보험
	private int salaryWCI;		//산재보험
	private int salaryLTCI;		//장기요양
	private int salaryTotalD;	//공제총합
	private int salaryIncentive;	//추가수당
	private Date salaryPayDate;	//지금일
	private int salaryPay;		//지급액
	private String accountNumber;//송금계좌
	private String name;
	
	public Salary() {
		super();
	}

	
	public Salary(String gId, String comCode) {
		super();
		this.gId = gId;
		this.comCode = comCode;
	}


	public Salary(String gId, String comCode, int salaryNo, int salaryIncomT, int salaryLocalT, int salaryNPS,
			int salaryHI, int salaryEL, int salaryWCI, int salaryLTCI, int salaryTotalD, int salaryIncentive,
			Date salaryPayDate, int salaryPay, String accountNumber, String name) {
		super();
		this.gId = gId;
		this.comCode = comCode;
		this.salaryNo = salaryNo;
		this.salaryIncomT = salaryIncomT;
		this.salaryLocalT = salaryLocalT;
		this.salaryNPS = salaryNPS;
		this.salaryHI = salaryHI;
		this.salaryEL = salaryEL;
		this.salaryWCI = salaryWCI;
		this.salaryLTCI = salaryLTCI;
		this.salaryTotalD = salaryTotalD;
		this.salaryIncentive = salaryIncentive;
		this.salaryPayDate = salaryPayDate;
		this.salaryPay = salaryPay;
		this.accountNumber = accountNumber;
		this.name = name;
	}


	public String getgId() {
		return gId;
	}


	public void setgId(String gId) {
		this.gId = gId;
	}


	public String getComCode() {
		return comCode;
	}


	public void setComCode(String comCode) {
		this.comCode = comCode;
	}


	public int getSalaryNo() {
		return salaryNo;
	}


	public void setSalaryNo(int salaryNo) {
		this.salaryNo = salaryNo;
	}


	public int getSalaryIncomT() {
		return salaryIncomT;
	}


	public void setSalaryIncomT(int salaryIncomT) {
		this.salaryIncomT = salaryIncomT;
	}


	public int getSalaryLocalT() {
		return salaryLocalT;
	}


	public void setSalaryLocalT(int salaryLocalT) {
		this.salaryLocalT = salaryLocalT;
	}


	public int getSalaryNPS() {
		return salaryNPS;
	}


	public void setSalaryNPS(int salaryNPS) {
		this.salaryNPS = salaryNPS;
	}


	public int getSalaryHI() {
		return salaryHI;
	}


	public void setSalaryHI(int salaryHI) {
		this.salaryHI = salaryHI;
	}


	public int getSalaryEL() {
		return salaryEL;
	}


	public void setSalaryEL(int salaryEL) {
		this.salaryEL = salaryEL;
	}


	public int getSalaryWCI() {
		return salaryWCI;
	}


	public void setSalaryWCI(int salaryWCI) {
		this.salaryWCI = salaryWCI;
	}


	public int getSalaryLTCI() {
		return salaryLTCI;
	}


	public void setSalaryLTCI(int salaryLTCI) {
		this.salaryLTCI = salaryLTCI;
	}


	public int getSalaryTotalD() {
		return salaryTotalD;
	}


	public void setSalaryTotalD(int salaryTotalD) {
		this.salaryTotalD = salaryTotalD;
	}


	public int getSalaryIncentive() {
		return salaryIncentive;
	}


	public void setSalaryIncentive(int salaryIncentive) {
		this.salaryIncentive = salaryIncentive;
	}


	public Date getSalaryPayDate() {
		return salaryPayDate;
	}


	public void setSalaryPayDate(Date salaryPayDate) {
		this.salaryPayDate = salaryPayDate;
	}


	public int getSalaryPay() {
		return salaryPay;
	}


	public void setSalaryPay(int salaryPay) {
		this.salaryPay = salaryPay;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Salary [gId=" + gId + ", comCode=" + comCode + ", salaryNo=" + salaryNo + ", salaryIncomT="
				+ salaryIncomT + ", salaryLocalT=" + salaryLocalT + ", salaryNPS=" + salaryNPS + ", salaryHI="
				+ salaryHI + ", salaryEL=" + salaryEL + ", salaryWCI=" + salaryWCI + ", salaryLTCI=" + salaryLTCI
				+ ", salaryTotalD=" + salaryTotalD + ", salaryIncentive=" + salaryIncentive + ", salaryPayDate="
				+ salaryPayDate + ", salaryPay=" + salaryPay + ", accountNumber=" + accountNumber + ", name=" + name
				+ "]";
	}


}

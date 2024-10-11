package org.riss.bizconnect.common.model.dto;

import java.sql.Date;

public class Search {
	private String keyword;  	//제목, 내용 검색 키워드
	private int startRow;		//한 페이지에 출력할 목록의 시작행
	private int endRow;		//한 페이지에 출력할 목록의 끝행
	private Date begin;			//등록날짜 검색의 시작날짜
	private Date end;			//등록날짜 검색의 끝날짜
	private int age;			//회원관리에서 연령대별 검색에서의 나이
	private String comCode;

	public Search() {
		super();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	@Override
	public String toString() {
		return "Search [keyword=" + keyword + ", startRow=" + startRow + ", endRow=" + endRow + ", begin=" + begin
				+ ", end=" + end + ", age=" + age + ", comCode=" + comCode + "]";
	}
}

package org.myweb.first.board.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {
	private static final long serialVersionUID = -6086290596677675589L;

	private int boardNum;				//BOARD_NUM	NUMBER
	private String boardWriter;			//BOARD_WRITER	VARCHAR2(50 BYTE)
	private String boardTitle;			//BOARD_TITLE	VARCHAR2(50 BYTE)
	private String boardContent;				//BOARD_CONTENT	VARCHAR2(2000 BYTE)
	private String boardOriginalFilename;	//BOARD_ORIGINAL_FILENAME	VARCHAR2(100 BYTE)
	private String boardRenameFilename;	//BOARD_RENAME_FILENAME	VARCHAR2(100 BYTE)
	private int boardRef;				//BOARD_REF	NUMBER
	private int boardRelplyRef;			//BOARD_REPLY_REF	NUMBER
	private int boardLev;				//BOARD_LEV	NUMBER
	private int boardReplySeq;			//BOARD_REPLY_SEQ	NUMBER
	private int boardReadcount;			//BOARD_READCOUNT	NUMBER
	private Date boardDate;					//BOARD_DATE	DATE
	
	public Board() {
		super();
	}
	
	public Board(int boardNum, String boardWriter, String boardTitle, String boardContent, String boardOriginalFilename,
			String boardRenameFilename, int boardRef, int boardRelplyRef, int boardLev, int boardReplySeq,
			int boardReadcount, Date boardDate) {
		super();
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardOriginalFilename = boardOriginalFilename;
		this.boardRenameFilename = boardRenameFilename;
		this.boardRef = boardRef;
		this.boardRelplyRef = boardRelplyRef;
		this.boardLev = boardLev;
		this.boardReplySeq = boardReplySeq;
		this.boardReadcount = boardReadcount;
		this.boardDate = boardDate;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
	public String getBoardWriter() {
		return boardWriter;
	}
	
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
	public String getBoardOriginalFilename() {
		return boardOriginalFilename;
	}
	
	public void setBoardOriginalFilename(String boardOriginalFilename) {
		this.boardOriginalFilename = boardOriginalFilename;
	}
	
	public String getBoardRenameFilename() {
		return boardRenameFilename;
	}
	public void setBoardRenameFilename(String boardRenameFilename) {
		this.boardRenameFilename = boardRenameFilename;
	}
	
	public int getBoardRef() {
		return boardRef;
	}
	
	public void setBoardRef(int boardRef) {
		this.boardRef = boardRef;
	}
	
	public int getBoardRelplyRef() {
		return boardRelplyRef;
	}
	
	public void setBoardRelplyRef(int boardRelplyRef) {
		this.boardRelplyRef = boardRelplyRef;
	}
	
	public int getBoardLev() {
		return boardLev;
	}
	
	public void setBoardLev(int boardLev) {
		this.boardLev = boardLev;
	}
	
	public int getBoardReplySeq() {
		return boardReplySeq;
	}
	
	public void setBoardReplySeq(int boardReplySeq) {
		this.boardReplySeq = boardReplySeq;
	}
	
	public int getBoardReadcount() {
		return boardReadcount;
	}
	
	public void setBoardReadcount(int boardReadcount) {
		this.boardReadcount = boardReadcount;
	}
	
	public Date getBoardDate() {
		return boardDate;
	}
	
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardWriter=" + boardWriter + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardOriginalFilename=" + boardOriginalFilename
				+ ", boardRenameFilename=" + boardRenameFilename + ", boardRef=" + boardRef + ", boardRelplyRef="
				+ boardRelplyRef + ", boardLev=" + boardLev + ", boardReplySeq=" + boardReplySeq + ", boardReadcount="
				+ boardReadcount + ", boardDate=" + boardDate + "]";
	}
	
	
}

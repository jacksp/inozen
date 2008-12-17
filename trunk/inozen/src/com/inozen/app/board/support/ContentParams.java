package com.inozen.app.board.support;


/**
 * @author seokhoon
 */
public class ContentParams {

	private String contentTitle;
	private long contentCode;
	private long boardCode;

	public void setContentCode(long contentCode) {
		this.contentCode = contentCode;
	}

	public long getContentCode() {
		return contentCode;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setBoardCode(long boardCode) {
		this.boardCode = boardCode;
	}

	public long getBoardCode() {
		return boardCode;
	}

}

package com.inozen.app.board.support;

import java.util.Date;
import java.util.List;

/**
 * @author seokhoon
 */
public class AppBoardParams {

	private String boardName;
	private long cateCode;

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
	public long getCateCode() {
		return cateCode;
	}
	
	public void setCateCode(long cateCode) {
		this.cateCode = cateCode;
	}

}

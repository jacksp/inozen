package com.inozen.app.admin.board;

import com.inozen.framework.service.GenericService;

import com.inozen.app.admin.board.support.BoardParams;
import com.inozen.app.model.Board;

public interface BoardService extends GenericService<Board, BoardDao, BoardParams>{
	int countBoardByCateCode(long cateCode);
}

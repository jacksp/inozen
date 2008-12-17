package com.inozen.app.board;

import com.inozen.framework.service.GenericService;

import com.inozen.app.admin.board.support.BoardParams;
import com.inozen.app.model.Board;

public interface AppBoardService extends GenericService<Board, AppBoardDao, BoardParams>{
	int countBoardByCateCode(long cateCode);
}

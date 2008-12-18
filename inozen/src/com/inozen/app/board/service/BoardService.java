package com.inozen.app.board.service;

import com.inozen.framework.service.GenericService;

import com.inozen.app.board.dao.BoardDao;
import com.inozen.app.board.support.BoardParams;
import com.inozen.app.model.Board;

public interface BoardService extends GenericService<Board, BoardDao, BoardParams>{
	int countBoardByCateCode(long cateCode);
}

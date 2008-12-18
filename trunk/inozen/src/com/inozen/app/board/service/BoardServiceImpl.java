package com.inozen.app.board.service;

import com.inozen.framework.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.board.dao.BoardDao;
import com.inozen.app.board.support.BoardParams;
import com.inozen.app.model.Board;

@Service
@Transactional
public class BoardServiceImpl extends GenericServiceImpl<Board, BoardDao, BoardParams> implements BoardService {

	public BoardServiceImpl() {
		super(BoardDao.class);
	}

	@Override
	public int countBoardByCateCode(long cateCode) {
		
		return dao.countBoardByCateCode(cateCode);
	}

}

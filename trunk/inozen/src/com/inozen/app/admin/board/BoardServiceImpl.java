package com.inozen.app.admin.board;

import com.inozen.framework.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.admin.board.support.BoardParams;
import com.inozen.app.model.Board;

@Service
@Transactional
public class BoardServiceImpl extends GenericServiceImpl<Board, BoardDao, BoardParams> implements BoardService {

	public BoardServiceImpl() {
		super(BoardDao.class);
	}

}

package com.inozen.app.board;

import com.inozen.framework.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.admin.board.support.BoardParams;
import com.inozen.app.model.Board;

@Service
@Transactional
public class AppBoardServiceImpl extends GenericServiceImpl<Board, AppBoardDao, BoardParams> implements AppBoardService {

	public AppBoardServiceImpl() {
		super(AppBoardDao.class);
	}

	@Override
	public int countBoardByCateCode(long cateCode) {
		
		return dao.countBoardByCateCode(cateCode);
	}

}

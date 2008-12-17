package com.inozen.app.board;

import com.inozen.framework.data.GenericDao;
import com.inozen.framework.data.hibernate.HibernateDao;

import com.inozen.app.admin.board.support.BoardParams;
import com.inozen.app.model.Board;

public interface AppBoardDao extends HibernateDao<Board, BoardParams>{

	public int countBoardByCateCode(long cateCode);
}

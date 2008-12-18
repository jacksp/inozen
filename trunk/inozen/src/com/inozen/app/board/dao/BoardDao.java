package com.inozen.app.board.dao;

import com.inozen.framework.data.GenericDao;
import com.inozen.framework.data.hibernate.HibernateDao;

import com.inozen.app.board.support.BoardParams;
import com.inozen.app.model.Board;

public interface BoardDao extends HibernateDao<Board, BoardParams>{

	public int countBoardByCateCode(long cateCode);
}

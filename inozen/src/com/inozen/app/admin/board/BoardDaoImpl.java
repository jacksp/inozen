package com.inozen.app.admin.board;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import com.inozen.framework.data.hibernate.CriteriaUtils;
import com.inozen.framework.data.hibernate.HibernateGenericDao;
import org.springframework.stereotype.Repository;

import com.inozen.app.admin.board.support.BoardParams;
import com.inozen.app.model.Board;

@Repository
public class BoardDaoImpl extends HibernateGenericDao<Board, BoardParams> implements BoardDao {

	@Override
	protected Criteria addRestrictions(Criteria c, BoardParams params) {
		CriteriaUtils.ilike(c, "boardName", params.getBoardName(), MatchMode.ANYWHERE);
		return c;
	}

	@Override
	public int countBoardByCateCode(long cateCode) {
		Long count = (Long)getSession().createQuery("select count(*) from tbl_board a where a.category.cateCode=:cateCode")
		.setParameter("cateCode", cateCode).uniqueResult();
		return count.intValue();
	}
	
}

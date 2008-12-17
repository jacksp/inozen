package com.inozen.app.board.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import com.inozen.framework.data.hibernate.CriteriaUtils;
import com.inozen.framework.data.hibernate.HibernateGenericDao;
import org.springframework.stereotype.Repository;

import com.inozen.app.board.support.ContentParams;
import com.inozen.app.model.Content;

@Repository
public class ContentDaoImpl extends HibernateGenericDao<Content, ContentParams> implements ContentDao {

	@Override
	protected Criteria addRestrictions(Criteria c, ContentParams params) {
		CriteriaUtils.ilike(c, "contnetTitle", params.getContentTitle(), MatchMode.ANYWHERE);
		CriteriaUtils.conditionalEq(c, "board.boardCode", params.getBoardCode());
		return c;
	}

	
}

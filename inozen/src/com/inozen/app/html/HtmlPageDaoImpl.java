package com.inozen.app.html;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import com.inozen.framework.data.hibernate.CriteriaUtils;
import com.inozen.framework.data.hibernate.HibernateGenericDao;
import org.springframework.stereotype.Repository;

import com.inozen.app.html.support.HtmlPageParams;
import com.inozen.app.model.HtmlPage;

@Repository
public class HtmlPageDaoImpl extends HibernateGenericDao<HtmlPage, HtmlPageParams> implements HtmlPageDao {

	@Override
	protected Criteria addRestrictions(Criteria c, HtmlPageParams params) {
		CriteriaUtils.ilike(c, "pageName", params.getPageName(), MatchMode.ANYWHERE);
		return c;
	}

}

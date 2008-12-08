package com.inozen.app.task;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import com.inozen.framework.data.hibernate.CriteriaUtils;
import com.inozen.framework.data.hibernate.HibernateGenericDao;
import org.springframework.stereotype.Repository;

import com.inozen.app.model.Task;
import com.inozen.app.task.support.TaskParams;

@Repository
public class TaskDaoImpl extends HibernateGenericDao<Task, TaskParams> implements TaskDao {

	@Override
	protected Criteria addRestrictions(Criteria c, TaskParams params) {
		CriteriaUtils.ilike(c, "name", params.getName(), MatchMode.ANYWHERE);
		return c;
	}
	
}

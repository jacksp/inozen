package com.inozen.app.employee;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import com.inozen.framework.data.hibernate.CriteriaUtils;
import com.inozen.framework.data.hibernate.HibernateGenericDao;
import org.springframework.stereotype.Repository;

import com.inozen.app.employee.support.EmployeeParams;
import com.inozen.app.model.Employee;

@Repository
public class EmployeeDaoImpl extends HibernateGenericDao<Employee, EmployeeParams> implements EmployeeDao {

	@Override
	protected Criteria addRestrictions(Criteria c, EmployeeParams params) {
		CriteriaUtils.ilike(c, "name", params.getName(), MatchMode.ANYWHERE);
		return c;
	}
	
}

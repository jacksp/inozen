package com.inozen.app.employee;

import com.inozen.framework.data.hibernate.HibernateDao;

import com.inozen.app.employee.support.EmployeeParams;
import com.inozen.app.model.Employee;

public interface EmployeeDao extends HibernateDao<Employee, EmployeeParams>{

}

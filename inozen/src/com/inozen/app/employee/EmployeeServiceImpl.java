package com.inozen.app.employee;

import com.inozen.framework.service.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inozen.app.employee.support.EmployeeParams;
import com.inozen.app.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, EmployeeDao, EmployeeParams> implements EmployeeService {

	public EmployeeServiceImpl() {
		super(EmployeeDao.class);
	}

}

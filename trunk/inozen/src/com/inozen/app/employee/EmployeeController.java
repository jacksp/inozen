package com.inozen.app.employee;

import com.inozen.framework.web.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inozen.app.employee.support.EmployeeParams;
import com.inozen.app.employee.support.EmployeeRef;
import com.inozen.app.employee.support.EmployeeValidator;
import com.inozen.app.model.Employee;

@Controller
@RequestMapping("/employee/*.do")
public class EmployeeController extends GenericController<Employee, EmployeeService, EmployeeRef, EmployeeValidator, EmployeeParams>{

	protected EmployeeController() {
		super(Employee.class, EmployeeService.class, EmployeeRef.class, EmployeeValidator.class);
		this.order = "name asc";
	}
	
}
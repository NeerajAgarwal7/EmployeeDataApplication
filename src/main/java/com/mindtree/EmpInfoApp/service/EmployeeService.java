package com.mindtree.EmpInfoApp.service;

import com.mindtree.EmpInfoApp.entity.Employee;
import com.mindtree.EmpInfoApp.exceptions.ServiceExceptions;

public interface EmployeeService {
	
	public int addNewEmployee(Employee employee) throws ServiceExceptions;
	public Employee getEmployeeById(int employeeNo) throws ServiceExceptions;
	public String delteEmployeeById(int employeeNo) throws ServiceExceptions;
	public String updateExistingEmployee(Employee employee) throws ServiceExceptions;
}

package com.mindtree.EmpInfoApp.dao;

import com.mindtree.EmpInfoApp.entity.Employee;
import com.mindtree.EmpInfoApp.exceptions.DaoExceptions;

public interface EmployeeDao {
	
	public int addEmployee(Employee employee) throws DaoExceptions;
	public Employee getEmployee(int employeeNo) throws DaoExceptions;
	public void deleteEmployee(int employeeNo)  throws DaoExceptions;
	public void updateEmployee(Employee employee) throws DaoExceptions;
	
}

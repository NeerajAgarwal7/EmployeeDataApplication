package com.mindtree.EmpInfoApp.service;

import java.util.Set;

import com.mindtree.EmpInfoApp.entity.Department;
import com.mindtree.EmpInfoApp.entity.Employee;
import com.mindtree.EmpInfoApp.exceptions.ServiceExceptions;

public interface DepartmentService {

	public String addNewDepartment(Department department) throws ServiceExceptions;
	public String addEmpToDept(Employee employee, int departmentNo) throws ServiceExceptions;
	public String removeEmpFromDept(Employee employee, int departmentNo) throws ServiceExceptions;
	public Set<Employee> getAllEmployees() throws ServiceExceptions;
	
}

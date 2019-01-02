package com.mindtree.EmpInfoApp.dao;

import java.util.Set;

import com.mindtree.EmpInfoApp.entity.Department;
import com.mindtree.EmpInfoApp.entity.Employee;
import com.mindtree.EmpInfoApp.exceptions.DaoExceptions;

public interface DepartmentDao {
	
	public void createDepartment(Department dept) throws DaoExceptions;
	public void addEmployeeToDepartment(Employee emp,Department dept) throws DaoExceptions;
	public void removeEmployeeFromDepartent(Employee emp,Department dept) throws DaoExceptions;
	public Set<Employee> getEmployees() throws DaoExceptions;

}

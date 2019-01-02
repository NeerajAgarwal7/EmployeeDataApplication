package com.mindtree.EmpInfoApp.service.serviceImpl;

import com.mindtree.EmpInfoApp.dao.EmployeeDao;
import com.mindtree.EmpInfoApp.dao.hibernateImpl.EmployeeDaoHibernateImpl;
import com.mindtree.EmpInfoApp.entity.Employee;
import com.mindtree.EmpInfoApp.exceptions.DaoExceptions;
import com.mindtree.EmpInfoApp.exceptions.ServiceExceptions;
import com.mindtree.EmpInfoApp.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDao ED = new EmployeeDaoHibernateImpl();

	
	public int addNewEmployee(Employee employee) throws ServiceExceptions {
		
		int id;
		try {
			id = ED.addEmployee(employee);
		} catch (DaoExceptions e) {
			throw new ServiceExceptions(e.getMessage(),e.getCause());
		}
		
		return id;
	}

	
	public Employee getEmployeeById(int employeeNo) throws ServiceExceptions {

		Employee emp = new Employee();
		try {
			 emp = ED.getEmployee(employeeNo);
		} catch (DaoExceptions e) {
			throw new ServiceExceptions(e.getMessage(),e.getCause());
		}
		return emp;
	}

	
	public String delteEmployeeById(int employeeNo) throws ServiceExceptions {

		try {
			ED.deleteEmployee(employeeNo);
			return "Employee deleted successfully";
		} catch (DaoExceptions e) {
			throw new ServiceExceptions(e.getMessage(),e.getCause());
		}
	}

	
	public String updateExistingEmployee(Employee employee) throws ServiceExceptions {

		try {
			ED.updateEmployee(employee);
			return "Employee details updated successfully";
		} catch (DaoExceptions e) {
			throw new ServiceExceptions(e.getMessage(),e.getCause());
		}
	}

}

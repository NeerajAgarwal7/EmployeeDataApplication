package com.mindtree.EmpInfoApp.service.serviceImpl;

import java.util.Set;

import com.mindtree.EmpInfoApp.dao.DepartmentDao;
import com.mindtree.EmpInfoApp.dao.hibernateImpl.DepartmentDaoHibernateImpl;
import com.mindtree.EmpInfoApp.entity.Department;
import com.mindtree.EmpInfoApp.entity.Employee;
import com.mindtree.EmpInfoApp.exceptions.DaoExceptions;
import com.mindtree.EmpInfoApp.exceptions.ServiceExceptions;
import com.mindtree.EmpInfoApp.service.DepartmentService;
import com.mindtree.EmpInfoApp.utility.ServiceUtil;

public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDao DD = new DepartmentDaoHibernateImpl();

	public String addNewDepartment(Department department) throws ServiceExceptions {
		try {
			DD.createDepartment(department);
			return "Department created successfully";
		} catch (DaoExceptions e) {
			throw new ServiceExceptions(e.getMessage(), e.getCause());
		}catch(Exception e) {
			throw new ServiceExceptions("Cannot create department",e.getCause());
		}
	}


	public String addEmpToDept(Employee employee, int departmentNo) throws ServiceExceptions {

		try {
			Department resDep = ServiceUtil.getDeptById(departmentNo);
			DD.addEmployeeToDepartment(employee, resDep);
			return "Employee added successfully";
		} catch (DaoExceptions e) {
			throw new ServiceExceptions(e.getMessage(), e.getCause());
		}catch(Exception e) {
			throw new ServiceExceptions("Cannot add employee", e.getCause());
		}
	}


	public String removeEmpFromDept(Employee employee, int departmentNo) throws ServiceExceptions {

		try {
			Department resDep = ServiceUtil.getDeptById(departmentNo);
			DD.removeEmployeeFromDepartent(employee, resDep);
			return "Employee data removed";
		} catch (DaoExceptions e) {
			throw new ServiceExceptions(e.getMessage(), e.getCause());
		}catch(Exception e) {
			throw new ServiceExceptions("Cannot remove employee", e.getCause());
		}

	}


	public Set<Employee> getAllEmployees() throws ServiceExceptions {
		
		try {
			Set<Employee> employees = DD.getEmployees();
			return employees;
		} catch (DaoExceptions e) {
			e.printStackTrace();
			throw new ServiceExceptions(e.getMessage(), e.getCause());
		} catch(Exception e) {
			throw new ServiceExceptions("Cannot get employees", e.getCause());
		}
	}

}

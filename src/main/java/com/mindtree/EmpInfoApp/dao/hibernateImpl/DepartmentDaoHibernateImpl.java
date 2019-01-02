package com.mindtree.EmpInfoApp.dao.hibernateImpl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mindtree.EmpInfoApp.dao.DepartmentDao;
import com.mindtree.EmpInfoApp.dao.EmployeeDao;
import com.mindtree.EmpInfoApp.entity.Department;
import com.mindtree.EmpInfoApp.entity.Employee;
import com.mindtree.EmpInfoApp.exceptions.DaoExceptions;
import com.mindtree.EmpInfoApp.utility.DButil;

public class DepartmentDaoHibernateImpl implements DepartmentDao {

	public static EmployeeDao ED = new EmployeeDaoHibernateImpl();

	@Override
	public void createDepartment(Department dept) throws DaoExceptions {

		try (Session session = DButil.getSession()) {
			session.beginTransaction();
			session.save(dept);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new DaoExceptions("Cannot create department", e.getCause());
		}catch(Exception e) {
			throw new DaoExceptions("Cannot create department", e.getCause());
		}

	}

	@Override
	public void addEmployeeToDepartment(Employee emp, Department dept) throws DaoExceptions {
		emp.setDepartment(dept);
		ED.updateEmployee(emp);
	}

	@Override
	public void removeEmployeeFromDepartent(Employee emp, Department dept) throws DaoExceptions {
		emp.setDepartment(dept);
		ED.deleteEmployee(emp.getEmployeeNo());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Employee> getEmployees() throws DaoExceptions {

		try (Session session = DButil.getSession()) {
			session.beginTransaction();
			Set<Employee> resEmp = new HashSet<Employee>(session.createQuery("From Employee").list());
			session.getTransaction().commit();
			return resEmp;
		} catch (HibernateException e) {
			throw new DaoExceptions("Cannot get employee details", e.getCause());
		} catch (Exception e) {
			throw new DaoExceptions("Cannot get employee details", e.getCause());
		}

	}

}

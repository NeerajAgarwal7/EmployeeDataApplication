package com.mindtree.EmpInfoApp.dao.hibernateImpl;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mindtree.EmpInfoApp.dao.EmployeeDao;
import com.mindtree.EmpInfoApp.entity.Employee;
import com.mindtree.EmpInfoApp.exceptions.DaoExceptions;
import com.mindtree.EmpInfoApp.utility.DButil;

public class EmployeeDaoHibernateImpl implements EmployeeDao {

	Serializable id;

	@Override
	public int addEmployee(Employee employee) throws DaoExceptions {

		try (Session session = DButil.getSession()) {
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			id = session.getIdentifier(employee);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new DaoExceptions("Cannot add employee", e.getCause());
		}catch(Exception e) {
			throw new DaoExceptions("Cannot add employee", e.getCause());
		}
		return (int) id;
	}

	@Override
	public Employee getEmployee(int employeeNo) throws DaoExceptions {

		try (Session session = DButil.getSession()) {
			session.beginTransaction();
			Employee resEmp = (Employee) session.get(Employee.class, employeeNo);
			session.getTransaction().commit();
			return resEmp;
		} catch (HibernateException e) {
			throw new DaoExceptions("Cannot get employee data", e.getCause());
		}catch(Exception e) {
			throw new DaoExceptions("Cannot get employee data", e.getCause());
		}
	}

	@Override
	public void deleteEmployee(int employeeNo) throws DaoExceptions {

		try (Session session = DButil.getSession()) {
			session.beginTransaction();
			session.delete(getEmployee(employeeNo));
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new DaoExceptions("Cannot delete employee", e.getCause());
		}catch(Exception e) {
			throw new DaoExceptions("Cannot delete employee", e.getCause());
		}
	}

	@Override
	public void updateEmployee(Employee employee) throws DaoExceptions {

		try(Session session = DButil.getSession()){
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new DaoExceptions("Cannot update employee",e.getCause());
		}catch(Exception e) {
			throw new DaoExceptions("Cannot update employee",e.getCause());
		}
	}

}

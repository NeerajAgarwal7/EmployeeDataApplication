package com.mindtree.EmpInfoApp.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mindtree.EmpInfoApp.entity.Department;
import com.mindtree.EmpInfoApp.exceptions.DaoExceptions;

public class ServiceUtil {

	public static Department getDeptById(int deptNo) throws DaoExceptions {
		try (Session session = DButil.getSession()) {
			session.beginTransaction();
			Department resDep = (Department) session.get(Department.class, deptNo);
			session.getTransaction().commit();
			return resDep;
		} catch (HibernateException e) {
			throw new DaoExceptions("Cannot get department data", e.getCause());
		}
	}
	
}

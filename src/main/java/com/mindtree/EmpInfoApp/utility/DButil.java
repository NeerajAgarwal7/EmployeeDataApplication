package com.mindtree.EmpInfoApp.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.mindtree.EmpInfoApp.exceptions.DaoExceptions;

public class DButil {

	public static Session getSession() throws DaoExceptions {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			Session session = sessionFactory.openSession();
			return session;
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			throw new DaoExceptions("Cannot create connection", ex.getCause());
		}
	}
}

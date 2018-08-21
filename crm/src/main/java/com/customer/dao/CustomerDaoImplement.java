package com.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.entity.Customer;
import com.customer.entity.Test;

@Repository
public class CustomerDaoImplement implements CustomerDao {
	
	private SessionFactory factory;
	
	public CustomerDaoImplement() {
		
	}

	public List<Customer> getCustomers() {
		
		openFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query<Customer> theCustomers = session.createQuery("from Customer", Customer.class);
		
		List<Customer> customers= theCustomers.getResultList();
		session.getTransaction().commit();
		
		closeFactory();
		
		return customers;
	}

	public Customer getCustomer(int customerId) {
		
		openFactory();
		
		Session session= factory.getCurrentSession();
		session.beginTransaction();
		Customer theCustomer = session.get(Customer.class, customerId);
		
		closeFactory();
		return theCustomer;
	}

	public void addCustomer(Customer newCustomer) {
		
		openFactory();
		Session session= factory.getCurrentSession();		
		session.beginTransaction();
		
		session.saveOrUpdate(newCustomer);
		
		session.getTransaction().commit();
		closeFactory();
	}

	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}
	public void delete(int id) {
		
		openFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Customer myCustomer= session.get(Customer.class, id);
		session.delete(myCustomer);
		session.getTransaction().commit();
		
		closeFactory();
		
		
	}
	public void openFactory() {
		factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
	}
	public void closeFactory() {
		factory.close();
	}

	

}

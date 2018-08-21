package com.customer.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.customer.entity.Customer;
@Component
public interface CustomerDao {
	
	public List<Customer> getCustomers();
	public Customer getCustomer(int customerId);
	public void addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public void delete(int c);

}

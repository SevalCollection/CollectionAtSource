package com.seval.billcollector.service;

import java.util.List;

import com.seval.billcollector.model.Customer;

public interface CustomerService {

	public List<Customer> findAllCustomersByOrganization(Long organizationid);
	public Customer findCustomerById(Long customerid);
	public List<Customer> findAllCustomersByEvent(Long eventid);
	public Customer saveCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	
}

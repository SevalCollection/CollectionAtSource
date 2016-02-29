/**
 * 
 */
package com.seval.billcollector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seval.billcollector.model.Customer;
import com.seval.billcollector.repository.CustomerRepository;

/**
 * @author rajviji
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAllCustomersByOrganization(Long organizationid) {
		return customerRepository.findAllCustomersByOrganization(organizationid);
	}

	@Override
	public Customer findCustomerById(Long customerid) {
		return customerRepository.findOne(customerid);
	}

	@Override
	public List<Customer> findAllCustomersByEvent(Long eventid) {
		return customerRepository.findAllCustomersByEvent(eventid);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

}

/**
 * 
 */
package com.seval.billcollector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seval.billcollector.model.Customer;
import com.seval.billcollector.service.CustomerService;


/**
 * @author rajviji
 *
 */
	@RestController
	@RequestMapping("/api/customer")
	public class CustomerRestController {

		@Autowired
		CustomerService customerService;
		
		@RequestMapping(value="/id/{customerid}",method=RequestMethod.GET)
		public ResponseEntity<Customer> getColelctionById(@PathVariable Long customerid) {
			Customer customer = null;
			System.out.println("Calling Rest: Get  Customer By Customer-Id");
			customer = customerService.findCustomerById(customerid);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
	
		@RequestMapping(value="/org/{organizationid}",method=RequestMethod.GET)
		public ResponseEntity<List<Customer>> findAllCustomersByOrgainzation(@PathVariable Long organizationid) {
			List<Customer> customers = null;
			System.out.println("Calling Rest: Get  Customer By Customer-Id");
			customers = customerService.findAllCustomersByOrganization(organizationid);
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		}
		
		@RequestMapping(value="/event/{eventid}", method=RequestMethod.GET)
		public ResponseEntity<List<Customer>> findCustomerByEvent(@PathVariable Long eventid) {
			List<Customer> customers = null;
			System.out.println("Calling Rest: Get  All Customers for Event Service");
			customers = customerService.findAllCustomersByEvent(eventid);
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		}
		
		
		@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
			System.out.println("Calling Rest: Save New Customer");
			customerService.saveCustomer(customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		
		
		@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
			System.out.println("Calling Rest: Update Customer");
			customerService.updateCustomer(customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<HttpStatus> deleteCustomer(@RequestBody Customer customer) {
			System.out.println("Calling Rest: Delete Customer");
			customerService.deleteCustomer(customer);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
	}
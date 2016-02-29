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

import com.seval.billcollector.model.Collect;
import com.seval.billcollector.model.Customer;
import com.seval.billcollector.service.CollectionService;


/**
 * @author rajviji
 *
 */
	@RestController
	@RequestMapping("/api/collect")
	public class CollectionRestController {

		@Autowired
		CollectionService collectionService;
		

		@RequestMapping(value="/id/{collectid}",method=RequestMethod.GET)
		public ResponseEntity<Collect> getColelctionById(@PathVariable Long collectid) {
			Collect collect = null;
			System.out.println("Calling Rest: Get  Collection By Collect-id");
			collect = collectionService.findCollectionById(collectid);
			return new ResponseEntity<Collect>(collect, HttpStatus.OK);
		}
	
		@RequestMapping(value="/event/{eventid}", method=RequestMethod.GET)
		public ResponseEntity<List<Collect>> findCollectionsByEvent(@PathVariable Long eventid) {
			List<Collect> collectList = null;
			System.out.println("Calling Rest: Get  All Collections for Event Service");
			collectList = collectionService.findCollectionsByEvent(eventid);
			return new ResponseEntity<List<Collect>>(collectList, HttpStatus.OK);
		}
		
		@RequestMapping(value="/pending/event/{eventid}", method=RequestMethod.GET)
		public ResponseEntity<List<Customer>> findPendingCustomersForEvent(@PathVariable Long eventid) {
			List<Customer> customers = null;
			System.out.println("Calling Rest: Get  All Collections for Event Service");
			customers = collectionService.findAllCollectionPendingCustomers(eventid);
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		}
		
		@RequestMapping(value="/customer/{customerid}/event/{eventid}", method=RequestMethod.GET)
		public ResponseEntity<List<Collect>> findCollectionsByCustomer(@PathVariable Long customerid, @PathVariable Long eventid) {
			List<Collect> collectList = null;
			System.out.println("Calling Rest: Find Colelctions by Customer and event");
			collectList = collectionService.findCollectionsByCustomer(customerid, eventid);
			return new ResponseEntity<List<Collect>>(collectList, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collect> saveCollection(@RequestBody Collect collect) {
			System.out.println("Calling Rest: Save New Collection Transaction");
			collectionService.saveCollection(collect);
			return new ResponseEntity<Collect>(collect, HttpStatus.OK);
		}
		
		
		@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collect> updateCollection(@RequestBody Collect collect) {
			System.out.println("Calling Rest: Update Collection");
			collectionService.updateCollection(collect);
			return new ResponseEntity<Collect>(collect, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<HttpStatus> deleteCollection(@RequestBody Collect collect) {
			System.out.println("Calling Rest: Delete Collection");
			collectionService.deleteCollection(collect);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
	}
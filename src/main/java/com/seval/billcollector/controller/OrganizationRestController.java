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

import com.seval.billcollector.model.Organization;
import com.seval.billcollector.service.OrganizationService;


/**
 * @author rajviji
 *
 */
	@RestController
	@RequestMapping("/api/org")
	public class OrganizationRestController {

		@Autowired
		OrganizationService organizationService;
		
		/**
		 * @return the organizationService
		 */
		public OrganizationService getOrganizationService() {
			return organizationService;
		}

		/**
		 * @param organizationService the organizationService to set
		 */
		public void setOrganizationService(OrganizationService organizationService) {
			this.organizationService = organizationService;
		}

		@RequestMapping(value="/id/{organizationid}",method=RequestMethod.GET)
		public ResponseEntity<Organization> getOrganizationById(@PathVariable Long organizationid) {
			Organization org = null;
			System.out.println("Calling Rest: Get  Organization Service");
			org = organizationService.findOrganizationById(organizationid);
			return new ResponseEntity<Organization>(org, HttpStatus.OK);
		}
		
		@RequestMapping(value="/name/{organizationName}", method=RequestMethod.GET)
		public ResponseEntity<Organization> getOrganizationByName(@PathVariable String organizationName) {
			Organization org = null;
			System.out.println("Calling Rest: Get Organization by Name Service");
			org = organizationService.findOrganizationByName(organizationName);
			return new ResponseEntity<Organization>(org, HttpStatus.OK);
		}

	
		
		@RequestMapping(value="/all",method=RequestMethod.GET)
		public ResponseEntity<List<Organization>> findAllOrganizations() {
			List<Organization> orgList = null;
			System.out.println("Calling Rest: Get  All Organization Service");
			orgList = organizationService.findAllOrganizations();
			return new ResponseEntity<List<Organization>>(orgList, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Organization> saveOrganization(@RequestBody Organization org) {
			System.out.println("Calling Rest: Save Organization");
			organizationService.saveOrganization(org);
			return new ResponseEntity<Organization>(org, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Organization> updateOrganization(@RequestBody Organization org) {
			System.out.println("Calling Rest: Update Organization");
			organizationService.updateOrganization(org);
			return new ResponseEntity<Organization>(org, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Organization> deleteOrganization(@RequestBody Organization org) {
			System.out.println("Calling Rest: Delete Organization");
			organizationService.deleteOrganization(org);
			return new ResponseEntity<Organization>(org, HttpStatus.OK);
		}
		
	}
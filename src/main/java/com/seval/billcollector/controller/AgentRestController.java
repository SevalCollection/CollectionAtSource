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

import com.seval.billcollector.dto.RegisterAgentDTO;
import com.seval.billcollector.model.Agent;
import com.seval.billcollector.service.AgentService;


/**
 * @author rajviji
 *
 */
	@RestController
	@RequestMapping("/api/agent")
	public class AgentRestController {

		@Autowired
		AgentService registrationService;
		
		@RequestMapping(value="/register", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Agent> registerUser(@RequestBody RegisterAgentDTO registerUserDTO) {
			System.out.println("Calling Rest: Register Agent/User");
			Agent agent = registrationService.registerAgent(registerUserDTO);
			return new ResponseEntity<Agent>(agent, HttpStatus.OK);
		}
		
		@RequestMapping(value="/org/{organizationid}", method=RequestMethod.GET)
		public ResponseEntity<List<Agent>> findAgentsOfOrganization(@PathVariable Long organizationid) {
			System.out.println("Calling Rest: Find all Register Agents of Organization");
			List<Agent> agents = registrationService.findAgentsOfOrganization(organizationid);
			return new ResponseEntity<List<Agent>>(agents, HttpStatus.OK);
		}
		
	
		@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Agent> updateOrganization(@RequestBody Agent agent) {
			System.out.println("Calling Rest: Update Agent");
			registrationService.updateAgent(agent);
			return new ResponseEntity<Agent>(agent, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Agent> deleteOrganization(@RequestBody Agent agent) {
			System.out.println("Calling Rest: Delete Agent");
			registrationService.deleteAgent(agent);
			return new ResponseEntity<Agent>(agent, HttpStatus.OK);
		}
		
	}
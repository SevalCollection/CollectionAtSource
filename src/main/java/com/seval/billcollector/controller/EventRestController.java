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

import com.seval.billcollector.model.Event;
import com.seval.billcollector.service.EventService;

/**
 * @author rajviji
 *
 */
@RestController
@RequestMapping("/api/event")
public class EventRestController {
	
	@Autowired
	EventService eventService;
	
	@RequestMapping(value="/id/{eventid}",method=RequestMethod.GET)
	public ResponseEntity<Event> getColelctionById(@PathVariable Long eventid) {
		Event event = null;
		System.out.println("Calling Rest: Get  Event By Event-id");
		event = eventService.findEventById(eventid);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@RequestMapping(value="/org/{organizationid}",method=RequestMethod.GET)
	public ResponseEntity<List<Event>> getEventsByOrganization(@PathVariable Long organizationid) {
		List<Event> events = null;
		System.out.println("Calling Rest: Get  Events for Organization");
		events = eventService.findEventsByOrganization(organizationid);
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}
	
	@RequestMapping(value="/active/{organizationid}",method=RequestMethod.GET)
	public ResponseEntity<Event> getActiveEventByOrganization(@PathVariable Long organizationid) {
		Event event = null;
		System.out.println("Calling Rest: Get  Active Event for Organization");
		event = eventService.findActiveEventByOrganization(organizationid);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> saveUser(@RequestBody Event event) {
		System.out.println("Calling Rest: Save Event");
		eventService.saveEvent(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> updateUser(@RequestBody Event event) {
		System.out.println("Calling Rest: Update User");
		eventService.updateEvent(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> deleteUser(@RequestBody Event event) {
		System.out.println("Calling Rest: Delete Event");
		eventService.deleteEvent(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
}

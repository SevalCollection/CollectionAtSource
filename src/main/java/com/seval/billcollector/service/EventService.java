/**
 * 
 */
package com.seval.billcollector.service;


import java.util.List;

import com.seval.billcollector.model.Event;

/**
 * @author rajviji
 *
 */
public interface EventService {

	public Event findEventById(Long eventid);
	public List<Event> findEventsByOrganization(Long organizationid);
	public Event findActiveEventByOrganization(Long organizationid);
	
	public Event saveEvent(Event event);
	public Event updateEvent(Event event);
	public void deleteEvent(Event event);
}

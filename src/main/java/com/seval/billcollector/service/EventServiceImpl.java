/**
 * 
 */
package com.seval.billcollector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seval.billcollector.model.Event;
import com.seval.billcollector.repository.EventRepository;

/**
 * @author rajviji
 *
 */
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	@Override
	public Event findEventById(Long eventid) {
		return eventRepository.findOne(eventid);
	}

	@Override
	public List<Event> findEventsByOrganization(Long organizationid) {
		return eventRepository.findEventsByOrganization(organizationid);
	}

	@Override
	public Event findActiveEventByOrganization(Long organizationid) {
		return eventRepository.findActiveEventByOrganization(organizationid);
	}

	@Override
	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Event updateEvent(Event event) {
		if (null != event && null != event.getEventid()) {
			return eventRepository.save(event);
		}
		return null;
	}

	@Override
	public void deleteEvent(Event event) {
		eventRepository.delete(event);
		
	}
	
}

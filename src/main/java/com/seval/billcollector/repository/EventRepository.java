package com.seval.billcollector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seval.billcollector.model.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	@Query("select e from Event e where  e.organization.organizationid=?1")
	List<Event> findEventsByOrganization(Long organizationid);
	
	@Query("select e from Event e where  e.organization.organizationid=?1 and e.active=1")
	Event findActiveEventByOrganization(Long organizationid);
}
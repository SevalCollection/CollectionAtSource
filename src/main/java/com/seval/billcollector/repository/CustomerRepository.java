package com.seval.billcollector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seval.billcollector.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("select c from Customer c where  c.organization.organizationid=?1")
  	public List<Customer> findAllCustomersByOrganization(@Param("organizationid") Long organizationid);

	@Query("select c from Customer c, Event e, Collect col where   "
			+ " e.eventid=?1 and "
			+ " c.organization.organizationid=e.organization.organizationid and "
			+ " e.eventid = col.event.eventid and "
			+ " col.event.eventid = e.eventid")
	public List<Customer> findAllCustomersByEvent(Long eventid);

}
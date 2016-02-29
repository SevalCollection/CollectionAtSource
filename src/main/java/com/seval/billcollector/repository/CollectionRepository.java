package com.seval.billcollector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seval.billcollector.model.Collect;
import com.seval.billcollector.model.Customer;
@Repository
public interface CollectionRepository extends JpaRepository<Collect, Long> {

	@Query("select c from Collect c where c.customer.customerid=?1 and c.event.eventid=?2")
	public List<Collect> findCollectionsByCustomer(Long customerid, Long eventid);

	@Query("select cust from Collect col, Customer cust where col.customer.customerid = cust.customerid and "
		+ "col.collectionid in (select max(c.collectionid)  from  Collect c, Event e where c.event.eventid=?1 " 
		+ " and c.event.eventid = e.eventid and c.paymentcomplete = 0 " 
		+ " group by c.customer.customerid)")
	public List<Customer> findAllCollectionPendingCustomers(Long eventid);

	@Query("select c from Collect c where c.event.eventid=?1")
	public List<Collect> findCollectionsByEventForOrganization(Long eventid);
}

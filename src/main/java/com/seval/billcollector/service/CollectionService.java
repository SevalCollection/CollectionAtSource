package com.seval.billcollector.service;

import java.util.List;

import com.seval.billcollector.model.Collect;
import com.seval.billcollector.model.Customer;

public interface CollectionService {
	
	public List<Collect> findCollectionsByEvent(Long eventid);
	public Collect findCollectionById(Long collectid);
	public List<Collect> findCollectionsByCustomer(Long customerid, Long eventid);
	public List<Customer> findAllCollectionPendingCustomers(Long eventid);
	
	public Collect saveCollection(Collect collect);
	public Collect updateCollection(Collect collect);
	public void deleteCollection(Collect collect);
	
	
}

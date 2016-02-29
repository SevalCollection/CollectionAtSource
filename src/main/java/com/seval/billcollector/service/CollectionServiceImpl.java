package com.seval.billcollector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seval.billcollector.model.Collect;
import com.seval.billcollector.model.Customer;
import com.seval.billcollector.repository.CollectionRepository;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	CollectionRepository collectionRepository;
	
	@Override
	public List<Collect> findCollectionsByEvent(Long eventid) {
		if (null != eventid) {
			return collectionRepository.findCollectionsByEventForOrganization(eventid);
		}
			return null;
	}

	@Override
	public Collect findCollectionById(Long collectid) {
		return collectionRepository.findOne(collectid);
	}

	@Override
	public List<Collect> findCollectionsByCustomer(Long customerid, Long eventid) {
		return collectionRepository.findCollectionsByCustomer(customerid, eventid);
	}

	@Override
	public List<Customer> findAllCollectionPendingCustomers(Long eventid) {
		if (null != eventid) {
			return collectionRepository.findAllCollectionPendingCustomers(eventid);
		}
		return null;
	}

	@Override
	public Collect saveCollection(Collect collect) {
		return collectionRepository.save(collect);
	}

	@Override
	public Collect updateCollection(Collect collect) {
		if (null != collectionRepository.findOne(collect.getCollectionid())) {
			 return collectionRepository.save(collect);	
		}
		return null;
	}

	@Override
	public void deleteCollection(Collect collect) {
		collectionRepository.delete(collect);
	}

}

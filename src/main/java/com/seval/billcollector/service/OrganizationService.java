package com.seval.billcollector.service;

import java.util.List;

import com.seval.billcollector.model.Organization;

public interface OrganizationService {

		public Organization findOrganizationById(Long organizationid);
		public Organization findOrganizationByName(String organizationName);
		public List<Organization> findAllOrganizations();
		public void saveOrganization(Organization org);
		public void updateOrganization(Organization org);
		public void deleteOrganization(Organization org);
	
}

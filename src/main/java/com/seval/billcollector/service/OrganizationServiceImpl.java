/**
 * 
 */
package com.seval.billcollector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seval.billcollector.model.Organization;
import com.seval.billcollector.repository.OrganizationRepository;

/**
 * @author rajviji
 *
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	/* (non-Javadoc)
	 * @see com.seval.billcollector.service.OrganizationService#findOrganizationById(java.lang.Long)
	 */
	@Override
	public Organization findOrganizationById(Long organizationid) {
		return organizationRepository.findOne(organizationid);
	}

	/* (non-Javadoc)
	 * @see com.seval.billcollector.service.OrganizationService#findOrganizationByName(java.lang.String)
	 */
	@Override
	public Organization findOrganizationByName(String organizationName) {
		return organizationRepository.findOrganizationByName(organizationName);
	}

	/* (non-Javadoc)
	 * @see com.seval.billcollector.service.OrganizationService#findAllOrganizations()
	 */
	@Override
	public List<Organization> findAllOrganizations() {
		return organizationRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.seval.billcollector.service.OrganizationService#saveOrganization(com.seval.billcollector.model.Organization)
	 */
	@Override
	public void saveOrganization(Organization org) {
		organizationRepository.save(org);

	}

	/* (non-Javadoc)
	 * @see com.seval.billcollector.service.OrganizationService#updateOrganization(com.seval.billcollector.model.Organization)
	 */
	@Override
	public void updateOrganization(Organization org) {
		organizationRepository.save(org);
	}

	/* (non-Javadoc)
	 * @see com.seval.billcollector.service.OrganizationService#deleteOrganization(com.seval.billcollector.model.Organization)
	 */
	@Override
	public void deleteOrganization(Organization org) {
		organizationRepository.delete(org);
	}

}

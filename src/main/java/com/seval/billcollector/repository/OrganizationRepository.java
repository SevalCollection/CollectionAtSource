package com.seval.billcollector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seval.billcollector.model.Organization;


@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
	@Query("select org from Organization org where org.shortdesciption =?1")
    public Organization findOrganizationByName(String organizationName);
}
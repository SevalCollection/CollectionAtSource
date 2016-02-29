package com.seval.billcollector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seval.billcollector.model.Agent;


@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
	
	@Query("select ag from Agent ag where ag.user.username = ?1")
    public Agent findAgentByUserName(String username);

	@Query("select ag from Agent ag where ag.organization.organizationid = ?1")
	public List<Agent> findAgentsOfOrganization(Long organizationid);
}
/**
 * 
 */
package com.seval.billcollector.service;


import java.util.List;

import com.seval.billcollector.dto.RegisterAgentDTO;
import com.seval.billcollector.model.Agent;

/**
 * @author rajviji
 *
 */
public interface AgentService {

	public Agent registerAgent(RegisterAgentDTO registerUserDTO);

	public List<Agent> findAgentsOfOrganization(Long organizationid);

	public void updateAgent(Agent agent);

	public void deleteAgent(Agent agent);
}

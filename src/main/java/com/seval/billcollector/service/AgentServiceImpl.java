/**
 * 
 */
package com.seval.billcollector.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.seval.billcollector.common.CommonConstants;
import com.seval.billcollector.dto.RegisterAgentDTO;
import com.seval.billcollector.model.Address;
import com.seval.billcollector.model.Agent;
import com.seval.billcollector.model.Contact;
import com.seval.billcollector.model.Country;
import com.seval.billcollector.model.Organization;
import com.seval.billcollector.model.Role;
import com.seval.billcollector.model.User;
import com.seval.billcollector.repository.AgentRepository;

/**
 * @author rajviji
 *
 */
@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	StateService stateService;
	
	@Autowired
	AgentRepository agentRepository;
	
	/* (non-Javadoc)
	 * retrieve the information and store in appropriate  objects to store
	 */
	@Override
	public Agent registerAgent(RegisterAgentDTO registerAgentDTO) {
		User user = null;
		Agent agent = new Agent();
		user = userService.findUserByName(registerAgentDTO.getUsername());
		
		//proceed only of the username not found. If found, return username exists error
		if (user == null) {
			//User Creation
			user = new User();
			user.setUsername(registerAgentDTO.getUsername());
			user.setPassword(registerAgentDTO.getPassword());
			user.setEmail(registerAgentDTO.getEmail());
			user.setCreateTime(new Date());
			//default set user as active
			user.setEnabled(Byte.valueOf("1"));
			//process Role for the registering user
			//check the registering UserType
			String userType = CommonConstants.orgAgentRoleType;
			List<Role> roles = new ArrayList<Role>();
			Role role = new Role();
			
			if(!StringUtils.isNullOrEmpty(registerAgentDTO.getUserType())) {
				if(userType.equalsIgnoreCase(CommonConstants.orgAgentRoleType)) {
					userType = CommonConstants.orgAgentRoleType;
				} else if(userType.equalsIgnoreCase(CommonConstants.orgOwnerRoleType)) {
					userType = CommonConstants.orgOwnerRoleType;
					
					//if Admin user of ORg, user is disabled until approved
					user.setEnabled(Byte.valueOf("0"));
				}
				//process agent
				agent.setName(registerAgentDTO.getAgentName());
				
				
				//process Contact
				Contact contact = new Contact();
				contact.setEmail(registerAgentDTO.getEmail());
				contact.setLandline(registerAgentDTO.getContactLandline());
				contact.setMobile(registerAgentDTO.getContactMobile());
				
				//process address
				Address address= new Address();
				address.setAddress1(registerAgentDTO.getAddress1());
				address.setAddress2(registerAgentDTO.getStreetName());
				address.setCity(registerAgentDTO.getCity());
				Country country = countryService.findCountryByCode(registerAgentDTO.getCountryCode());
				address.setCountry(country);
				address.setDistrict(registerAgentDTO.getDistrict());
				address.setPincode(registerAgentDTO.getPinCode());
				address.setState(stateService.findStateByCode(registerAgentDTO.getStateCode()));
				
				contact.setAddress(address);
				agent.setContact(contact);
			}
			
			role = roleService.findRole(userType);
			roles.add(role);
			user.setRoles(roles);
			
			//process Organization details
			Long organizationid = registerAgentDTO.getOrganizationId();
			Organization organization = null;
			//if orgId not passed and is null, default of 0 would be added and user should be set Enabled = false (0)
			if (null == organizationid) {
				organizationid = 0L;
				user.setEnabled(Byte.valueOf("0"));
			} else {
				organization = organizationService.findOrganizationById(organizationid);
				if (organizationid == 0) {
					//if Default ORG, user is disabled until approved
					user.setEnabled(Byte.valueOf("0"));
				}
			}
			user.setOrganization(organization);
			agent.setOrganization(organization);
			agent.setUser(user);
			
			//save agent which saves user and contact details
			agentRepository.save(agent);
		}
		return agent; 
	}

	@Override
	public List<Agent> findAgentsOfOrganization(Long organizationid) {
		return agentRepository.findAgentsOfOrganization(organizationid);
	}

	@Override
	public void updateAgent(Agent agent) {
		agentRepository.save(agent);
		
	}

	@Override
	public void deleteAgent(Agent agent) {
		agentRepository.delete(agent);
		
	}

}

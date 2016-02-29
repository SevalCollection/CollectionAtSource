package com.seval.billcollector.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the organization database table.
 * 
 */
@Entity
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long organizationid;

	private String description;

	private String name;

	private String shortdesciption;

	@OneToMany(mappedBy="organization", cascade=CascadeType.ALL)
	@JsonBackReference(value="org_users")
	private List<User> users;
	
	@OneToMany(mappedBy="organization", cascade=CascadeType.ALL)
	@JsonBackReference(value="org_agents")
	private List<Agent> agents;
	

	@OneToMany(mappedBy="organization", cascade=CascadeType.ALL)
	@JsonBackReference(value="org_events")
	private List<Event> events;
	
	@OneToMany(mappedBy="organization", cascade=CascadeType.ALL)
	@JsonBackReference(value="org_customers")
	private List<Customer> customers;
	

	public Organization() {
	}

	public Long getOrganizationid() {
		return this.organizationid;
	}

	public void setOrganizationid(Long organizationid) {
		this.organizationid = organizationid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortdesciption() {
		return this.shortdesciption;
	}

	public void setShortdesciption(String shortdesciption) {
		this.shortdesciption = shortdesciption;
	}

	
	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setOrganization(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setOrganization(null);

		return user;
	}

	/**
	 * @return the agents
	 */
	public List<Agent> getAgents() {
		return agents;
	}

	/**
	 * @param agents the agents to set
	 */
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	/**
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}

	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	
}
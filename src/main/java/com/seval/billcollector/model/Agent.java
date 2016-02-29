package com.seval.billcollector.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the agent database table.
 * 
 */
@Entity
@NamedQuery(name="Agent.findAll", query="SELECT a FROM Agent a")
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long agentid;

	private String name;

	@ManyToOne
	@JoinColumn(referencedColumnName="organizationid")
	@JsonManagedReference(value="org_agent")
	@JsonIgnore
	private Organization organization;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnore
	private User user;

	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnore
	private Contact contact;

	//bi-directional many-to-one association to Collections
	@OneToMany(mappedBy="agent", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonManagedReference(value="agent_collections")
	@JsonIgnore
	private List<Collect> collections;
	
	
	public Agent() {
	}

	public Long getAgentid() {
		return this.agentid;
	}

	public void setAgentid(Long agentid) {
		this.agentid = agentid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the organization
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * @return the collections
	 */
	public List<Collect> getCollections() {
		return collections;
	}

	/**
	 * @param collections the collections to set
	 */
	public void setCollections(List<Collect> collections) {
		this.collections = collections;
	}

}
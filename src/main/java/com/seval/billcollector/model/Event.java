package com.seval.billcollector.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eventid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endtime;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date starttime;

	private Integer active;

	private Double collectionamount;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="organizationid")
	@JsonManagedReference
	@JsonIgnore
	private Organization organization;
	
	@OneToMany(mappedBy="event", cascade=CascadeType.ALL)
	@JsonBackReference(value="event-collections")
	private List<Collect> collections;
	
	public Event() {
	}


	/**
	 * @return the eventid
	 */
	public Long getEventid() {
		return eventid;
	}


	/**
	 * @param eventid the eventid to set
	 */
	public void setEventid(Long eventid) {
		this.eventid = eventid;
	}


	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
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


	/**
	 * @return the active
	 */
	public Integer getActive() {
		return active;
	}


	/**
	 * @param active the active to set
	 */
	public void setActive(Integer active) {
		this.active = active;
	}


	/**
	 * @return the collectionamount
	 */
	public Double getCollectionamount() {
		return collectionamount;
	}


	/**
	 * @param collectionamount the collectionamount to set
	 */
	public void setCollectionamount(Double collectionamount) {
		this.collectionamount = collectionamount;
	}



	
	
}
package com.seval.billcollector.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerid;

	private Integer active;

	@Lob
	private Byte[] picture;

	private String primarycontactfirstname;

	private String primarycontactlastname;

	private String secondarycontactfirstname;

	private String secondarycontactlastname;


	@ManyToOne
	@JoinColumn(referencedColumnName="organizationid")
	@JsonManagedReference(value="customer_org")
	@JsonIgnore
	private Organization organization;
	
	public Customer() {
	}

	public Long getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

	public String getPrimarycontactfirstname() {
		return this.primarycontactfirstname;
	}

	public void setPrimarycontactfirstname(String primarycontactfirstname) {
		this.primarycontactfirstname = primarycontactfirstname;
	}

	public String getPrimarycontactlastname() {
		return this.primarycontactlastname;
	}

	public void setPrimarycontactlastname(String primarycontactlastname) {
		this.primarycontactlastname = primarycontactlastname;
	}

	public String getSecondarycontactfirstname() {
		return this.secondarycontactfirstname;
	}

	public void setSecondarycontactfirstname(String secondarycontactfirstname) {
		this.secondarycontactfirstname = secondarycontactfirstname;
	}

	public String getSecondarycontactlastname() {
		return this.secondarycontactlastname;
	}

	public void setSecondarycontactlastname(String secondarycontactlastname) {
		this.secondarycontactlastname = secondarycontactlastname;
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

}
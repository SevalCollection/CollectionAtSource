package com.seval.billcollector.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the collect database table.
 * 
 */
@Entity
@NamedQuery(name="Collect.findAll", query="SELECT c FROM Collect c")
public class Collect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long collectionid;
	private Double amount;
	private byte paymentcomplete;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	@JsonBackReference(value="collections-event")
	@ManyToOne
	@JoinColumn(referencedColumnName="eventid")
	private Event event;
	
	@JsonBackReference(value="collections-agent")
	@ManyToOne
	@JoinColumn(referencedColumnName="agentid")
	private Agent agent;
	
	@OneToOne
	@JsonManagedReference
	@JsonIgnore
	private Customer customer;
	
	public Collect() {
	}

	public Long getCollectionid() {
		return this.collectionid;
	}

	public void setCollectionid(Long collectionid) {
		this.collectionid = collectionid;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * @return the agent
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the paymentcomplete
	 */
	public byte getPaymentcomplete() {
		return paymentcomplete;
	}

	/**
	 * @param paymentcomplete the paymentcomplete to set
	 */
	public void setPaymentcomplete(byte paymentcomplete) {
		this.paymentcomplete = paymentcomplete;
	}

	
	
}
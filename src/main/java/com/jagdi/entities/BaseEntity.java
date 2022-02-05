package com.jagdi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 2236762589623823626L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	Date createdOn = new Date();
	Date updatedOn = new Date();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "createdBy")
	User createdBy;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "updatedBy")
	User updatedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void updateRecord(User user) {
		this.updatedOn = new Date();
		this.updatedBy = user;
	}

}

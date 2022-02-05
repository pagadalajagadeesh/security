package com.jagdi.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Organization extends BaseEntity {

	private static final long serialVersionUID = -3248892695615965937L;

	private String name;
	@Column(unique = true)
	private String code;
	private String address;
	private String location;
	private String email;
	private String contactNumber;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contactPerson")
	private User contactPerson;
	private int establishedYear;
	@Transient
	private long contactPersonId;
	boolean active = false;
	@Transient
	List<OrganizationFiles> organizationFiles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public User getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(User contactPerson) {
		this.contactPerson = contactPerson;
	}

	public int getEstablishedYear() {
		return establishedYear;
	}

	public void setEstablishedYear(int establishedYear) {
		this.establishedYear = establishedYear;
	}

	public long getContactPersonId() {
		return contactPersonId;
	}

	public void setContactPersonId(long contactPersonId) {
		this.contactPersonId = contactPersonId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<OrganizationFiles> getOrganizationFiles() {
		return organizationFiles;
	}

	public void setOrganizationFiles(List<OrganizationFiles> organizationFiles) {
		this.organizationFiles = organizationFiles;
	}

	@Override
	public String toString() {
		return "Organization [name=" + name + ", code=" + code + ", address=" + address + ", location=" + location
				+ ", email=" + email + ", contactNumber=" + contactNumber + ", contactPerson=" + contactPerson
				+ ", establishedYear=" + establishedYear + ", contactPersonId=" + contactPersonId + ", active=" + active
				+ ", id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}

}

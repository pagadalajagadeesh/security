package com.jagdi.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrganizationFiles extends BaseFileEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organization")
	private Organization organization;

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "OrganizationFiles [organization=" + organization + ", fileName=" + fileName + ", filePath=" + filePath
				+ ", id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}
	
	
}

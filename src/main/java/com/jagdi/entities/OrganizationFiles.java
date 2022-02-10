package com.jagdi.entities;

import javax.persistence.Entity;

@Entity
public class OrganizationFiles extends BaseFileEntity {

	private static final long serialVersionUID = 6825773312318459320L;
	private long organizationId;

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public String toString() {
		return "OrganizationFiles [organizationId=" + organizationId + ", fileName=" + fileName + ", filePath="
				+ filePath + ", id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + "]";
	}

}

package com.jagdi.entities;

import javax.persistence.Entity;

@Entity
public class CompanyFiles extends BaseFileEntity {

	private static final long serialVersionUID = -4659130117196026770L;

	private long companyId;

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "CompanyFiles [companyId=" + companyId + ", fileName=" + fileName + ", filePath=" + filePath + ", id="
				+ id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}

}

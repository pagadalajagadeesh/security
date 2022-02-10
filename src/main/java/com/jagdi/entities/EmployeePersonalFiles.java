package com.jagdi.entities;

import javax.persistence.Entity;

@Entity
public class EmployeePersonalFiles extends BaseFileEntity {

	private static final long serialVersionUID = -4525228434253967270L;

	private long employeeId;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmployeePersonalFiles [employeeId=" + employeeId + ", fileName=" + fileName + ", filePath=" + filePath
				+ ", id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}

}

package com.jagdi.entities;

import javax.persistence.Entity;

@Entity
public class EmployeeProfessionalFiles extends BaseFileEntity {

	private static final long serialVersionUID = -3752250637361007152L;
	private long employeeId;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmployeeProfessionalFiles [employeeId=" + employeeId + ", fileName=" + fileName + ", filePath="
				+ filePath + ", id=" + id + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + "]";
	}

}

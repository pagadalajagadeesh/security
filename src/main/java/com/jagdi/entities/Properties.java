package com.jagdi.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Properties extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7266468951644389749L;
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Properties [name=" + name + ", value=" + value + ", id=" + id + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}

}

package com.jagdi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class ExceptionLog extends BaseEntity {

	@Lob
	@Column(length = 100000)
	private String exception;
	private String description;
	@Lob
	@Column(length = 1000000)
	private String data;

	public ExceptionLog() {
		super();
	}

	public ExceptionLog(String exception, String description, String data) {
		super();
		this.exception = exception;
		this.description = description;
		this.data = data;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}

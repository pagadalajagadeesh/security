package com.jagdi.exceptions;

public class NoDataException extends Exception {

	private static final long serialVersionUID = -1429498106334962440L;
	public String description;
	public String data;

	public NoDataException(String description, String data) {
		super();
		this.description = description;
		this.data = data;
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

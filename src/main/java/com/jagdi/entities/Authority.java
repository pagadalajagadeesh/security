package com.jagdi.entities;

import javax.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority extends BaseEntity implements GrantedAuthority {

	private static final long serialVersionUID = -7911952611626521450L;
	
	private String type;
	private String description;

	@Override
	public String getAuthority() {
		return type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Authority [type=" + type + ", description=" + description + "]";
	}
	
	

}

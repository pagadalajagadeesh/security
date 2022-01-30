package com.jagdi.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Role extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4941054493687607812L;

	private String role;
	private String description;
	boolean enabled = true;
	@OneToMany(targetEntity = Authority.class, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Authority> authority;

	public Role(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}

	public Role() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + ", description=" + description + ", enabled=" + enabled + ", authority="
				+ authority + "]";
	}
	
	

}

package com.jagdi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role extends BaseEntity implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 4941054493687607812L;

	private String role;
	private String description;
	boolean enabled = true;
	boolean permissionToCreate = true;
	boolean permissionToUpdate = false;
	boolean permissionToDelete = false;

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

	@Override
	public String getAuthority() {
		return getRole();
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

	public boolean isPermissionToCreate() {
		return permissionToCreate;
	}

	public void setPermissionToCreate(boolean permissionToCreate) {
		this.permissionToCreate = permissionToCreate;
	}

	public boolean isPermissionToUpdate() {
		return permissionToUpdate;
	}

	public void setPermissionToUpdate(boolean permissionToUpdate) {
		this.permissionToUpdate = permissionToUpdate;
	}

	public boolean isPermissionToDelete() {
		return permissionToDelete;
	}

	public void setPermissionToDelete(boolean permissionToDelete) {
		this.permissionToDelete = permissionToDelete;
	}

}

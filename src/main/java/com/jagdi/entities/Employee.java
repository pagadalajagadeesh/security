package com.jagdi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Employee extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2588123343819463229L;
	@Column(unique = true)
	private String code;
	private String officialEmailId;
	private String firstname;
	private String middlename;
	private String lastname;
	private String fathertname;
	private String spousename;
	private String username;
	private boolean active = false;
	private boolean suspended = false;
	private Date dateOfBirth;
	private String primaryContactNumber;
	private String secondaryContactNumber;
	private String personalEmailId;
	private String address;
	private String country;
	private String state;
	private String pincode;
	private String aadharNumber;
	private String pancardNumber;
	private String bloodGroup;
	private String maritalStatus;
	private String sex;
	private String employeeImage;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "company", column = @Column(name = "pastCompany")),
			@AttributeOverride(name = "desgination", column = @Column(name = "pastDesgination")),
			@AttributeOverride(name = "contactNumber", column = @Column(name = "pastContactNumber")),
			@AttributeOverride(name = "companyAddress", column = @Column(name = "pastCompanyAddress")) })
	private ExperienceHistory pastExperience;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "company", column = @Column(name = "previousCompany")),
			@AttributeOverride(name = "desgination", column = @Column(name = "previousDesgination")),
			@AttributeOverride(name = "contactNumber", column = @Column(name = "previousContactNumber")),
			@AttributeOverride(name = "companyAddress", column = @Column(name = "previousCompanyAddress")) })
	private ExperienceHistory previousExperience;
	private Employee referral1;
	private Employee referral2;
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOfficialEmailId() {
		return officialEmailId;
	}

	public void setOfficialEmailId(String officialEmailId) {
		this.officialEmailId = officialEmailId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFathertname() {
		return fathertname;
	}

	public void setFathertname(String fathertname) {
		this.fathertname = fathertname;
	}

	public String getSpousename() {
		return spousename;
	}

	public void setSpousename(String spousename) {
		this.spousename = spousename;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}

	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}

	public String getSecondaryContactNumber() {
		return secondaryContactNumber;
	}

	public void setSecondaryContactNumber(String secondaryContactNumber) {
		this.secondaryContactNumber = secondaryContactNumber;
	}

	public String getPersonalEmailId() {
		return personalEmailId;
	}

	public void setPersonalEmailId(String personalEmailId) {
		this.personalEmailId = personalEmailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmployeeImage() {
		return employeeImage;
	}

	public void setEmployeeImage(String employeeImage) {
		this.employeeImage = employeeImage;
	}

	public ExperienceHistory getPastExperience() {
		return pastExperience;
	}

	public void setPastExperience(ExperienceHistory pastExperience) {
		this.pastExperience = pastExperience;
	}

	public ExperienceHistory getPreviousExperience() {
		return previousExperience;
	}

	public void setPreviousExperience(ExperienceHistory previousExperience) {
		this.previousExperience = previousExperience;
	}

	public Employee getReferral1() {
		return referral1;
	}

	public void setReferral1(Employee referral1) {
		this.referral1 = referral1;
	}

	public Employee getReferral2() {
		return referral2;
	}

	public void setReferral2(Employee referral2) {
		this.referral2 = referral2;
	}

	@Override
	public String toString() {
		return "Employee [code=" + code + ", officialEmailId=" + officialEmailId + ", firstname=" + firstname
				+ ", middlename=" + middlename + ", lastname=" + lastname + ", fathertname=" + fathertname
				+ ", spousename=" + spousename + ", username=" + username + ", active=" + active + ", suspended="
				+ suspended + ", dateOfBirth=" + dateOfBirth + ", primaryContactNumber=" + primaryContactNumber
				+ ", secondaryContactNumber=" + secondaryContactNumber + ", personalEmailId=" + personalEmailId
				+ ", address=" + address + ", country=" + country + ", state=" + state + ", pincode=" + pincode
				+ ", aadharNumber=" + aadharNumber + ", pancardNumber=" + pancardNumber + ", bloodGroup=" + bloodGroup
				+ ", maritalStatus=" + maritalStatus + ", sex=" + sex + ", employeeImage=" + employeeImage
				+ ", pastExperience=" + pastExperience + ", previousExperience=" + previousExperience + ", referral1="
				+ referral1 + ", referral2=" + referral2 + ", id=" + id + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}

}

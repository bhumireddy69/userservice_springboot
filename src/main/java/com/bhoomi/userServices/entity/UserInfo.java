package com.bhoomi.userServices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Entity class flow UserInfo table
 * 
 * @filename UserInfo.java
 *
 * @author Chaitanya Bhoomireddy
 * 
 */
@Entity
public class UserInfo {
	
	@Id
	@Column(name="UserID")
	private int userID;

	@Column(name="FirstName")
	private String firstName;	
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="Phone")
	private String phone;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name="Age")
	private int age;
	
	
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name="EMail")
	private String eMail;	
	
	@Column(name="DateCreated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;	
	
	@Column(name="LastUpdated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;

}

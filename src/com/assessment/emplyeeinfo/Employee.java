package com.assessment.emplyeeinfo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Employee {
	@Id @GeneratedValue
	@Column(name = "Id")
	private int id;
	
	@Column(name = "FirstName")
	private String firstname;
	
	@Column(name = "LastName")
	private String lastname;
	
	@Column(name = "ContactNumber")
	private long contactno;
	
	@Column(name = "Address")
	private String address;
	
	public Employee(String firstname, String lastname, long contactno, String address){
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactno = contactno;
		this.address = address;
	}
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	public String getFirstname(){
		return firstname;
	}
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	public String getLastname(){
		return lastname;
	}
	public void setContactno(long contactno){
		this.contactno = contactno;
	}
	public long getContactno(){
		return contactno;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
}

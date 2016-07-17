package com.assessment.emplyeeinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Information")
public class InternEmployee extends Employee {
	
	@Column(name = "Salary")
	private double salary;
	
	@Column(name = "Employee_Type")
	private String employeetype;
	public InternEmployee(String firstname, String lastname, long contactno, String address,double salary, String employeetype){
		super(firstname,lastname,contactno,address);
		this.salary = salary;
		this.employeetype = employeetype;
	}
	
	public void setHourlysalary(double salary){
		this.salary = salary;
	}
	public double getHourlysalary(){
		return salary;
	}
	public void setEmployeetype(String employeetype){
		this.employeetype = employeetype;
	}
	public String getEmployeetype(){
		return employeetype;
	}
}

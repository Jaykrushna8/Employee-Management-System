package com.assessment.emplyeeinfo;

public class EmployeeType {
	public Employee getType(String fname, String lname, String address, long contactno, double salary,String employeetype){
		
		if(employeetype.equalsIgnoreCase("FULLTIME")){
			return new FulltimeEmployee(fname,lname,contactno,address,salary,employeetype);
		}
		else if(employeetype.equalsIgnoreCase("PARTTIME")){
			return new ParttimeEmployee(fname,lname,contactno,address,salary,employeetype);
		}
		else if(employeetype.equalsIgnoreCase("INTERN")){
			return new InternEmployee(fname,lname,contactno,address,salary,employeetype);
		}
		return null;
	}
}

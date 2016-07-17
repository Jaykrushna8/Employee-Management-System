package com.assessment.emplyeeinfo;

import java.util.HashMap;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDetails {
	private static SessionFactory factory; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   try{
				factory = new Configuration().configure().buildSessionFactory();
	       }
		   catch (Throwable e) { 
	    	    System.err.println("Error creation for sessionFactory object." + e);
	            throw new ExceptionInInitializerError(e); 
	       }
		
		   EmployeeDetails emp = new EmployeeDetails();
		
		   System.out.println("Insert a new Employee into database");
	       Integer emp1 = emp.insertEmployee("Sam", "Shah", "California", 216575123, 4000, "Fulltime");
	       Integer emp2 = emp.insertEmployee("Akky", "Kumar" ,"Florida", 515865968,45, "Parttime");
	       Integer emp3 = emp.insertEmployee("Abhay", "Patel","Newyork", 875876925 ,25,"Intern");
	       
	       System.out.println("Get all Employees information from the database");
	       emp.getallEmployees();
	       System.out.println("--------------*************---------------");
	       
	       System.out.println("Edit Employee Salary & Contact Number in the database");
	       emp.editEmployee(emp1, 5000,874852963);
	       System.out.println("After updation,get all Employees information from the database");
	       emp.getallEmployees();
	       System.out.println("--------------*************---------------");
	       
	       System.out.println("Remove an Employee from the database");
	       emp.removeEmployee(emp2);
	       System.out.println("After deletion,get all Employees information from the database");
	       emp.getallEmployees();
	       System.out.println("--------------*************---------------");
	       
	}
	/* Function to insert a new employee in the database */
	   public Integer insertEmployee(String fname, String lname, String address, long contactno, double salary, String type){
		  Transaction trans = null;
		  Session session = factory.openSession();
	      Integer empid = null;
	      try{
	    	 trans = session.beginTransaction();
	         EmployeeType emptype = new EmployeeType();
	         Employee employee = emptype.getType(fname,lname,address,contactno,salary,type);
	         empid = (Integer) session.save(employee); 
	         trans.commit();
	         session.close();
	      }
	      catch (HibernateException e) {
	         e.printStackTrace(); 
	      }
	      return empid;
	   }
	  
	   /* Function to Edit an Employee Salary & Contact Number in the database */
	   public void editEmployee(Integer Empid, int salary, long contactno ){
		  Transaction trans = null;
		  Session session = factory.openSession();
	      try{
	         trans = session.beginTransaction();
	         String sql = "UPDATE Employee_Information set Salary = '" + salary + "', ContactNumber = '"+ contactno + "' WHERE Id = '" + Empid +"'";
	         SQLQuery sqlQry = session.createSQLQuery(sql);
	         sqlQry.executeUpdate();
	         trans.commit();
	         session.close();
	      }
	      catch (HibernateException e) {
	         e.printStackTrace();  
	      }
	   }
	   /* Function to Delete an employee from the database */
	   public void removeEmployee(Integer Empid){
		  Transaction trans = null;
		  Session session = factory.openSession();
	      try{
	         trans = session.beginTransaction();
	         String sql = "DELETE FROM Employee_Information WHERE Id = '" + Empid + "'" ;
	         SQLQuery sqlQry = session.createSQLQuery(sql);
	         sqlQry.executeUpdate();
	         trans.commit();
	         session.close();
	      }
	      catch (HibernateException e) {
	         e.printStackTrace();
	      }
	   }
	   /* Function to get all the existing employees from the database */
	   public void getallEmployees( ){
		  Transaction trans = null;
		  Session session = factory.openSession();
	      try{
	         trans = session.beginTransaction();
	         String sql = "SELECT * FROM Employee_Information";
	         SQLQuery sqlQry = session.createSQLQuery(sql);
	         sqlQry.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	         List info = sqlQry.list();

	         for(Object obj : info)
	         {
	            HashMap temp = (HashMap)obj;
	            System.out.println("First Name: " + temp.get("FirstName")); 
	            System.out.println("Last Name: " + temp.get("LastName"));
	            System.out.println("Contact Number: " + temp.get("ContactNumber"));
	            System.out.println("Address: " + temp.get("Address"));
	            System.out.println("Salary: " + temp.get("Salary")); 
	            System.out.println("Employment Type:"+temp.get("Employee_Type"));
	            System.out.println();
	         }
	         trans.commit();
	         session.close();
	      }
	      catch (HibernateException e) {
	         e.printStackTrace(); 
	      }
	   }
}

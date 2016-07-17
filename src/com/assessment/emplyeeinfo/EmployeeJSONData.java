package com.assessment.emplyeeinfo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class EmployeeJSONData {
	public static void main(String[] args){
		EmployeeJSONData emp = new EmployeeJSONData();
		emp.addEmployeeJSONData();
		System.out.println("Employee Data Successfully Store in the database");
		emp.writeEmployeeDataInJSON();
		System.out.println("Employee Data Successfully Store in the JSON File");
	}
	/* Function to Store a new employee in the database by reading a JSON file */
	public void addEmployeeJSONData(){
		JSONParser parser = new JSONParser();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagement","root","root");
			
			Object obj = parser.parse(new FileReader("C:\\Users\\Jaykrishna\\workspace\\Employee Management\\EmployeeData.json"));
			JSONArray array = (JSONArray) obj;
			
			for(int i=0;i<array.size();i++){
				JSONObject jsonObject = (JSONObject) array.get(i);	
				String firstname = (String) jsonObject.get("firstname");
				String lastname = (String) jsonObject.get("lastname");
				String address = (String) jsonObject.get("address");
				String employeetype = (String) jsonObject.get("employeetype");
				
				String sql = "INSERT INTO Employee_Information(Id,FirstName,LastName,ContactNumber,Address,Salary,Employee_Type) values ('" + 
				jsonObject.get("Id") + "','" + firstname + "','" + lastname + "','" + jsonObject.get("contactno") + "','"+ address + "','" + jsonObject.get("salary") + "','"+ employeetype +"')";
				
				Statement stmt = connect.createStatement();
				stmt.executeUpdate(sql);
				
			}
			connect.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/* Function to export existing employees to a JSON file */
	@SuppressWarnings("unchecked")
	public void writeEmployeeDataInJSON(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagement","root","root");
			String sql ="SELECT * FROM Employee_Information";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		
			JSONObject obj = new JSONObject();
		
			List l1 = new LinkedList();
			while(rs.next()){
				Map m1=  new HashMap();
				m1.put("firstname", rs.getString("FirstName"));
			    m1.put("lastname", rs.getString("LastName"));
			    m1.put("contactno", rs.getInt("ContactNumber"));
			    m1.put("address", rs.getString("Address"));
			    m1.put("salary", rs.getDouble("Salary"));
			    m1.put("employeetype", rs.getString("Employee_Type"));
			    m1.put("Id", rs.getInt("Id"));
			    l1.add(m1);
			}
		
			File file=new File("C:\\Users\\Jaykrishna\\workspace\\Employee Management\\EmployeeData1.json");      
			file.createNewFile();             
			FileWriter fileWriter = new FileWriter(file);
			String jsonString = JSONValue.toJSONString(l1);
			fileWriter.write(jsonString);
			fileWriter.flush();
			fileWriter.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

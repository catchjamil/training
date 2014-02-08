package com.sd.training.struts2.util;

import java.sql.*;
public class DatabaseUtil {

	public static Connection getDBConnection()
	{
	Connection conn = null;
	  String url = "jdbc:mysql://localhost:3306/";
	  String dbName = "swiftdb";
	 // String driver = "com.mysql.jdbc.Driver";
	  String userName = "root"; 
	  String password = "root";
	  
	 
	  
	  try{
	 // Class.forName(driver).newInstance();
	  conn = DriverManager.getConnection(url+dbName,userName,password);
	  System.out.println("Connected to the database");
	  }catch(ArithmeticException e){
		  
	  }catch(Exception e){
		  
	  } 
	  return conn;
	}
	public static void closeConnection(Connection conn){
		try{
		  if(conn != null)	
		  conn.close();
		  System.out.println("Database connection close");
		  } catch (Exception e) {
		  e.printStackTrace();
		  }
		}
	
	//public static void main(String[] args) {
		//getDBConnection();
	//}
}

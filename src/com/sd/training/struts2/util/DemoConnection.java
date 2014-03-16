package com.sd.training.struts2.util;

import java.sql.*;

public class DemoConnection {
	public static void main(String[] args){
		try{
			Connection con1=DatabaseUtil.getDBConnection();
			Statement stm=con1.createStatement();
			//int count=
				stm.execute("create table show(name varchar(20),branch varchar(20))");
			//System.out.println("No of row affected" +count );
			ResultSet rs=stm.executeQuery("select *from student");
			while(rs.next()){
				System.out.print(rs.getString("name"));
				System.out.print("  "+rs.getString("roll"));
				System.out.println(" " +rs.getString("branch"));
			}
			DatabaseUtil.closeConnection(con1);
			
		}catch(Exception e){
			System.out.println("Error in DBConnection" +e);
		}
	}
	
}

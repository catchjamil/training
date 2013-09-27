package com.sd.training.struts2.zeayul;

import java.sql.*;
public class JdbcDemo {
	public static void main(String[] args){
		
		
		try{
		Connection conn=MyConDb.conJdbc();
		Statement stm=conn.createStatement();
		ResultSet rs=stm.executeQuery("select * from student ");
		System.out.println("Name        Roll No.   Department");
		while(rs.next()){
			System.out.print(rs.getString("name"));
			System.out.print("     "+rs.getString("roll_no"));
			System.out.println("    "+rs.getString("branch"));
		}
		MyConDb.closeJdbc(conn);
		System.out.println("DB connection Close");
		}
		catch(Exception e){
			System.out.println("DB connection Error"+ e);
		}
	
			
		
	}
		
}



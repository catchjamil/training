package com.sd.training.struts2.zeayul;
import java.sql.*;
public class JdbcDemo2 {
   public static void main(String args[]){
	   
	   try{
		   Connection conn=MyConDb.conJdbc();
		   Statement stmt= conn.createStatement();
		   ResultSet rs = stmt.executeQuery("select * from user_info");
		   System.out.println("Id_No       UserName.     Password       First_Name");
		   while(rs.next()){
			   System.out.print(rs.getString("id"));
				System.out.print("             "+rs.getString("username"));
				System.out.println("        "+rs.getString("password"));
				//System.out.println("    "+rs.getString("first_name"));
		   }
		   MyConDb.closeJdbc(conn);
			System.out.println("DB connection Close");
			}
			catch(Exception e){
				System.out.println("DB connection Error"+ e);
			}
	   }
	   
   }



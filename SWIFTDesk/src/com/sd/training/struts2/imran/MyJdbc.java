package com.sd.training.struts2.imran;


import java.sql.*;

public class MyJdbc {
	public static void main(String[] args){
		try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String str="select* from Table1";
				//String str1="select* from Student1";
				Connection con=DriverManager.getConnection("jdbc:odbc:DataBase1");
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery(str);

		
			while(rs.next()){
				System.out.print(rs.getString(1));
				System.out.println(rs.getString(2));
				/*System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));*/
				
			}
			
		}
		catch(Exception e){
			
		}
		//catch(Exception e){
			
		//}
	}

}




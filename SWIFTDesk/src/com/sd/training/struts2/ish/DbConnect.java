package com.sd.training.struts2.ish;


	import java.sql.*;

	class DbConnect
	{
	 public static void main(String args[]) throws Exception
	 {
	        String name,desg,sql;
	        int dept, id,salary;


	        try
	        {
	          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        }catch(ClassNotFoundException ex){
	        
			}
		
	        try
	        {
				Connection con;
				String url="jdbc:odbc:idsn";
				con=DriverManager.getConnection(url,"hr","hrpassword");
				Statement stmt=con.createStatement();
				
				
				ResultSet rs=stmt.executeQuery(" select * from operator ");
				System.out.println("Connection is successful");
				while(rs.next())
				{ 
					/*System.out.println(rs.getInt(1));
	                System.out.println(rs.getString(2));
	                System.out.println(rs.getString(3));
	                System.out.println(rs.getInt(4));
					System.out.println(rs.getInt(5));*/
						id=rs.getInt(1);
						name=rs.getString(2);
						desg=rs.getString(3);
						salary=rs.getInt(4);
						dept=rs.getInt(5);
						System.out.println(id+"\t"+name+"\t"+desg+"\t"+salary+"\t"+dept);
				}
				con.close();
			}catch(SQLException ex){}
		}
	}


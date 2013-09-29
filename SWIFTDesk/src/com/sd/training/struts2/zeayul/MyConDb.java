package com.sd.training.struts2.zeayul;

import java.sql.*;
public class MyConDb {
	
	static Connection conJdbc() throws SQLException{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:9999/swiftdb","myuser","123456");
		return con;
	}
	static void closeJdbc(Connection con) throws SQLException{
		con.close();
	}
	

}

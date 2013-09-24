package com.sd.training.struts2.imran;
import java.sql.*; // Use classes in java.sql package
//JDK 7 and above
public class Demo15{ // Save as "JdbcSelectTest.java"
public static void main(String[] args) {
try {
//Step 1: Allocate a database "Connection" object
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:9999/operator", "ish", "123456"); // MySQL
//Connection conn = DriverManager.getConnection(
//"jdbc:odbc:ebookshopODBC"); // Access
//Step 2: Allocate a "Statement" object in the Connection
Statement stmt = conn.createStatement();
//Step 3: Execute a SQL SELECT query, the query result
//is returned in a "ResultSet" object.

System.out.println("<<<<<<<<<<----Student database---->>>>>>>>>> "); // Echo For debugging
System.out.println();
ResultSet rset = stmt.executeQuery("select * from  student");
//Step 4: Process the ResultSet by scrolling the cursor forward via next().
//For each row, retrieve the contents of the cells with getXxx(columnName).
System.out.println("The records selected are:");
System.out.println("Name     roll    Branch");
System.out.println("-------------------------------");
int rowCount = 0;
while(rset.next()) { // Move the cursor to the next row
String title = rset.getString("name");
String roll = rset.getString("roll_no");
String branch = rset.getString("branch");
System.out.println(title + ", " + roll + ", " + branch);
++rowCount;
}
System.out.println("Total number of records = " + rowCount);
} catch(SQLException ex) {
ex.printStackTrace();
}
//Step 5: Close the resources - Done automatically by try-with-resources
}
}

package com.sd.training.struts2.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sd.training.struts2.util.DatabaseUtil;
import com.sd.training.struts2.util.HibernateUtil;

public class MainDemo {
    public static void main(String[] args) {
Connection dbConnection = DatabaseUtil.getDBConnection();
		
	    try { 
			  
			 Statement createStatement = dbConnection.createStatement();
			 ResultSet executeQuery = createStatement.executeQuery("select max(accountnumber) from account");
			 executeQuery.first();
			 System.out.println(executeQuery.getLong(1));
    		 		//System.out.println("Account"+ executeQuery.getString("accountnumber"));
    			}catch(Exception e){
    				System.out.println("Error ................"+e+e.getStackTrace());
    			}
	}

}

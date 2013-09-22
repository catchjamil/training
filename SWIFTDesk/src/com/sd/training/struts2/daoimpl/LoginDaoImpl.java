package com.sd.training.struts2.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.sd.training.struts2.bean.User;
import com.sd.training.struts2.dao.LoginDao;
import com.sd.training.struts2.util.DatabaseUtil;

public class LoginDaoImpl implements LoginDao {

	private static User userByName;

	@Override
	public User getUserByName(String uname) {

		User user = new User();
		Connection dbConnection = DatabaseUtil.getDBConnection();
		
		  try { Statement createStatement = dbConnection.createStatement();
		  ResultSet executeQuery = createStatement.executeQuery(
		  "SELECT username, password, first_name FROM user_info where username='"+uname+"'"); 
		  
		  if(executeQuery.first()){ 
		  user = new User();
		  user.setUname(executeQuery.getString(1));
		  user.setPassword(executeQuery.getString(2));
		  user.setFirstName(executeQuery.getString(3));
		  }else{
			  System.out.println("Invalid User : "+executeQuery);
		  } 
		  } catch (SQLException e) { // TODO Auto-generated catch block
			  e.printStackTrace(); 
		  }finally{
			  DatabaseUtil.closeConnection(dbConnection);
		  }
		 
	/*	user.setUname(uname);
	Map<String, String> userInfo = getUserInfo();
		user.setPassword(userInfo.get(uname));*/
		return user;
	}

	private Map<String, String> getUserInfo() {
		Map<String, String> userInfo = new HashMap<String, String>();
		userInfo.put("user0", "password0");
		userInfo.put("user1", "password1");
		userInfo.put("user2", "password2");
		userInfo.put("user3", "password3");
		userInfo.put("user4", "password4");
		return userInfo;
	}
}
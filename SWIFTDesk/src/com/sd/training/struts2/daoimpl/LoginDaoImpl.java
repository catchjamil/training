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

	@Override
	public User getUserByName(String uname) {

	//	Connection dbConnection = DatabaseUtil.getDBConnection();
		User user = new User();
		/*
		 * try { Statement createStatement = dbConnection.createStatement();
		 * ResultSet executeQuery = createStatement.executeQuery(
		 * "SELECT user_id, name, email, password FROM user_info where name="
		 * +uname); while(executeQuery.first()){ user = new User();
		 * user.setUname(executeQuery.getString(1));
		 * user.setPassword(executeQuery.getString(2));
		 * 
		 * } } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		user.setUname(uname);
		user.setPassword(getUserInfo().get(uname));
		return user;
	}

	private Map<String, String> getUserInfo() {
		Map<String, String> userInfo = new HashMap<String, String>();
		userInfo.put("admin", "admin");
		userInfo.put("user1", "admin");
		userInfo.put("user2", "admin");
		userInfo.put("user3", "admin");
		userInfo.put("user4", "admin");
		return userInfo;
	}
}
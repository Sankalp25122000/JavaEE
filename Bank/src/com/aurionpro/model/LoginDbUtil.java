package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class LoginDbUtil {
	private DataSource dataSource;
	
	public LoginDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public User checkUserTable(User user) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		User isUser = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select * from user where username=? and password=?;";
			stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());

			result = stmt.executeQuery();
			if (result.next()) {
				int userId = result.getInt("user_id");
				String fname = result.getString("fname");
				String lname = result.getString("lname");
				String username = result.getString("username");
				String password = result.getString("password");
				double balance = result.getDouble("balance");
				isUser = new User(userId,fname,lname, username, password , balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, result);
		}
		return isUser;
		
	}

	private void close(Connection con, PreparedStatement stmt, ResultSet result) {
		try {
			if (con != null) {
				con.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public Admin checkAdminTable(Admin admin) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		Admin isAdmin = null;
		
		System.out.println(admin);
		try {
			con = dataSource.getConnection();
			String sql = "select * from admin where username=? and password=?;";
			stmt = con.prepareStatement(sql);

//			System.out.println(sql);
			stmt.setString(1, admin.getUsername());
			stmt.setString(2, admin.getPassword());

			result = stmt.executeQuery();
			System.out.println(result);

			if (result.next()) {
				int id = result.getInt("id");
				String username = result.getString("username");
				String password = result.getString("password");
			    isAdmin = new Admin(id,username,password);
			}
			System.out.println(isAdmin);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, result);
		}
		return isAdmin;
	}

}

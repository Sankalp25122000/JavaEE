package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class AdminDbUtil {
	private DataSource dataSource;

	public AdminDbUtil (DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Admin> getAdminByUsername(String adminUsername,String adminPassword) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dataSource.getConnection();

			String sql = "Select * from admin where username ? and password ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, "%" + adminUsername + "%");
			myStmt.setString(2, "%" + adminPassword + "%");

			myRs = myStmt.executeQuery();

			List<Admin> adminList = new ArrayList<Admin>();
			while (myRs.next()) {
				int id = myRs.getInt("id");
				String username = myRs.getString("username");
				String password = myRs.getString("password");
				adminList.add(new Admin(id, username, password));
			}
			return adminList;

		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) {
		try {
			if (myConn != null) {
				myConn.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myRs != null) {
				myRs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		
	}
}
}

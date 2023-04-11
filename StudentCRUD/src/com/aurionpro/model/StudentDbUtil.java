package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	private DataSource dataSource;

	public StudentDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void addStudent(Student tempStudent) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();

			String sql = "insert into student(FirstName,LastName,Email) values(?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, tempStudent.getFirstName());
			myStmt.setString(2, tempStudent.getLastName());
			myStmt.setString(3, tempStudent.getEmail());
			myStmt.execute();

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateStudent(Student tempStudent) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "update student set FirstName = ?,LastName= ?,Email= ? where ID= ?";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, tempStudent.getFirstName());
			myStmt.setString(2, tempStudent.getLastName());
			myStmt.setString(3, tempStudent.getEmail());
			myStmt.setInt(4, tempStudent.getId());

			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, null);
		}
	}

	public Student getStudentById(int id) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dataSource.getConnection();
			String sql = "select * from student where id = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			myRs = myStmt.executeQuery();

			if (myRs.next()) {
				String firstName = myRs.getString("FirstName");
				String lastName = myRs.getString("LastName");
				String email = myRs.getString("Email");
				Student student = new Student(id, firstName, lastName, email);
				System.out.println(student);
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, myRs);
		}

		return null;
	}

	public List<Student> getAllStudents() throws Exception {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dataSource.getConnection();

			String sql = "Select * from student";
			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);
			List<Student> studentList = new ArrayList<Student>();
			while (myRs.next()) {
				int id = myRs.getInt("ID");
				String firstName = myRs.getString("FirstName");
				String lastName = myRs.getString("LastName");
				String email = myRs.getString("Email");
				studentList.add(new Student(id, firstName, lastName, email));
			}
			return studentList;

		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
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

	public void deleteStudent(int id) {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = dataSource.getConnection();
			String sql = "delete from student where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			myStmt.execute();

			System.out.println("Deleted");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, null);
		}
	}

	public List<Student> getStudentByName(String name) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dataSource.getConnection();

			String sql = "Select * from student where firstName like ? or lastName like ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, "%" + name + "%");
			myStmt.setString(2, "%" + name + "%");

			myRs = myStmt.executeQuery();

			List<Student> studentList = new ArrayList<Student>();
			while (myRs.next()) {
				int id = myRs.getInt("ID");
				String firstName = myRs.getString("FirstName");
				String lastName = myRs.getString("LastName");
				String email = myRs.getString("Email");
				studentList.add(new Student(id, firstName, lastName, email));
			}
			return studentList;

		} finally {
			close(myConn, myStmt, myRs);
		}
	}

}

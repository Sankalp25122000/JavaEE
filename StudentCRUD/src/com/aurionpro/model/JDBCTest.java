package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



@WebServlet("/JDBCTest")
public class JDBCTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public JDBCTest() {
    	super();
    }
  
    @Resource(name="jdbc/StudentDb")
    private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//step 1 - Set up the prinwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		//step 2 - Get a connection to the database
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			//step 3 - Create a SQL statements
			String sql = "Select * from student";
			myStmt = myConn.createStatement();
			
			//Step 4 - Execute SQL query
			myRs = myStmt.executeQuery(sql);
			List<Student> studentList = new ArrayList<Student>();
			while(myRs.next()) {
				int id = myRs.getInt("ID");
				String firstName = myRs.getString("FirstName");
				String lastName = myRs.getString("LastName");
				String email = myRs.getString("Email");
			    studentList.add(new Student(id, firstName, lastName, email));
			}
			
			request.setAttribute("students",studentList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list-student.jsp");
			dispatcher.forward(request, response);
		}catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.aurionpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aurionpro.model.Student;
import com.aurionpro.model.StudentDbUtil;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDbUtil studentDbUtil;

	public StudentController() {
		super();
	}

	@Resource(name = "jdbc/StudentDb")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		studentDbUtil = new StudentDbUtil(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		if (command == null) {
			command = "LIST";
		}
		try {
			switch (command) {
			case "ADD":
				addStudents(request, response);
				break;

			case "LIST":
				listStudents(request, response);
				break;

			case "LOAD":
				loadStudents(request, response);
				break;

			case "UPDATE":
				updateStudents(request, response);
				break;

			case "DELETE":
				deleteStudent(request, response);
				break;
				
			case "SEARCH":
				searchStudent(request,response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
       String name = request.getParameter("name");
       List<Student> students = studentDbUtil.getStudentByName(name);
       request.setAttribute("students", students);
       RequestDispatcher dispatcher = request.getRequestDispatcher("list-student.jsp");
       dispatcher.forward(request, response);
       
       
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("studentId"));
//		System.out.println(id);
		studentDbUtil.deleteStudent(id);
		response.sendRedirect(request.getContextPath() + "/StudentController");
	}

	private void updateStudents(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Inside update method..");
		int id = Integer.parseInt(request.getParameter("student_id"));
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		Student tempStudent = new Student(id, firstName, lastName, email);
//		System.out.println(tempStudent);
		studentDbUtil.updateStudent(tempStudent);
		response.sendRedirect(request.getContextPath() + "/StudentController");
	}

	private void loadStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Inside load method");
		int id = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentDbUtil.getStudentById(id);
		request.setAttribute("theStudent", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-student.jsp");
		dispatcher.forward(request, response);
	}

	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Student tempStudent = new Student(firstName, lastName, email);
		List<Student> students = studentDbUtil.getAllStudents();
		// Easy way but this allows the same value while insertion but not while
		// refreshing the page
//		studentDbUtil.addStudent(tempStudent);

		// Manual way but this will add the same values while refreshing but not on
		// insertion
		boolean isStudentPresent = false;
		if (students != null) {
			for (Student x : students) {
				if ((x.getFirstName().equals(firstName)) && x.getLastName().equals(lastName)
						&& x.getEmail().equals(email)) {
					isStudentPresent = true;
				}

			}
		}
		if (!isStudentPresent) {
			studentDbUtil.addStudent(tempStudent);
		}
		response.sendRedirect(request.getContextPath() + "/StudentController");
//	listStudents(request, response);

	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Student> students = studentDbUtil.getAllStudents();
		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-student.jsp");
		dispatcher.forward(request, response);
	}

}

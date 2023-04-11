package com.aurionpro.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.aurionpro.model.Admin;
import com.aurionpro.model.LoginDbUtil;
import com.aurionpro.model.User;
import com.aurionpro.model.UserDbUtil;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginDbUtil loginDbUtil;

	public LoginController() {
		super();
	}
	@Resource(name = "jdbc/bankdb")
	private DataSource datasource;

	@Override
	public void init() throws ServletException {
		super.init();
		loginDbUtil = new LoginDbUtil(datasource);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userType = request.getParameter("userType");
		
		if (userType == null) {
			userType = "LOGIN";
		}
		
		try {
			switch (userType) {

			case "ADMIN":
				adminCheck(request, response);
				break;

			case "USER":
				userCheck(request, response);
				break;
				
			case "LOGIN":
				RequestDispatcher dispature = request.getRequestDispatcher("login.jsp");
				dispature.forward(request, response);
			}
			System.out.println(userType);  //to check the user
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void userCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		User isUser = loginDbUtil.checkUserTable(user);
		System.out.println(isUser);

		if (isUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("isUser", isUser);

			request.setAttribute("balance", isUser.getBalance());
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-dashboard.jsp");
			dispatcher.forward(request, response);
		} else {
			String msg = "Invalid credentials...";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void adminCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = new Admin(username, password);
		System.out.println(admin);
		Admin isAdmin = loginDbUtil.checkAdminTable(admin);
		System.out.println(isAdmin);

		if (isAdmin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("isAdmin", isAdmin);

			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-dashboard.jsp");
			dispatcher.forward(request, response);
		} else {
			String msg = "Invalid credentials...";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

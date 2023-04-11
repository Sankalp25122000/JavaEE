package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.aurionpro.model.Transactions;
import com.aurionpro.model.User;
import com.aurionpro.model.UserDbUtil;


@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
  private static final long serialVersionUID = 1L;
       

    public AdminController() {
        super();
    }

    @Resource(name = "jdbc/bankdb")
  private DataSource dataSource;

  UserDbUtil userDbUtil;
  
  @Override
  public void init() throws ServletException {
    super.init();

    userDbUtil = new UserDbUtil(dataSource);
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String command = request.getParameter("command");
    System.out.println(command);

    HttpSession session = request.getSession();
    Object admin = (Object) session.getAttribute("isAdmin");

    if (admin != null) {
      switch (command) {
      case "userDetail":
        listUsers(request, response);
        break;
      case "search":
        searchUser(request, response);
        break;
      case "add":
        addUser(request, response);
        break;
      case "delete":
        deleteUser(request, response);
        break;
      case "userTransaction":
        printUserTrans(request, response);
        break;
      case "searchadminpassbook":
        searchAdmin(request, response);
        break;
      case "logout":
        RequestDispatcher dispature = request.getRequestDispatcher("login.jsp");
        dispature.forward(request, response);
      }
    } else {
      response.sendRedirect("login.jsp");
    }
  
  }

  
  private void searchAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int acc_no = Integer.parseInt(request.getParameter("searchadmin"));
    System.out.println(acc_no);


    List<Transactions> transactions = userDbUtil.searchPassbookUser(acc_no);
    System.out.println(transactions);

    if (transactions.isEmpty()) {
      String msg2 = "Transaction not found !!";
      request.setAttribute("msg2", msg2);
    } else {
      request.setAttribute("listPassbook", transactions);
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher("transaction.jsp");
    dispatcher.forward(request, response);
  }

  private void printUserTrans(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("search"));

    List<User> user = userDbUtil.searchUser(id);

    System.out.println(user.isEmpty());
    if (user.isEmpty()) {
      String msg1 = "User not found !!";
      request.setAttribute("msg1", msg1);
    } else {
      request.setAttribute("listUser", user);
//      System.out.println("Searched students:" + user);
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher("user-details.jsp");
    dispatcher.forward(request, response);
  }

  private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));
//    System.out.println("acc_no:" + acc_no);
    userDbUtil.deleteUser(id);
    listUsers(request, response);
  }
  private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int userId = Integer.parseInt(request.getParameter("user_id"));
	    String fname = request.getParameter("fname");
	    String lname = request.getParameter("lname");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    int balance = Integer.parseInt(request.getParameter("balance"));

	    User tempUser = new User(userId,fname,lname, username, password,balance);
	    userDbUtil.addUser(tempUser);
	    System.out.println(tempUser);
	    listUsers(request, response);
	  }

	  private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    int id = Integer.parseInt(request.getParameter("search"));

	    List<User> user = userDbUtil.searchUser(id);

	    System.out.println(user.isEmpty());
	    if (user.isEmpty()) {
	      String msg1 = "User not found !!";
	      request.setAttribute("msg1", msg1);
	    } else {
	      request.setAttribute("listUser", user);
//	      System.out.println("Searched students:" + user);
	    }

	    RequestDispatcher dispatcher = request.getRequestDispatcher("user-details.jsp");
	    dispatcher.forward(request, response);
	  }

	  private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<User> listUsers = userDbUtil.listUsers();
	    if (listUsers.isEmpty()) {
	      request.setAttribute("userList", null);
	    }
	    System.out.println(listUsers);
	    request.setAttribute("listUser", listUsers);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("user-details.jsp");
	    dispatcher.forward(request, response);
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	  }

	}
package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionVariable")
public class SessionVariable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionVariable() {
		super();
	}
	int oldValue = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
	     * response.setContentType("text/html"); PrintWriter O = response.getWriter();
	     * HttpSession sessions = request.getSession();
	     * sessions.setAttribute("OldAttribute", oldValue);
	     * sessions.setMaxInactiveInterval(30 * 60); if
	     * (sessions.getAttribute("OldAttribute") != null) { O.println("<h1>" +
	     * "Old Count : " + sessions.getAttribute("OldAttribute") + "</h1>");
	     * oldValue++; sessions.setAttribute("OldAttribute", oldValue); O.println("<h1>"
	     * + "New Count : " + sessions.getAttribute("OldAttribute") + "</h1>"); }
	     */

	    
	    
	    
	    // ANOTHER WAY
	    response.setContentType("text/html");
	    PrintWriter O = response.getWriter();
	    HttpSession sessions = request.getSession();
	    Integer count = (Integer) sessions.getAttribute("counter");
	    if (count == null) {
	      count = 0;
	      sessions.setAttribute("counter", count);
	      // return;
	    } else {
	      sessions.setAttribute("counter", ++count);
	    }
	    O.println("<h1>0ld Value :" + count);
	    O.println("<h1>New Value :" + (count + 1));
	    sessions.setMaxInactiveInterval(10);
		}
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}



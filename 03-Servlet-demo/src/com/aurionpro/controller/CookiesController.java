package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/CookiesController")
public class CookiesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookiesController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Cookie[] cookie = request.getCookies();
		int count = 0;
		boolean flag = false;
		if (cookie != null) {
			for (Cookie x : cookie) {
				if (x.getName().equals("counter")) {
					flag = true;
					count = Integer.parseInt(x.getValue());
					count = count + 1;
					Cookie cookie1 = new Cookie("counter", Integer.toString(count));
					response.addCookie(cookie1);
				}
			}
		}

		if (flag == false) {
			Cookie cookies = new Cookie("counter", Integer.toString(count));
			response.addCookie(cookies);
		}
		response.setContentType("text/html");
		out.println("<h1>" + "Old Count : " + count);
	    out.println("<h1>" + "New Count : " + (count + 1) + "</h1>");
		// session.setMaxInactiveInterval(10);

	}
}

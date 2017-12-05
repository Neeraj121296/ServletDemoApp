package com.srivastava.onlineapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/Logout.online")
public class LogoutServlet extends HttpServlet {

  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		ServletContext context = this.getServletContext();
		String email = context.getInitParameter("customersupport");

			
			session.removeAttribute("userid");
			session.invalidate();
			String message = (String)this.getServletContext().getAttribute("message");
			PrintWriter out=response.getWriter();
			out.println("You are logout successfully"+message+email);
			response.setHeader("Cache-control", "no-cache, no-store");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");
			out.close();
			
		}
	}



package com.srivastava.onlineapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/Header")
public class HeaderServlet extends HttpServlet {

       

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Home &nbsp;&nbsp;&nbsp;About&nbsp;&nbsp;&nbsp;  ");
		System.out.println("Header Call");
		
	}
}

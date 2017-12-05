package com.srivastava.onlineapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private int counter;
	@Override
	public void init(){
		
		
		counter=1;
		System.out.println("Counter is"+counter+"in init");
	}
	public String BuildLogin(String msg){
		String design="";
		design= "<!DOCTYPE html><html lang='en'><head>"
				+ "<title>Login</title></head>"
				+"<body><span style='color:red'>"+msg+"</span><br>"
				+ "<form action='Home' method='post'>"
				+"<table> <tr> "
				+" <td><label for=''>Userid</label></td>"
				+"<td><input required name='userid' type='text' placeholder='Type Userid'></td>"
			+"</tr><tr><td><label for=''>Password</label></td> "
			+"	<td><input required name='pwd' type='password' placeholder='Type Password'></td> </tr><tr> "
			+"	<td><input name='act' type='submit' value='submit' ></td> "
			+"	<td><button name='act' value='reset'>Reset</button></td></tr></table> "
	+" </form></body> </html>";
		return design;
	}
	@Override
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) 
					throws ServletException, IOException {
		this.getServletContext().setAttribute("message", "This is Admin Message");
		String act=request.getParameter("act");
		if(act.equals("submit")){
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		if(userid.equals(password)){
		HttpSession Session=request.getSession(true);
			Session.setAttribute("userid",userid );
			response.sendRedirect("Welcome.online?bill=10000&userid="+userid);
		//response.sendRedirect("Welcome.online");
			//request.setAttribute("bill", 10000);
			//RequestDispatcher rd=request.getRequestDispatcher("Welcome");
			//rd.forward(request, response);
	// String urlWithSessionId=	response.encodeRedirectURL("Welcome");
		//response.sendRedirect(urlWithSessionId);
			
		}
		
		else
		{
			PrintWriter out = response.getWriter();
			
			out.println(this.BuildLogin("invalid userid or password"));
			out.close();
		}
		}
		if(act.equals("reset")){
			response.sendRedirect("Home");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		//out.println("<html><body>");
	//out.println("<h1>Welcome User"+counter+"</h1>");
		out.println(this.BuildLogin(""));
		//counter++;
//	out.println("</body></html>");
	out.close();
	}

}

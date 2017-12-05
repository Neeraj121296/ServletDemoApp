package com.srivastava.onlineapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srivastava.onlineapp.dao.ProductDAO;
import com.srivastava.onlineapp.dto.ProductDTO;
import com.srivastava.onlineapp.listener.SessionCountListener;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/Welcome.online")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
}



protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	
	// TODO Auto-generated method stub 
	PrintWriter out=response.getWriter();
	HttpSession session=request.getSession(false);
	
		ArrayList<ProductDTO> productlist=null;
		ProductDAO productDAO=new ProductDAO();
		try{
		productlist=productDAO.getProducts();	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("404.html");
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("404.html");
			e.printStackTrace();
		}
		
//	String userid = (String)session.getAttribute("userid");
		String productHTML="";
		if(productlist!=null && productlist.size()>0){
			String li="";
			for(ProductDTO product : productlist)
			{
				String liHTML="<li>"+product.getId()
				+" "+product.getName()+" "+""+product.getPrice()+product.getDesc()+
				"<BR> <img src='"+product.getImage()+"'>"
				+"</li>";
				li = li + liHTML;
			}
			productHTML = "<ul>"+li+"</ul>";
		}
	//	 bill=0;
String bill=request.getParameter("bill");
		//if(request.getAttribute("bill")!=null){
		 //bill = (Integer)request.getAttribute("bill");
			//} 
	String	userid=request.getParameter("userid");
		//PrintWriter out1=response.getWriter();
	//out1.println("<h1>Welcome User"+userid+"</h1>");
	String message = (String)this.getServletContext().getAttribute("message");
		String urlWithSessionId = response.encodeURL("Logout.online");
		String logout = "Message is "+message+
				 "Welcome "+userid +"<br>"
			+ "Session Count "+SessionCountListener.getCounter()
				+"and bill is"+bill+"<br>"+
			"<form action='"+urlWithSessionId+"'>"
				+ "<button type='submit'>Logout</button>"
				+productHTML
				
				+ "</form>";
		
	//	session.setMaxInactiveInterval(10*60);
		response.setContentType("text/html");	
		RequestDispatcher rd=request.getRequestDispatcher("Header");
		rd.include(request, response);
		
	out.println(logout);
	response.setHeader("Cache-control", "no-cache, no-store");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "-1");
	RequestDispatcher rd2=request.getRequestDispatcher("Footer");
	rd2.include(request, response);
	
	out.close();	
}
}
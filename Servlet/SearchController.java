package com.srivastava.onlineapp.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srivastava.onlineapp.dto.ProductDTO;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("search controller call");
int price=Integer.parseInt(request.getParameter("txtPrice"));
Model model =new Model();
try{
	ArrayList<ProductDTO> productlist=model.getProductsbyPrice(price);
	request.setAttribute("pList",productlist);
	System.out.println(productlist);
	
    request.setAttribute("price", price);
    RequestDispatcher rd=request.getRequestDispatcher("Searchmvc.jsp");
    rd.forward(request, response);

}
catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	response.sendRedirect("error.html");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	response.sendRedirect("error.html");
}

	}

}

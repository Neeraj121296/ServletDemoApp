package com.srivastava.onlineapp.Servlet;

import static com.srivastava.onlineapp.dao.ResourceBundleReader.getValue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.srivastava.onlineapp.dto.ProductDTO;

public class Model {
	public ArrayList<ProductDTO> getProductsbyPrice(int price) throws ClassNotFoundException, SQLException {
		System.out.println("model call");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		ArrayList<ProductDTO> productlist=new ArrayList<>();

		try{
			con= getConnection();
			pstmt = con.prepareStatement("select id, name,description,price,img from  products where price>=?");
			pstmt.setDouble(1, price);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ProductDTO productDTO=new ProductDTO();
				productDTO.setId(rs.getInt("id"));
				productDTO.setName(rs.getString("name"));
				productDTO.setDesc(rs.getString("description"));
				productDTO.setImage(rs.getString("img"));
				productDTO.setPrice(rs.getInt("price"));
				productlist.add(productDTO);
			
			}
			
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		System.out.println("going to return object....");
		return productlist;
		
	}
	
	private  Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(getValue("drivername"));
		Connection connection=DriverManager.getConnection(getValue("url"),getValue("userid")
				,getValue("password"));
		return connection;
	}
	
	

}

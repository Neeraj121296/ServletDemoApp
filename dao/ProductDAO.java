package com.srivastava.onlineapp.dao;
import static com.srivastava.onlineapp.dao.ResourceBundleReader.getValue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import  com.srivastava.onlineapp.dto.ProductDTO;

public class ProductDAO {

	public ArrayList<ProductDTO> getProducts() throws ClassNotFoundException, SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ProductDTO> productlist=new ArrayList();
		String sql="select id,name,description,img,price from products";
		try{
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ProductDTO productDTO=new ProductDTO();
				productDTO.setId(rs.getInt("id"));
				productDTO.setName(rs.getString("name"));
				productDTO.setPrice(rs.getInt("price"));
				productDTO.setDesc(rs.getString("description"));
				productDTO.setImage(rs.getString("img"));
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
		return productlist;
	}
	
	private  Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(getValue("drivername"));
		Connection connection=DriverManager.getConnection(getValue("url"),getValue("userid")
				,getValue("password"));
		return connection;
	}
	
	


}
 
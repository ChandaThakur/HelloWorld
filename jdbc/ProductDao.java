package com.zensar.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.zensar.beans.Product;
import com.zensar.utility.DBUtil;




public class ProductDao {
	
	public int addProduct(Product product) {
		System.out.println("Now going to insert the product into db:" +product);
	
		Connection con=DBUtil.getMySqlDbConnection();
		
		String sql= "insert into product values (?,?,?)";
		
		int result=0;
		
		try {
			PreparedStatement pst = con.prepareStatement(sql); 
			pst.setInt(1, product.getProductId());
			pst.setString(2, product.getProductName());
			pst.setInt(3, product.getPrice());
			
			result=pst.executeUpdate();
			
			if(result==0) {
				System.out.println("Query Failed");
			}else {
				System.out.println("Success");
			}
		}catch(Exception e) {
			System.out.println("Exception" +e);
		}
		return result;	
	}

	public Product getProduct(int productId) {
		Connection con=DBUtil.getMySqlDbConnection();
		
		String sql = "select * from product where product_id=?";
		
		Product product= null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, productId);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				String productName=rs.getString("product_name");
				int price= rs.getInt("price");
				product=new Product(productId, productName, price);
			}else {
				System.out.println("Product ID does not exist");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return product;
	}
	
	public List<Product> getAllProduct() {
		Connection con=DBUtil.getMySqlDbConnection();
		List<Product> allProductList= new ArrayList<Product>();
 		String sql = "select * from product";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int productId= rs.getInt("product_id");
				String productName=rs.getString("product_name");
				int price= rs.getInt("price");
				Product product= new Product(productId, productName, price);
				allProductList.add(product);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return allProductList;
	}
	
	
	
	public int deleteProduct(int productId) {
		Connection con = DBUtil.getMySqlDbConnection();
		String sql3="delete from product where product_id=?";
		int result=0;
		try {
			PreparedStatement pst=con.prepareStatement(sql3);
			pst.setInt(1, productId);
			result=pst.executeUpdate();
			
			if(result ==0) {
				System.out.println("The product with this ID does not exost");
			}
			else {
				System.out.println("Succesfully Deleted");
			}
		
		}catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
	
	public int updateProduct(Product product) {
		Connection con=DBUtil.getMySqlDbConnection();
		String sql4="update product set product_name=?,price=? where product_id=?";
		int result =0;
		try {
			PreparedStatement pst=con.prepareStatement(sql4);
			pst.setString(1, product.getProductName());
			pst.setInt(2, product.getPrice());
			pst.setInt(3, product.getProductId());
			result=pst.executeUpdate();
			
			if(result ==0) {
				System.out.println("The product with this ID does not exist");
			}
			else {
				System.out.println("Succesfully Updated");
			}
	}catch(Exception e) {
		System.out.println(e);
	}
	return result;	

}

}

package com.zensar.jdbc;

import java.sql.*;

import com.zensar.beans.Product;


// see bean class of product
public class Example1 {
	
	public static void main(String[] args) {
		ProductDao pd = new ProductDao();
		System.out.println(pd.getAllProduct());
	}
	
	
}

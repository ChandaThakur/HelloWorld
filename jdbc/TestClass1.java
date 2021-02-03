package com.zensar.jdbc;

import java.util.List;

import com.zensar.beans.Product;

public class TestClass1 {

	public static void main(String[] args) {
		ProductDao pd= new ProductDao();
		
		//testGetAll();
		//testDeleteProduct(pd);
		//testUpdateProduct(pd);
		//testAddProduct(pd);
		//testGetProduct(3, pd);
	}

	private static void testGetAll() {
		ProductDao pd = new ProductDao();
		List<Product> list = pd.getAllProduct();
		for (Product x : list) {
			System.out.println(x);
		}
	}

	private static void testDeleteProduct(ProductDao pd) {
		int result1= pd.deleteProduct(10);
		if(result1==0) {
			System.out.println("Not Deleted");
		}else {
			System.out.println("Deleted");
		}
	}
	
	private static void testAddProduct(ProductDao pd) {
		
		int expectedResult=1;
		int actualResult= pd.addProduct(new Product(5,"mobile",35000));
		
		if(actualResult==expectedResult) {
			System.out.println("Success");
		}else {
			System.out.println("Failure");
		}
	}

	private static void testGetProduct(int productId,ProductDao pd) {
		Product actualResult=pd.getProduct(productId);
		if(actualResult!=null) {
			System.out.println("Success");
			System.out.println(actualResult);
		}else {
			System.out.println("Failure");
		}
	}
	
	private static void testUpdateProduct(ProductDao pd) {
		int expectedResult=1;
		int actualResult= pd.updateProduct(new Product(2,"Dress",999));
		
		if(actualResult==expectedResult) {
			System.out.println("Success");
		}else {
			System.out.println("Failure");
		}
	}
}

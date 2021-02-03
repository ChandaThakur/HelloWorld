package com.zensar.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
public static Connection getMySqlDbConnection() {
		
		String driverClassName ="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/java_training";
		String dbUserName="root";
		String dbPassword ="chanda#25";
		Connection con=null;
		try {
			Class.forName(driverClassName);
			con=DriverManager.getConnection(url,dbUserName,dbPassword);
			//System.out.println("Connection:"+con);
		}catch(Exception e) {
			System.out.println("exception occured while creating connection" +e);
		}
		
		return con;
		
	}

}

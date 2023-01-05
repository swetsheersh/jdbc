package com.jdbc.images;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	public Connection con;
	public Connection getconn() {
		try {
			//load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Create a connection
			String url="jdbc:mysql://localhost:9092/javajdbc";
			String username="root";
			String password="root";
			if(con==null) {
				con=DriverManager.getConnection(url,username,password);
			}
			
			if(con.isClosed()) {
				System.out.println("connection is still closed....");
			}else {
				System.out.println("connection created....");
			}}catch (Exception e) {
				e.printStackTrace();
			}
		return con;
	}
}

package javajdbc;

import java.io.FileInputStream;
import java.sql.*;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insertimages {

	public static void main(String[] args) {
		try {
			//load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Create a connection
			String url="jdbc:mysql://localhost:9092/javajdbc";
			String username="root";
			String password="root";
			Connection con=DriverManager.getConnection(url,username,password);
			
			if(con.isClosed()) {
				System.out.println("connection is still closed....");
			}else {
				System.out.println("connection created....");
			}
			//create a query , get the PreparedStatement object
			String q="insert into images(img) values(?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			//set value
			//pstmt.setInt(1, 1);
			FileInputStream fis=new FileInputStream("C:/Users/harsh/Desktop/flag.jpg");
			pstmt.setBinaryStream(1,fis,fis.available());
			pstmt.executeUpdate();
			System.out.println("inserted..");
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

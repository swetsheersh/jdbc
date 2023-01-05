package javajdbc;
//prepared ststement insert ,Dynamic query

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Dqinsert {

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
			
			String q="insert into table1 values(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			//set value
			Scanner ob= new Scanner(System.in);
			System.out.println("Enter id :");
			pstmt.setInt(1, ob.nextInt());
			System.out.println("Enter Name :");
			String t=ob.next();
			pstmt.setString(2, t);
			System.out.println("Enter city :");
			pstmt.setString(3, ob.next());
			pstmt.executeUpdate();
			System.out.println("inserted..");
			

		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}

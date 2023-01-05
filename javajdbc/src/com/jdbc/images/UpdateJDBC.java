package com.jdbc.images;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UpdateJDBC {

	public static void main(String[] args) {
		try {
			Conn conn=new Conn();
			Connection con=conn.getconn();
			String q="update table1 set name=?,city=? where id=?";
			PreparedStatement pstm=con.prepareStatement(q);
			Scanner ob=new Scanner(System.in);
			System.out.println("Enter id:");
			int a=ob.nextInt();
			System.out.println("Name:");
			String b=ob.next();
			System.out.println("City:");
			String c=ob.next();
			pstm.setInt(3, a);
			pstm.setString(1, b);
			pstm.setString(2, c);
			pstm.executeUpdate();
			System.out.println("Updated..");
			JOptionPane.showMessageDialog(null,"Updated....");
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

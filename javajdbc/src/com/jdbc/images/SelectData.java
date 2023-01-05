package com.jdbc.images;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SelectData {

	public static void main(String[] args) {
		try {
			Conn conn=new Conn();
			Connection con=conn.getconn();
			String q="select * from table1";
			PreparedStatement pstm=con.prepareStatement(q);
			ResultSet set=pstm.executeQuery();
			while(set.next()) {
				int id=set.getInt("id");
				String name=set.getString("name");
				String city=set.getString("city");
				System.out.println("id: "+id+ "|| name: "+name+ "|| city : "+city);
			}
			System.out.println("done..");
			JOptionPane.showMessageDialog(null,"done....");
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package com.jdbc.images;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Images {

	public static void main(String[] args) {
		try {
			Conn conn=new Conn();
			Connection con=conn.getconn();
			//create a query , get the PreparedStatement object
			String q="insert into images(img) values(?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			//set value
			JFileChooser jfc= new JFileChooser();
			jfc.showOpenDialog(null);
			File file=jfc.getSelectedFile();
			FileInputStream fis=new FileInputStream(file);
			pstmt.setBinaryStream(1,fis,fis.available());
			pstmt.executeUpdate();
			System.out.println("inserted..");
			JOptionPane.showMessageDialog(null,"Success....");
			/*
			 * FileInputStream fis=new FileInputStream("C:/Users/harsh/Desktop/flag.jpg");
			 * pstmt.setBinaryStream(1,fis,fis.available()); pstmt.executeUpdate();
			 * System.out.println("inserted..");
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

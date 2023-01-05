package javajdbc;

import java.sql.*;
public class FirstProgramm {

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
			//create a query
			Statement stmt=con.createStatement();
			try {
				String q="create table table1(id int(20) primary key auto_increment,name varchar(200) not null,city varchar(400))";
				/*ResultSet set=*/stmt.executeUpdate(q);
				System.out.println("Table created..");
			}catch (Exception e) {
				System.out.println("Table allready created..");
			}
			
			String q1="insert into table1 values(4,'Manjeet','Muzaffarpur')";
			stmt.executeUpdate(q1);
			
			String q2="select * from table1";
			ResultSet set=stmt.executeQuery(q2);
			
			while(set.next()) {
				int id=set.getInt("id");
				String name=set.getString("name");
				String city=set.getString("city");
				System.out.println("id: "+id+ "|| name: "+name+ "|| city : "+city);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

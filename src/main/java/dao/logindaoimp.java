package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import util.user;

public class logindaoimp implements logindao{
	private static final String url="jdbc:mysql://localhost:3306/car?serverTimeZone=GMT%2B8\":";
	 private static final String uname="root";
	 private static final String password="root";
	 java.sql.ResultSet rs=null;
	 user us=new user();
		public user login(user u) {
			java.sql.PreparedStatement p=null;
			java.sql.Connection connection=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					connection=DriverManager.getConnection(url, uname, password);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}		
				String sql ="select * from user where name= ? and password =?"; 
				try {
					p=connection.prepareStatement(sql);
					p.setString(1, u.getName());
					p.setString(2, u.getPassword());
					System.out.println(u.getName()+u.getPassword());	
					rs=p.executeQuery();
					System.out.println(p.toString());
					if(rs.next()) {
						String name=rs.getString("name");
						System.out.println("查到le");
						String password=rs.getString("password");
						us.setName(name);
						us.setPassword(password);
					}	
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			return us;
			
		}

	}

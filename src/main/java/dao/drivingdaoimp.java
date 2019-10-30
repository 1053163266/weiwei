package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import util.driving;

public class drivingdaoimp implements drivingdao {
	private static final String url="jdbc:mysql://localhost:3306/car?useUnicode=true&characterEncoding=UTF-8&serverTimeZone=GMT%2B8\":";
	 private static final String uname="root";//useUnicode=true&characterEncoding=UTF-8
	 private static final String password="root";
	 ResultSet rs=null;
	 String dd="d1";
	
	 HashMap<String, driving> map=new HashMap<String, driving>();
	 public Map<String, driving> queryAlldriving() throws ClassNotFoundException {		
			java.sql.PreparedStatement p=null;
			java.sql.Connection connection=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					connection=DriverManager.getConnection(url, uname, password);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}		
				String sql ="select * from driving"; 
				try {
					p=connection.prepareStatement(sql);	
					rs=p.executeQuery();
					while(rs.next()) {
						 driving d=new driving();
						int id=rs.getInt(1);
						d.setId(id);
						String name=rs.getString(2);
						System.out.println(name);
						d.setName(name);
						String sex=rs.getString(3);
						d.setSex(sex);
						String phonenumber=rs.getString(4);
						d.setPhonenumber(phonenumber);
						String date=rs.getString(5);
						d.setData(date);
						boolean b=rs.getBoolean(6);
						d.setStatu(b);
						System.out.println(d);
						map.put(dd, d);
						System.out.println(dd);
						dd+="1";
						System.out.println(dd);
					}	
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			return map;
			
		}
	public Map<String, driving> queryOnedriving(String s) throws ClassNotFoundException {
		java.sql.PreparedStatement p=null;
		java.sql.Connection connection=null;
		String a=s;
		System.out.println("传进来的是"+a);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection=DriverManager.getConnection(url, uname, password);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		
			String sql ="SELECT * from driving where name like ?"; 
			try {
				p=connection.prepareStatement(sql);
				p.setString(1, "%"+a+"%");
				rs=p.executeQuery();
				System.out.println(p.toString());//查看SQL
				while(rs.next()) {
					System.out.println("查到了");
					 driving d=new driving();
						int id=rs.getInt(1);
						d.setId(id);
						String name=rs.getString(2);
						d.setName(name);
						String sex=rs.getString(3);
						d.setSex(sex);
						String phonenumber=rs.getString(4);
						d.setPhonenumber(phonenumber);
						String date=rs.getString(5);
						d.setData(date);
						boolean b=rs.getBoolean(6);
						d.setStatu(b);
						map.put(dd, d);
						System.out.println(dd);
						dd+="1";
						System.out.println(dd);
				}if(!rs.next()) {
				driving d=new driving();
				map.put(dd, d);
				System.out.println(dd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return map;
		
	}
}


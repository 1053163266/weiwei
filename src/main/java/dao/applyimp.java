package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import util.applicant;

public class applyimp implements apply{
private static final String url="jdbc:mysql://localhost:3306/car?useUnicode=true&characterEncoding=UTF-8&serverTimeZone=GMT%2B8\":";
 private static final String uname="root";
 private static final String password="root";

	public int applys(applicant u) {
		int i=0;
		java.sql.PreparedStatement p=null;
		java.sql.Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection=DriverManager.getConnection(url, uname, password);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			String sql="insert into applicant values(?,?,?)";
			try {
				p=connection.prepareStatement(sql);
				p.setString(1, u.getName());
				System.out.println(u.getName());
				p.setString(2, u.getPnumber());
				p.setString(3, u.getAddress());
				int count=p.executeUpdate();
				if(count!=0) {
					System.out.println("申请成功！");
					i++;
					
				}
				else {
					System.out.println("注册失败");
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return i;
		
	}



}

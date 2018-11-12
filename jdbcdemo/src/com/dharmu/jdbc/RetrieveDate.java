package com.dharmu.jdbc;
import java.sql.*;
import java.util.*;
import java.text.*;
public class RetrieveDate {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
		PreparedStatement ps= con.prepareStatement("Select * from webuser");
		ResultSet rs = ps.executeQuery();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		while(rs.next())
		{
			String name= rs.getString(1);
			java.sql.Date sdate = rs.getDate(2);
			String s=sdf.format(sdate);
			System.out.println(name+"....."+s);
			
		}
		con.close();

	}

}

package com.dharmu.jdbc;
import java.sql.*;
public class SelectMultiRow {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
		Statement st = con.createStatement();
		String sqlQuery = "select * from employees where esal>111111112";
		ResultSet rs = st.executeQuery(sqlQuery);
		boolean flag = false;
		System.out.println("ENO\t\tENAME\t\tESAL\t\tEADDR");
		System.out.println("----------------------------------------------------------------------------");
		while(rs.next())
		{
			flag=true;
			System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getString(4));
			
		}
		if(flag==false)
		{
			System.out.println("No Matched Record Found");
		}
		con.close();
	}

}

package com.dharmu.jdbc;
import java.sql.*;
public class ExecutemethodLoopHoles {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
		Statement st = con.createStatement();
		int updateCount=st.executeUpdate("Create table emp1(eno number)");
		System.out.println(updateCount);
		con.close();

	}

}

package com.dharmu.jdbc;
import java.sql.*;
import java.sql.DriverManager;

public class JdbcDemo1 {

	public static void main(String[] args) throws Exception{
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
		Statement st= con.createStatement();
		st.executeUpdate("create table employees(eno number,ename varchar2(20),esal number(10),eaddr varchar2(10))");
		System.out.println("Table Created Successfully");
	}

}

package com.dharmu.jdbc;

import java.sql.*;
import java.util.*;

public class DeleteRecordDemo { 
	public static void main(String[] args) throws Exception {
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
	Statement st= con.createStatement();
	Scanner s= new Scanner(System.in);
	System.out.println("Enter Employee number u want to delete");
	int tno= s.nextInt();
	String sqlQuery= String.format("delete from employees where eno>=%d", tno);
	int updatecount = st.executeUpdate(sqlQuery);
	System.out.println("No. of rows deleted:"+ updatecount);
	con.close();
}
}
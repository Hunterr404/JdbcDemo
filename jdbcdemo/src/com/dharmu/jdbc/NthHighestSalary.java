package com.dharmu.jdbc;
import java.sql.*;
import java.util.*;

public class NthHighestSalary {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Anonymous", "dharmu");
		Statement st = con.createStatement();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Number:");
		int n=sc.nextInt();
		String sqlQuery = "select * from (select eno,ename,esal,eaddr,rank() over (order by esal DESC) ranking from employees) where ranking="+n;
		ResultSet rs= st.executeQuery(sqlQuery);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
			
		}
		con.close();

	}

}

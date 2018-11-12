package com.dharmu.jdbc;
import java.util.*;
import java.sql.*;
public class DynamicInput {

	public static void main(String[] args) throws Exception {
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
		Statement st= con.createStatement();
		while(true) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter employee #");
		int eno=s.nextInt();
		System.out.println("Enter employee Name");
		String ename=s.next();
		System.out.println("Enter employee Salary");
		double esal=s.nextDouble();
		System.out.println("Enter employee Address");
		String eaddr=s.next();
		String sqlQuery=String.format("insert into employees values(%d,'%s',%f,'%s')", eno,ename,esal,eaddr);
		st.executeUpdate(sqlQuery);
		System.out.println("Record Inserted Successfully");
		System.out.println("Do you want to add one more record[yes/No]");
		String option = s.next();
		if(option.equalsIgnoreCase("No"));
		{
		break;
		}
		}
		con.close();
		
		
	}
		

}


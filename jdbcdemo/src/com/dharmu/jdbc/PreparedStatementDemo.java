package com.dharmu.jdbc;
import java.sql.*;
import java.util.*;
public class PreparedStatementDemo {

	public static void main(String[] args) throws Exception {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
		String sqlQuery="insert into employees values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sqlQuery);
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("Employee Number");
			int eno=sc.nextInt();
			System.out.println("Employee Name");
			String ename=sc.next();
			System.out.println("Employee Salary");
			int esal=sc.nextInt();
			System.out.println("Employee Address");
			String Eaddr= sc.next();
			pst.setInt(1, eno);
			pst.setString(2, ename);
			pst.setInt(3, esal);
			pst.setString(4, Eaddr);
			pst.executeUpdate();
			System.out.println("record inserted successfully");
			System.out.println("Do you want to add one more Record[Yes/No]");
			String option = sc.next();
			if(option.equalsIgnoreCase("No"));
			{
				break;
			}
			
		}
		con.close();
	}

}

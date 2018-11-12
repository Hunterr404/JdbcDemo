package com.dharmu.jdbc;
import java.sql.*;
import java.util.*;
import java.text.*;
public class DateDemo1 {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
		PreparedStatement pst = con.prepareStatement("insert into WebUser values(?,?)");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name:");
		String uname=sc.next();
		System.out.println("Enter DOB:(dd-mm-yyyy)");
		String DOB=sc.next();
		pst.setString(1, uname);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(DOB);
		long l=udate.getTime();
		java.sql.Date sdate = new java.sql.Date(l);
		pst.setDate(2, sdate);
		System.out.println("Record Inserted Successfully");
		con.close();
	}

}

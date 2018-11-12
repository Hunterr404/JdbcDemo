/*
SQL> create or replace procedure getAllEmpInfo2(initchars IN varchar,emps OUT SYS_REFCURSOR) as
  2  begin
  3  open emps for
  4  select * from employees where ename like initchars;
  5  end;
  6  /

SQL> commit;

Commit complete.
*/
package com.dharmu.jdbc;
import java.sql.*;
import java.util.*;
import oracle.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class StoredProcedureDemo3 {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Anonymous", "dharmu");
		CallableStatement cst = con.prepareCall("{call getAllEmpInfo2(?,?)}");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter initial characters of the name");
		String initialchars = sc.next()+"%";
		cst.setString(1, initialchars);
		cst.registerOutParameter(2, OracleTypes.CURSOR);
		cst.executeQuery();
		ResultSet rs = (ResultSet)cst.getObject(2);
		boolean flag = false;
		System.out.println("END\tENAME\tESAL\tEADDR");
		System.out.println("-------------------------------");
		while(rs.next())
		{
			flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
		}
		if(flag==false)
		{
			System.out.println("No Records Availiable");
		}
		con.close();
	}

}

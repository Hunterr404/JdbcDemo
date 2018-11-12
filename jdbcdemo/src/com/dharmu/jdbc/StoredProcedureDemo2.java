/*
SQL> create or replace procedure getAllEmpInfo1(sal IN number,emps OUT SYS_REFCURSOR) as
  2  BEGIN
  3  open emps for
  4  Select * from employees where esal>sal;
  5  END;
  6  /

SQL> commit;
*/
package com.dharmu.jdbc;
import java.sql.*;
import oracle.jdbc.*;
public class StoredProcedureDemo2 {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Anonymous", "dharmu");
		CallableStatement cst = con.prepareCall("{call getAllEmpInfo1(?,?)}");
		cst.setInt(1,10000);
		cst.registerOutParameter(2,OracleTypes.CURSOR);
		cst.execute();
		ResultSet rs = (ResultSet)cst.getObject(2);
		boolean flag = false;
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("---------------------------------");
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

/*
SQL> create or replace procedure getAllEmpInfo(emps OUT SYS_REFCURSOR) as
  2  Begin
  3  open emps for
  4  select * from employees;
  5  END;
  6  /

SQL> commit;
*/
package com.dharmu.jdbc;
import java.sql.*;
import java.util.*;
import oracle.jdbc.*;
public class StoredProcedureDemo1 {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
		CallableStatement cst=con.prepareCall("{call getAllEmpInfo(?)}");
		cst.registerOutParameter(1, OracleTypes.CURSOR);
		cst.execute();
		ResultSet rs = (ResultSet)cst.getObject(1);
		boolean flag = false;
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("-------------------------------------");
		while(rs.next())
		{
			flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
		}
		if (flag==false)
		{
			System.out.println("No Records Availiable");
		}
		con.close();

	}

}

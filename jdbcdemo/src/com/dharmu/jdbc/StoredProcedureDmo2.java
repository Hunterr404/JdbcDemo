/*
SQL> create or replace procedure getEmpInfo(id IN number,name OUT varchar2, sal OUT number) as
  2  BEGIN
  3  select ename,esal into name, sal from employees where eno=id;
  4  END;
  5  /

*/
package com.dharmu.jdbc;
import java.sql.*;
public class StoredProcedureDmo2 {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Anonymous", "dharmu");
		CallableStatement cst=con.prepareCall("{call getEmpInfo(?,?,?)}");
		cst.setInt(1, 3);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.registerOutParameter(3, Types.INTEGER);
		cst.execute();
		System.out.println("Employee Name :"+cst.getString(2));
		System.out.println("Employee Salary  "+cst.getFloat(3));
		con.close();

	}

}

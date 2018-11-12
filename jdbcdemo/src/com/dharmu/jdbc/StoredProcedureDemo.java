/*
SQL> create or replace procedure addproc(num1 IN number,num2 IN number, num3 OUT number) as
  2  BEGIN
  3  num3:=num1+num2;
  4  end;
  5  /

*/
package com.dharmu.jdbc;
import java.sql.*;

public class StoredProcedureDemo {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
		CallableStatement cst = con.prepareCall("{call addProc(?,?,?}");
		cst.setInt(1, 100);
		cst.setInt(2, 200);
		cst.registerOutParameter(3, Types.INTEGER);
		cst.execute();
		System.out.println("Result..."+cst.getInt(3));
		con.close();
	}

}

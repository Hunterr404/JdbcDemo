/*
QL> create or replace function getAvg(id1 IN number, id2 IN number)return number
  2  as
  3  sal1 number;
  4  sal2 number;
  5  Begin
  6  select esal into sal1 from employees where eno=id1;
  7  select esal into sal2 from employees where eno=id2;
  8  return (sal1+sal2)/2;
  9  END;
 10  /

Function created.

SQL> commit;

*/
package com.dharmu.jdbc;
import java.sql.*;
public class StoredProcedureFunctionDemo {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Anonymous","dharmu");
		CallableStatement cst= con.prepareCall("{?=call getAvg(?,?)}");
		cst.setInt(2, 3);
		cst.setInt(3, 5);
		cst.registerOutParameter(1, Types.INTEGER);
		cst.execute();
		System.out.println("Average Salary is:"+cst.getInt(1));
		con.close();
	}

}

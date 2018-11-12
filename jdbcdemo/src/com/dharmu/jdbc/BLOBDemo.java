package com.dharmu.jdbc;
import java.sql.*;
import java.io.*;
public class BLOBDemo {

	public static void main(String[] args) throws Exception{
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Anonymous", "dharmu");
		PreparedStatement ps = con.prepareStatement("insert into Actress values(?,?)");
		ps.setString(1, "katrina");
		File f= new File("C:\\Users\\dHARMU\\eclipse-workspace\\jdbcdemo\\bin\\com\\dharmu\\jdbc\\katrinakaif.jpg");
		FileInputStream fis = new FileInputStream(f);
		ps.setBinaryStream(2, fis);
		System.out.println("Inserting Image from:"+ f.getAbsolutePath());
		int updatecount= ps.executeUpdate();
		if(updatecount==1)
		{
			System.out.println("Record Inserted");
		}else
		{
			System.out.println("Record not Inserted");
			
		}

	}

}

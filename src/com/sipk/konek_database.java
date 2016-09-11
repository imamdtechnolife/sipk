package com.sipk;

import java.sql.*;
import javax.swing.JOptionPane;

public class konek_database {

	private static Connection konekDB;
	
	public static Connection getKonekDB()
	{
		try
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			konekDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/sipk","root","");
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada kelas database : "+ex.getMessage());
		}
		
		return konekDB;
	}
}

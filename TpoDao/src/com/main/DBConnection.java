package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	private static Connection connection;
	public static Connection getConnection()
	{
		try {
			if(connection==null||connection.isClosed())
			{
			new DBConnection();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return connection;
	}

	private DBConnection() //singleton pattern whose only 1 object can be create with static class
	{
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //references of class
		String userName="saurabh";
		String password="saurabh";
		String url="jdbc:sqlserver://127.0.0.1\\SQLEXPRESS"+";databaseName = tpo";
		// compare with http:\\www.google.com
		//jdbc:sqlserver -name of protocol
		// 127.0.0.1\\SQLEXPRESS - address of database
		connection=DriverManager.getConnection(url,userName,password); 
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	String servername ;

	String port ;
	String db_name ;
	String db_user;
	String db_pass;
	public MyConnect() {
	servername = "127.0.0.1";
	port = "3307";
	db_name = "shop";
	db_user="root";
	db_pass="";
	}
	public MyConnect(String servername, String port, String db_name, String db_user, String
	db_pass) {
	this.servername = servername;
	this.port = port;
	this.db_name = db_name;
	this.db_user = db_user;
	this.db_pass = db_pass;
	}
	public Connection getcn()
	{
		System.out.println("My connect da ket noi");
	Connection cn = null;
	try {
	String db_url = "jdbc:mysql://" + servername + ":" + port +"/" + db_name;
	System.out.println(db_url);
	Class.forName("com.mysql.jdbc.Driver");
	cn = DriverManager.getConnection(db_url, db_user, db_pass);
	}
	catch (ClassNotFoundException | SQLException ex) {
	System.out.println(ex.getMessage());
	}
	return cn;
	}
}

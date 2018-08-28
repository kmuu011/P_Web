package com.ict.erp.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBCon {
	
	private static String url;
	private static String id;
	private static String pwd;
	private static String driver;
	
	private static Connection con;
	
	private static void load(String path) {
		InputStream is = DBCon.class.getResourceAsStream(path);
		
		Properties prop = new Properties();

		try {
			prop.load(is);
			is.close();
			
			url = prop.getProperty("url");
			id = prop.getProperty("id");
			pwd = prop.getProperty("pwd");
			driver = prop.getProperty("driver");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static void openCon() {
		load("/config/db.properties");
		try {
			Class.forName(driver);
			DBCon.con = DriverManager.getConnection(url, id, pwd);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		if(DBCon.con ==null) {
			openCon();
		}
		return DBCon.con;
	}
	
	public static void closeCon() {
		if(DBCon.con !=null) {
			try {
				DBCon.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
		
	}

}

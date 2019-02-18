package com.cg.ems.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {
	private static String url=null;
	private static String usn=null;
	private static String pwd=null;
	private static String driver=null;
	private static Connection con=null;
public static Connection getCon()throws SQLException, IOException {
	Properties myProps=getProps();
	url=myProps.getProperty("dburl");
	usn=myProps.getProperty("dbunm");
	pwd=myProps.getProperty("dbpwd");
	if(con==null) {
		con=DriverManager.getConnection(url, usn, pwd);
		
	}
	return con;
	
}
public static Properties getProps() throws IOException
{
	Properties dbProps=new Properties();
	FileReader fr=new FileReader("dbutil.properties");
	dbProps.load(fr);
	return dbProps;
	
}
}

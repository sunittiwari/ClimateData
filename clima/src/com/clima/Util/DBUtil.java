/*
package com.clima.Util;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	private static Connection conn;
	 
    public static Connection getConnection() {
    	try
    	{
    	  Class.forName("com.mysql.jdbc.Driver").newInstance();
    	  //Class.forName("org.apache.hive.jdbc.HiveDriver").newInstance();
    	  String url = "jdbc:mysql://localhost:3306/";
    	 // String url1 = "org.apache.hadoop.hive.jdbc.HiveDriver";
    	  conn = DriverManager.getConnection(url, "root", "root");
    	  System.out.println(conn);
    	 
    	 // conn.close();
    	}
    	catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
    	catch (IllegalAccessException ex) {System.err.println(ex.getMessage());}
    	catch (InstantiationException ex) {System.err.println(ex.getMessage());}
    	catch (SQLException ex)           {System.err.println(ex.getMessage());}
    	return conn;
		
    
        if( conn != null )
            return conn;
 
        InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream( "db.properties" );
        Properties properties = new Properties();
        try {
            properties.load( inputStream );
            String driver = properties.getProperty( "driver" );
            String url = properties.getProperty( "url" );
            String user = properties.getProperty( "user" );
            String password = properties.getProperty( "password" );
            Class.forName( driver );
            conn = DriverManager.getConnection( url, user, password );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return conn;
    }
 
    public static void closeConnection( Connection toBeClosed ) {
        if( toBeClosed == null )
            return;
        try {
            toBeClosed.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}*/
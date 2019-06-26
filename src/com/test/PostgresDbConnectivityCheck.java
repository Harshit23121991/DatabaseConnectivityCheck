package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresDbConnectivityCheck {

	  private final static String DB_URL = "jdbc:postgresql://localhost/postgres";
	  private final static String USER = "postgres";
	  private final static String PASS = "admin@123";

	  public static void main(String[] args) {
	    Connection conn = null;  
	    try {    
	    //  Class.forName("oracle.jdbc.driver.OracleDriver");    
	      System.out.println("Connecting to database..."); 
	      Class.forName("org.postgresql.Driver");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	      System.out.println(conn);
	      
	      Statement  stmt = conn.createStatement();
	         String sql = "CREATE TABLE COMPANY2 " +
	            "(ID INT PRIMARY KEY     NOT NULL," +
	            " NAME           TEXT    NOT NULL, " +
	            " AGE            INT     NOT NULL, " +
	            " ADDRESS        CHAR(50), " +
	            " SALARY         REAL)";
	         stmt.executeUpdate(sql);
	      
	      /*Statement stmt=conn.createStatement();  
	      ResultSet rs=stmt.executeQuery("select * from "+"TestDB"+".User");  
	      while(rs.next())  
	      System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));*/  
	     // con.close();  
	      
	         System.out.println("Table created successfully");
	      
	    } catch (Exception e) {    
	      e.printStackTrace();    
	    } finally {    
	      if (conn != null) {    
	        try {    
	          conn.close();    
	        } catch (Exception e) {    
	          // ignore    
	        }    
	      }    
	    }            
	  }    

}

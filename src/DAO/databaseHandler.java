package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class databaseHandler {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/ecafe_db";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "lab6";
	
	public Connection conn = null;
	public Statement stmt = null;
	public java.sql.PreparedStatement prep_stmt = null;
	public CallableStatement call_stmt = null;
	
	public databaseHandler(){
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

		    //STEP 3: Open a connection
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		}
		
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		}catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
	    }
	}  
}

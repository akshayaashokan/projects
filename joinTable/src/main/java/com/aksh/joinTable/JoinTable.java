package com.aksh.joinTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;



public class JoinTable {
	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "root";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "test";
	
	/** The name of the table we are testing with */
	private final String tableName = "STUDENT";
	private final String tableName1 = "BOOK";
	private final String tableName2 = "LIBRARY";
	
	
	
	final static Logger logger = Logger.getLogger(JoinTable.class);
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	/*public Connection getConnection() throws SQLException {
		Connection conn=null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}*/

	public Connection getConnection() throws SQLException {
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);
		Connection conn= DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);
		 

		return conn;
		
	}
	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	  Statement stmt = null;
		//Statement stmt =conn.createStatement();
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	       
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	/**
	 * Connect to MySQL and do some stuff.
	 * @throws SQLException 
	 */
	
		public void createTable() throws SQLException
		{
			Connection conn = this.getConnection();
			
		// Create a table
		try {
		    String createString =
			        "CREATE TABLE " + this.tableName + " ( " +
			        "ID INTEGER NOT NULL AUTO_INCREMENT, " +
			        "NAME varchar(40) NOT NULL, " +
			        "DEPT varchar(40) NOT NULL, " +
			         "PRIMARY KEY (ID))";
			this.executeUpdate(conn, createString);
			System.out.println("Created student table");
			String createString1 =
			        "CREATE TABLE " + this.tableName1 + " ( " +
			        "BOOK_ID INTEGER NOT NULL AUTO_INCREMENT, " +
			        "BOOK_NAME varchar(70) NOT NULL, " +
			        "ID INTEGER NOT NULL, " +
			        "PRIMARY KEY (BOOK_ID), " +
			        "FOREIGN KEY(ID) REFERENCES STUDENT(ID))";
			this.executeUpdate(conn, createString1);
			System.out.println("Created book table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			logger.error("error is :"+e);
			
			return;
		}
		}
	
	public void insertTable() throws SQLException
	{
		Connection conn=getConnection();
		Statement stmt=null;
		//inserting a value into the table

		try {
		
		 stmt = conn.createStatement();
	      			
				String sql = "INSERT INTO STUDENT " +
		                   "VALUES (1,'akshata','CS')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO STUDENT " +
	                   "VALUES (2,'anjali','EC')";
	      stmt.executeUpdate(sql);
	     sql = "INSERT INTO STUDENT " +
                  "VALUES (3,'afeefa','EC')";
     stmt.executeUpdate(sql);
		      System.out.println("Inserted records into the student table...");
		      String sql1 = "INSERT INTO BOOK " +
	                   "VALUES (101,'41 rules of love',1)";
	      stmt.executeUpdate(sql1);
	      sql1 = "INSERT INTO BOOK " +
                  "VALUES (102,'thousand splendid suns',2)";
     stmt.executeUpdate(sql1);
     sql1 = "INSERT INTO BOOK " +
             "VALUES (103,'call the midwife',3)";
stmt.executeUpdate(sql1);
	      System.out.println("Inserted records into the book table...");

		}
		catch(SQLException se){
		      //Handle errors for JDBC
			logger.error("error is :"+se);
			
		      
		   }catch(Exception e){
		      //Handle errors for Class.forName
			   logger.error("error is :"+e);
			 
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		    	  logger.error("error is :"+se);
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		    	  logger.error("error is :"+se);
		       
		      }//end finally try
		   }//end try 
	}
	
	
	
	
	public void joiningTable() throws SQLException
	{
		Connection conn=getConnection();
		Statement stmt=null;
		//inserting a value into the table

		try {
		
		 stmt = conn.createStatement();
		 
		 String sql = "SELECT * FROM STUDENT s JOIN BOOK b ON s.ID = b.ID";
		//  String sql = "SELECT * FROM STUDENT s,BOOK b WHERE s.ID=b.ID";
	      ResultSet rs = stmt.executeQuery(sql);
	      System.out.println("ID    "+"NAME    "+"DEPT    "+"BOOK_ID       "+"BOOK_NAME"); 
	      while(rs.next()){
	         //Retrieve by column name
	  
	   String id =rs.getString("id");
	   String name =rs.getString("name");
	   String dept =rs.getString("dept");
	   String bookid =rs.getString("book_id");
	   String bookname =rs.getString("book_name");
	  
	   System.out.println(id+"    " +name+"    "+dept+"    "+bookid+"       "+bookname);
	  // System.out.println(name);

	         //Display values
	        
	         
	         
	      }

		}//try
		catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			logger.error("error is :"+e);
			
			return;
		}
		
	}
	
		
	
	
	/**
	 * Connect to the DB and do some stuff
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
	
		JoinTable app = new JoinTable();
		//app.run();
		System.out.println("choose an operation");
		System.out.println("1:CREATE  2:INSERT  3:JOIN");
		Scanner scan= new Scanner(System.in);
		int a= scan.nextInt();
		switch(a)
		{
		case 1:
			System.out.println("create operation");
			app.createTable();
			
			break;
		case 2:
			System.out.println("insert operation");
			app.insertTable();
			break;
		case 3:
			System.out.println("join operation");
			app.joiningTable();
			break;
	
		}//switch
		scan.close();
	}
}

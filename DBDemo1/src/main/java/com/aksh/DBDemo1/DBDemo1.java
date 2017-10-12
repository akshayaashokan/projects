package com.aksh.DBDemo1;
import java.sql.Connection;
import org.apache.log4j.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
public class DBDemo1 {
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
	private final String tableName = "JDBC_TEST";
	
	final static Logger logger = Logger.getLogger(DBDemo1.class);
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
			        "STREET varchar(40) NOT NULL, " +
			        "CITY varchar(20) NOT NULL, " +
			        "STATE char(2) NOT NULL, " +
			        "ZIP char(5), " +
			        "PRIMARY KEY (ID))";
			this.executeUpdate(conn, createString);
			System.out.println("Created a table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			logger.error("error is :"+e);
			
			return;
		}
		}
	public void dropTable() throws SQLException
	{Connection conn = this.getConnection();
		
		// Drop the table
		try {
		    String dropString = "DROP TABLE " + this.tableName;
			this.executeUpdate(conn, dropString);
			System.out.println("Dropped the table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not drop the table");
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
	      			
				String sql = "INSERT INTO JDBC_TEST " +
		                   "VALUES (7,'akshata','vyttila','ekm','kl','68')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO JDBC_TEST " +
	                   "VALUES (8,'anjali','vyttila','ekm','kl','68')";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO JDBC_TEST " +
                  "VALUES (9,'afeefa','vyttila','ekm','tn','88')";
     stmt.executeUpdate(sql);
		      System.out.println("Inserted records into the table...");

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
		public void updateTable() throws SQLException
		{
			Connection conn= getConnection();
			Statement stmt = null;
		//updating an existing value in table
		 //STEP 4: Execute a query
	try {
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = "UPDATE JDBC_TEST " +
	                   "SET state = 'tn' WHERE id in (1)";
	      stmt.executeUpdate(sql);
	      System.out.println("update done");
	     		
	}catch(SQLException se){
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
		public void fetchTable() throws SQLException
		{	Connection conn = getConnection();
				Statement stmt = null;
	//printing the values in a table
	try {
		System.out.println("Creating statement...");
	      stmt = conn.createStatement();

	      // Extract records without any condition.
	      System.out.println("Fetching records without condition...");
	      String sql = "SELECT ID, NAME, STREET, CITY,STATE,ZIP FROM JDBC_TEST";
	      ResultSet rs = stmt.executeQuery(sql);

	      while(rs.next()){
	         //Retrieve by column name
	   int id  = rs.getInt("ID");
	   String name =rs.getString("NAME");
	    String street =rs.getString("STREET");
	    String city =rs.getString("CITY");
	    String state =rs.getString("STATE");
	    String zip =rs.getString("ZIP");  

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", NAME " + name);
	         System.out.print(", STREET " + street);
	         System.out.println(", CITY " + city);
	         System.out.println(", STATE " + state);
	         System.out.println(", ZIP " + zip);
	      }

	     // Select all records having ID equal or greater than 101
	      System.out.println("Fetching records with condition...");
	      sql = "SELECT *FROM JDBC_TEST" +
	                   " WHERE id >= 2 ";
	      rs = stmt.executeQuery(sql);

	      while(rs.next()){
	         //Retrieve by column name
	   int id  = rs.getInt("ID");
	   String name =rs.getString("NAME");
	    String street =rs.getString("STREET");
	    String city =rs.getString("CITY");
	    String state =rs.getString("STATE");
	    String zip =rs.getString("ZIP");  

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", NAME " + name);
	         System.out.print(", STREET " + street);
	         System.out.println(", CITY " + city);
	         System.out.println(", STATE " + state);
	         System.out.println(", ZIP " + zip);
	      }
	     
	     rs.close();
	   }catch(SQLException se){
		   logger.error("error is :"+se);
	     
	   }catch(Exception e){
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
	   }//end try */
	}

	
	
	/**
	 * Connect to the DB and do some stuff
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
	
		DBDemo1 app = new DBDemo1();
		//app.run();
		System.out.println("choose an operation");
		System.out.println("1:CREATE  2:INSERT  3:FETCH  4:UPDATE  5:DROP");
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
			System.out.println("fetch operation");
			app.fetchTable();
			break;
		case 4:
			System.out.println("update operation");
			app.updateTable();
			break;
		case 5:
			System.out.println("drop operation");
			app.dropTable();
			break;
			
		}//switch
		scan.close();
	}
	
}
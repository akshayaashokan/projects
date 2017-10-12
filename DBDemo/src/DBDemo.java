import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.*;
;
public class DBDemo {

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
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
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
	 */
	public void run() {

		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}

		// Create a table
		/*try {
		    String createString =
			        "CREATE TABLE " + this.tableName + " ( " +
			        "ID INTEGER NOT NULL, " +
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
			e.printStackTrace();
			return;
		}
		*/
		// Drop the table
	/*	try {
		    String dropString = "DROP TABLE " + this.tableName;
			this.executeUpdate(conn, dropString);
			System.out.println("Dropped the table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not drop the table");
			e.printStackTrace();
			return;
		} */
		
		//inserting a value into the table
	Statement stmt = null;
		/*try {
		
		 stmt = conn.createStatement();
	      			
				String sql = "INSERT INTO JDBC_TEST " +
		                   "VALUES (2,'akshata','vyttila','ekm','kl','68')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO JDBC_TEST " +
	                   "VALUES (3,'anjali','vyttila','ekm','kl','68')";
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO JDBC_TEST " +
                  "VALUES (4,'afeefa','vyttila','ekm','tn','88')";
     stmt.executeUpdate(sql);
		      System.out.println("Inserted records into the table...");

		}
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try*/
	
		//updating an existing value in table
		 //STEP 4: Execute a query
	/*	try {
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql = "UPDATE JDBC_TEST " +
	                   "SET state = 'tn' WHERE id in (1)";
	      stmt.executeUpdate(sql);
	      System.out.println("update done");
	     		
	}catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try */
	
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
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	}
	
	
	/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		DBDemo app = new DBDemo();
		app.run();
	}
}

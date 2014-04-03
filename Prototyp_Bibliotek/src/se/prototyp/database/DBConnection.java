package se.prototyp.database;

import java.sql.*;

public class DBConnection {
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public Connection createConnection() {
	Connection localConn = null;

	try { 
	    Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException cnfe) {
	    System.err.println("Couldn't find driver class:");
	    cnfe.printStackTrace();
	    System.exit(1);
	}
	System.out.println("Everything seems ok!");
  
	try {
	    localConn = DriverManager.getConnection("jdbc:mysql://192.168.1.15:3306/prototyp_bibliotek","frud", "ultrajacka112");
//	    localConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prototyp_bibliotek","root", "");
	} catch (SQLException se) {
	    System.out.println("Couldn't connect: print out a stack trace and exit.");
	    se.printStackTrace();
	    System.exit(1);
	}
  
	if (localConn != null)
	    System.out.println("Congratulations! You are now connected to the database!");
	else
	    System.out.println("We should never get here.");

	return localConn;
    }

    public void runDB(){
    	connection = createConnection();
    }
    
    public DBConnection(){
    	runDB();
    }
}

package se.prototyp.database;

import java.sql.*;
import java.util.ArrayList;

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
//	System.out.println("Everything seems ok!");
  
	try {
//		localConn = DriverManager.getConnection("jdbc:mysql://46.239.118.12:3306/prototyp_bibliotek","frud", "ultrajacka112");
	    localConn = DriverManager.getConnection("jdbc:mysql://192.168.1.15:3306/prototyp_bibliotek","frud", "ultrajacka112");
//	    localConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/prototyp_bibliotek","root", "chocs");
//	    localConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prototyp_bibliotek","root", "");
	    
	} catch (SQLException se) {
	    System.out.println("Couldn't connect: print out a stack trace and exit.");
	    se.printStackTrace();
	    System.exit(1);
	}
  
	if (localConn != null)
	    System.out.println("");
		//System.out.println("Congratulations! You are now connected to the database!");
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
	public boolean checkUserExistance(String userName, String password){
    	boolean memberExist = false;
    	try{
    		preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE UserName = ? AND Password = ?");
    		preparedStatement.setString(1, userName);
    		preparedStatement.setString(2, password);
    		resultSet = preparedStatement.executeQuery();
    		if(resultSet.next()){
    			memberExist = true;
    		}
    	}
    	catch(SQLException se){
    		System.out.println(se.getMessage());
    	}
    	return memberExist;
    }
	
	public boolean addUser(String userName, String firstName, String familyName, String password){
		boolean userAdded = false;
		try{
			preparedStatement = connection.prepareStatement("INSERT INTO user (UserName, FirstName, SecondName, Password) VALUES(?,?,?,?)");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, familyName);
			preparedStatement.setString(4, password);
			int change = preparedStatement.executeUpdate();
			if(change > 0){
				userAdded = true;
			}
		}
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
		return userAdded;
	}
	public ArrayList<String> getBooks(){
		ArrayList<String> list = new ArrayList<String>();
		String bookLine;
		try{
			preparedStatement = connection.prepareStatement("SELECT * from litterature");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				bookLine = "";
				bookLine = bookLine + "ID: " +  String.valueOf(resultSet.getInt(1));
				bookLine = bookLine + "Titel: " + resultSet.getString(2);
				list.add(bookLine);
			}
		}
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
		return list;
	}
	public ArrayList<String> getBooks(String title){
		ArrayList<String> list = new ArrayList<String>();
		String bookLine;
		try{
			preparedStatement = connection.prepareStatement("SELECT * from litterature WHERE Titel = ?");
			preparedStatement.setString(1, title);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				bookLine = "";
				bookLine = bookLine + "ID: " +  String.valueOf(resultSet.getInt(1));
				bookLine = bookLine + "Titel: " + resultSet.getString(2);
				list.add(bookLine);
			}
		}
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
		return list;
	}
	public int addLiterature(String title){
		int change = 0;
		try{
			preparedStatement = connection.prepareStatement("INSERT INTO litterature (Titel) VALUES (?)");
			preparedStatement.setString(1, title);
			change = preparedStatement.executeUpdate();
		}
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
		return change;
		
	}
	public int getNumberOfTitles(){
		int amount = 0;
		try{
			preparedStatement = connection.prepareStatement("SELECT * from litterature");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				amount++;
			}
		}
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
		return amount;
		
	}
	public ArrayList<String> getLoans(){
		ArrayList<String> list = new ArrayList<String>();
		String loanLine;
		try{
			//SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
			//FROM Orders
			//INNER JOIN Customers
			//ON Orders.CustomerID=Customers.CustomerID;
			//preparedStatement = dbConnect.connection.prepareStatement("SELECT UserName FROM user_lantagare WHERE ID IN (SELECT User FROM loans)");
			preparedStatement = connection.prepareStatement("SELECT user_lantagare.UserName, litterature.Titel FROM loans INNER JOIN user_lantagare ON user_lantagare.ID = loans.User INNER JOIN litterature ON litterature.ID = loans.Litterature");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				loanLine = "";
				loanLine = loanLine + "Låntagare: " + resultSet.getString(1);
				loanLine = loanLine + "| Lånat verk: " + resultSet.getString(2);
				list.add(loanLine);
			}
		}
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
		
		return list;
	}
	public ArrayList<String> getUserInfoDB(String userName, String password){
		ArrayList<String> list = new ArrayList<String>();
		try{
			preparedStatement = connection.prepareStatement("SELECT * from user WHERE UserName = ? AND Password = ?");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				list.add(String.valueOf(resultSet.getInt(1)));
				list.add(resultSet.getString(2));
				list.add(resultSet.getString(3));
				list.add(resultSet.getString(4));
				list.add(resultSet.getString(5));
			}


		}
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
		return list;
	}

	public boolean editUserDB(int id, String userName, String firstName, String familyName, String password){
		boolean edited = false;
		try{
			preparedStatement = connection.prepareStatement("UPDATE user SET UserName = ?, FirstName = ?, SecondName = ?, Password = ? WHERE ID = ?");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, familyName);
			preparedStatement.setString(4, password);
			preparedStatement.setInt(5,id);
			int numOfRowsEdited = preparedStatement.executeUpdate();
			if(numOfRowsEdited>0){
				edited = true;
			}
		}
		catch(SQLException sqle){
			System.out.println(sqle.getMessage());
		}
		return edited;

	}
}

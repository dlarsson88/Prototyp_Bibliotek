package se.prototyp.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBOperations {

	DBConnection dbConnect = new DBConnection();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
	public boolean checkUserExistance(String userName, String password){
    	boolean memberExist = false;
    	try{
    		preparedStatement = dbConnect.connection.prepareStatement("SELECT * FROM user WHERE UserName = ? AND Password = ?");
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
			preparedStatement = dbConnect.connection.prepareStatement("INSERT INTO user (UserName, FirstName, SecondName, Password) VALUES(?,?,?,?)");
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
			preparedStatement = dbConnect.connection.prepareStatement("SELECT * from litterature");
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
		

	
}

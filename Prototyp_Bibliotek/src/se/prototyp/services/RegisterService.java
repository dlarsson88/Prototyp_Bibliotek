package se.prototyp.services;

import se.prototyp.database.DBOperations;

public class RegisterService {

	DBOperations dbo = new DBOperations();
	
	public boolean addUser(String userName, String firstName, String familyName, String password){
		if(dbo.addUser(userName, firstName, familyName, password)){
			return true;
		}
		else{
			return false;
		}
	}
}

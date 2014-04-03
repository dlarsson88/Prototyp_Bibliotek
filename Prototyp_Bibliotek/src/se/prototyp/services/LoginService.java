package se.prototyp.services;
import se.prototyp.database.DBOperations;

public class LoginService {

	DBOperations dbo = new DBOperations();
	
	public boolean authenticate(String userName, String password){
		if(dbo.checkUserExistance(userName, password)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}

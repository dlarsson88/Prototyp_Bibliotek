/* En klass f�r att se om en viss anv�ndare redan existerar i databasen */

package se.prototyp.services;
import se.prototyp.database.DBOperations;

public class LoginService extends se.prototyp.database.DBConnection{

	public boolean authenticate(String userName, String password){
		if(checkUserExistance(userName, password)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}

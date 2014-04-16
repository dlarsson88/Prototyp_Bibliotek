/* En klass f�r att kolla om viss data existerar i databasen */

package se.prototyp.services;

public class DBConsistencyService extends se.prototyp.database.DBConnection{

	public boolean checkIfPasswordExists(String password){
		return checkIfPasswordExistsDB(password);
	}
	public boolean checkIfUserNameExists(String userName){
		return checkIfUserNameExistsDB(userName);
	}
	public boolean checkIfLiteratureExists(String title){
		return checkIfLiteratureExistsDB(title);
	}
	
}

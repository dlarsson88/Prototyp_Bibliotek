/* En klass för att uppdatera användarinformation */

package se.prototyp.services;

public class EditUserService extends se.prototyp.database.DBConnection {

	public boolean editUser(int id, String userName, String firstName, String familyName, String password){
		return editUserDB(id, userName, firstName, familyName, password);
	}
}

/* En klass för att hämta ut användarinformation ur databasen */

package se.prototyp.services;

import java.util.ArrayList;

public class GetUserInfoService extends se.prototyp.database.DBConnection{

	public ArrayList<String> getUserInfo(String userName, String password){
		ArrayList<String> returnedList = getUserInfoDB(userName, password);
		return returnedList;
	}
}

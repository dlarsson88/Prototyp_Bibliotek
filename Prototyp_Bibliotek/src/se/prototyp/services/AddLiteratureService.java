/* En klass för att lägga till ny litteratur i databasen */

package se.prototyp.services;

import se.prototyp.database.DBOperations;

public class AddLiteratureService {

	DBOperations dbo = new DBOperations();
	
	public int addLiterature(String title){
		return dbo.addLiterature(title);
	}
	
}

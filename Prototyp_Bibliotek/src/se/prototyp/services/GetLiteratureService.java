/* En klass för att hämta ut data om litteratur ur databasen*/

package se.prototyp.services;

import java.util.ArrayList;
import se.prototyp.database.DBOperations;

public class GetLiteratureService {

	DBOperations dbo = new DBOperations();
	
	public ArrayList<String> getLiterature(){
		return dbo.getBooks();
	}
	public ArrayList<String> getLiterature(String title){
		return dbo.getBooks(title);
	}
	public int getNumberOfTitles(){
		return dbo.getNumberOfTitles();
	}
}

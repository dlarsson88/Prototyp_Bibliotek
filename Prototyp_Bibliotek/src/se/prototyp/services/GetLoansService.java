/* En klass f�r att h�mta ut data om l�n ur databasen */

package se.prototyp.services;

import java.util.ArrayList;

import se.prototyp.database.DBOperations;

public class GetLoansService {

	DBOperations dbo = new DBOperations();
	
	public ArrayList<String> getLoans(){
		return dbo.getLoans();
	}
	
}

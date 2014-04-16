/* En klass för att hämta ut data om lån ur databasen */

package se.prototyp.services;

import java.util.ArrayList;

import se.prototyp.database.DBOperations;

public class GetLoansService {

	DBOperations dbo = new DBOperations();
	
	public ArrayList<String> getLoans(){
		return dbo.getLoans();
	}
	
}

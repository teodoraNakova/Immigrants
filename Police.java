package police;

import weapon.IRadicalExtremist;
import immigrant.Immigrant;
import country.City;
import country.Country;

public abstract class Police {

	private String name;
	private Country workCountry;
	private City workCity;
	
	public Police(String name, Country workCountry) {
		this.name = name;
		this.workCountry = workCountry;
	}

	public boolean checkImmigrant(Immigrant immigrant) {
		if(immigrant instanceof IRadicalExtremist) {
			if(this.attemptToCatch(immigrant) && immigrant.checkForPassport()) {
				System.out.println("Immigrant not allowed in the city.");
				return false;
			}
		} 
		return true;
	}

	public abstract boolean attemptToCatch(Immigrant immigrant);
}

package passport;

import country.City;
import country.Country;

public class Passport {

	private String immigrantName;
	private int immigrantAge;
	private String bornCountry;
	private String bornCity;
	
	public Passport(String immigrantName, int immigrantAge, String bornCountry, String bornCity) {
		this.immigrantName = immigrantName;
		this.immigrantAge = immigrantAge;
		this.bornCountry = bornCountry;
		this.bornCity = bornCity;
	}
	
	
}

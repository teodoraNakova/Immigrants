package police;

import java.util.Random;

import immigrant.Immigrant;
import country.City;
import country.Country;

public class PoliceMan extends Police {

	public PoliceMan(String name, Country workCountry) {
		super(name, workCountry);
	}

	@Override
	public boolean attemptToCatch(Immigrant immigrant) {
		if(new Random().nextInt(100) < 50) {
			return true;
		}
		return false;
	}

	
}

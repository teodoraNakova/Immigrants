package police;

import java.util.Random;

import immigrant.Immigrant;
import country.City;
import country.Country;

public class SpecialForce extends Police {

	public SpecialForce(String name, Country workCountry) {
		super(name, workCountry);
	}

	@Override
	public boolean attemptToCatch(Immigrant immigrant) {
		if(new Random().nextInt(100) < 90) {
			return true;
		}
		return false;
	}

}

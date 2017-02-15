package immigrant;

import country.Country;

public abstract class ImmigrantsWithoutPassports extends Immigrant {

	public ImmigrantsWithoutPassports (String name, int money, Country currentCountry) {
		super(name, money, currentCountry);
	}
}

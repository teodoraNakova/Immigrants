package immigrant;

import country.Country;
import passport.Passport;

public abstract class ImmigrantsWithPassports extends Immigrant {
	
	private Passport passport;

	public ImmigrantsWithPassports(String name, int money, Passport passport, Country currentCountry) {
		super(name, money, currentCountry);
		this.passport = passport;
	}

	public Passport getPassport() {
		return passport;
	}
	
	
	
}

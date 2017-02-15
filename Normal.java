package immigrant;

import country.Country;
import passport.Passport;
import weapon.Weapon;

public class Normal extends ImmigrantsWithPassports {

	public Normal(String name, int money, Passport passport, Country currentCountry) {
		super(name, money, passport, currentCountry);
	}

	@Override
	public boolean buyWeapon(Weapon w) {
		return false;
	}

	@Override
	public boolean checkForPassport() {
		return true;
	}

	@Override
	public void useWeapon() {
		System.out.println("Peace!");	
	}

}

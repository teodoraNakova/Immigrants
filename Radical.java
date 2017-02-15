package immigrant;

import java.util.ArrayList;

import country.Country;
import passport.Passport;
import weapon.IRadicalExtremist;
import weapon.IRadicalWeapon;
import weapon.Weapon;

public class Radical extends ImmigrantsWithPassports implements IRadicalExtremist {
	
	private ArrayList<IRadicalWeapon> weapons = new ArrayList<IRadicalWeapon>();

	public Radical(String name, int money, Passport passport, Country currentCountry) {
		super(name, money, passport, currentCountry);
	}

	public ArrayList<IRadicalWeapon> getWeapons() {
		return weapons;
	}

	@Override
	public boolean buyWeapon(Weapon w) {
		if(w instanceof IRadicalWeapon) {
			if(this.getMoney() > w.getPrice()) {
				this.getWeapons().add((IRadicalWeapon) w);
				this.setMoney(this.getMoney() - w.getPrice());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkForPassport() {
		ImmigrantsWithPassports i = (ImmigrantsWithPassports) this;
		if(i.getPassport() != null) {
			return true;
		}
		return false;
	}

	@Override
	public void useWeapon() {
		int victims = 0;
		if (this.getWeapons() != null) {
			for(IRadicalWeapon weapon: this.getWeapons()) {
				victims += weapon.makeAShot();
			}
		}
		int peopleBeforeTheShots = this.getCurrentCity().getCountPeople();
		this.getCurrentCity().setCountPeople(peopleBeforeTheShots - victims);	
	}
}

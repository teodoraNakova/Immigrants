package immigrant;

import java.util.ArrayList;

import country.Country;
import weapon.Bomb;
import weapon.IRadicalExtremist;
import weapon.Weapon;

public class Extremist extends ImmigrantsWithoutPassports implements IRadicalExtremist {

	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	
	public Extremist(String name, int money, Country currentCountry) {
		super(name, money, currentCountry);
	}
	
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	@Override
	public boolean buyWeapon(Weapon w) {
		if(this.getMoney() > w.getPrice()) {
			this.getWeapons().add(w);
			this.setMoney(this.getMoney() - w.getPrice());
			return true;
		}
		return false;
	}

	@Override
	public boolean checkForPassport() {
		return false;
	}

	@Override
	public void useWeapon() {
		if(this.getWeapons() != null) {
			for(Weapon weapon : this.getWeapons()) {
				if(weapon instanceof Bomb) {
					System.out.println("Extremist just blew a bomb, everyone died.");
					this.getCurrentCountry().getCities().remove(this.getCurrentCity());
					return;
				}
			}
			
		}	
		
	}
}

package immigrant;

import java.util.ArrayList;
import java.util.Random;

import police.Police;
import weapon.IRadicalWeapon;
import weapon.Weapon;
import country.City;
import country.Country;

public abstract class Immigrant {

	private String name;
	private int money;
	private Country currentCountry;
	private City currentCity;
	private ArrayList<Immigrant> relatives;
	
	public Immigrant(String name, int money, Country currentCountry) {
		this.name = name;
		this.money = money;
		this.relatives = new ArrayList<Immigrant>();
		this.currentCountry = currentCountry;
		this.currentCity = new City("Unknown", 1000, new ArrayList<Police>());
	}
	
	public ArrayList<Immigrant> getRelatives() {
		return relatives;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public abstract boolean buyWeapon(Weapon w);

	public void attemptImmigration(City city) {
		this.assignPolice(city);
		
	}

	private void assignPolice(City city) {
		ArrayList<Police> police = city.getPolice();
		int randomOfficer = new Random().nextInt(police.size());
		Police officer = police.get(randomOfficer);
		boolean isAllowed = officer.checkImmigrant(this);
		if(isAllowed) {
			city.getImigrants().add(this);
			this.setCurrentCity(city);
		}
	}
	
	private void setCurrentCity(City city) {
		this.currentCity = city;	
	}
	
	public City getCurrentCity() {
		return currentCity;
	}

	public abstract boolean checkForPassport();

	public String getName() {
		return this.name;
	}
	
	public Country getCurrentCountry() {
		return currentCountry;
	}

	public abstract void useWeapon();
	
	
}

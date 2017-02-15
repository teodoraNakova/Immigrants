import immigrant.Extremist;
import immigrant.Immigrant;
import immigrant.Normal;
import immigrant.Radical;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import country.City;
import country.Country;
import passport.Passport;
import weapon.Automat;
import weapon.Bomb;
import weapon.Gun;
import weapon.Weapon;


public class Demo {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		//1
		Country bulgaria = new Country("Bulgaria");
		//2
		ArrayList<Immigrant> allImmigrants = new ArrayList<Immigrant>();
		for(int i = 0; i < 100; i++) {
			int randIdx = r.nextInt(100);
			if(randIdx < 25) {
				int passportChance = r.nextInt(100);
				if(passportChance < 35) {
					Passport p = new Passport("Some name", 25, "Some country", "Some city");
					Radical radical = new Radical("Radical name", 1000, p, bulgaria);
					allImmigrants.add(radical);
				} else {
					Radical radical = new Radical("Radical name", 1000, null, bulgaria);
					allImmigrants.add(radical);
				}
				
			}
			if(randIdx >= 25 && randIdx <= 60) {
				Extremist extremist = new Extremist("Extremist name", 1000, bulgaria);
				allImmigrants.add(extremist);
			}
			if(randIdx > 60) {
				Normal normal = new Normal("Normal name", 1000, new Passport("Some name", 25, "Some country", "Some city"), bulgaria);
				allImmigrants.add(normal);
			}
		}
		
		for(int i = 0; i < allImmigrants.size(); i++) {
			int randomRelative1 = 0;
			int randomRelative2 = 0;
			do{
				randomRelative1 = r.nextInt(100);
				randomRelative2 = r.nextInt(100);
			} while(randomRelative1 == i || randomRelative2 == i);
			ArrayList<Immigrant> relatives = allImmigrants.get(i).getRelatives();
			relatives.add(allImmigrants.get(randomRelative1));
			relatives.add(allImmigrants.get(randomRelative2));
		}
		
		//3
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		for(int i = 0; i < 200; i++) {
			int randomIdx = r.nextInt(3);
			int randomPrice = r.nextInt(400) + 1;
			if(randomIdx == 0) {
				Gun gun = new Gun(randomPrice);
				weapons.add(gun);
			}
			if(randomIdx == 1) {
				Bomb bomb = new Bomb(randomPrice);
				weapons.add(bomb);
			}
			if(randomIdx == 2) {
				Automat automat = new Automat(randomPrice);
				weapons.add(automat);
			}
		}
		for(int i = 0; i < allImmigrants.size(); i++) {
			if(weapons.size() < 5) {
				break;
			}
			for(int j = 0; j < 5; j++) {
				int randIdx = r.nextInt(weapons.size());
				if(allImmigrants.get(i).buyWeapon(weapons.get(randIdx))) {
					weapons.remove(randIdx);
				}
			}
		}
		
		//4
		for(Immigrant immigrant : allImmigrants) {
			ArrayList<City> cities = bulgaria.getCities();
			int cityIdx = r.nextInt(cities.size());
			immigrant.attemptImmigration(cities.get(cityIdx));
		}
		
		//5
		for(Immigrant immigrant : allImmigrants) {
			if(immigrant.getCurrentCity() != null) {
				System.out.println("Current city: " + immigrant.getCurrentCity().getName());
			} else {
				System.out.println("Current city: Unknown.");
			}		
			System.out.println(immigrant.checkForPassport() ? "The immigrant has a passport." : "The immigrant does not have a passport.");
			System.out.println("Euro on hand: " + immigrant.getMoney());
			for(Immigrant relative : immigrant.getRelatives()) {
				System.out.println("Relative name: " + relative.getName());
			}
			System.out.println("=============");
		}

		//6
		for(int i = 0; i < 20; i++) {
			int randomIdx = r.nextInt(allImmigrants.size());
			allImmigrants.get(randomIdx).useWeapon();
		}
		
		//7
		ArrayList<City> cities = bulgaria.getCities();
		if(cities.size() != 0) {
			cities.sort(new Comparator<City>() {
				@Override
				public int compare(City o1, City o2) {
					return o1.getCountPeople() - o2.getCountPeople();
				}
			});
			for(City city : cities) {
				System.out.println("Name of the city:" + city.getName() + ". Survivors: " + city.getCountPeople());
			}
		} else {
			System.out.println("Terrorists destroyed everything.");
		}
		
		
		allImmigrants.sort(new Comparator<Immigrant>() {

			@Override
			public int compare(Immigrant o1, Immigrant o2) {
				return o1.getMoney() - o2.getMoney();
			}
		});
		for(Immigrant immigrant : allImmigrants) {
			System.out.println(immigrant.getName() + " has " + immigrant.getMoney() + " euro.");
		} 
	}

}

package country;

import java.util.ArrayList;
import java.util.Random;

import police.Police;
import police.PoliceMan;
import police.SpecialForce;

public class Country {

	private String name;
	private ArrayList<City> cities = new ArrayList<City>();
	
	public Country(String name) {
		if(name != null && name.isEmpty()) {
			this.name = name;
		} 
		ArrayList<Police> police = generatePolice();
		for(int i = 0; i < 5; i++) {
			int randomPeople = new Random().nextInt(10000) + 1000;
			City city = new City("City" + i, randomPeople, police);
			cities.add(city);
		}
	}
	
	public ArrayList<City> getCities() {
		return cities;
	}
	
	private ArrayList<Police> generatePolice() {
		PoliceMan policeMan1 = new PoliceMan("Random name", this);
		SpecialForce specPolice1 = new SpecialForce("Random name", this);
		ArrayList<Police> police = new ArrayList<Police>();
		police.add(policeMan1);
		police.add(specPolice1);
		police.add(policeMan1);
		police.add(specPolice1);
		police.add(policeMan1);
		police.add(specPolice1);
		return police;
	}
	
}

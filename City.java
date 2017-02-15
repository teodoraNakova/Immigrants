package country;

import immigrant.Immigrant;

import java.util.ArrayList;
import java.util.HashMap;

import police.Police;

public class City {

	private String name;
	private ArrayList<Police> police;
	private int countPeople;
	private ArrayList<Immigrant> imigrants = new ArrayList<Immigrant>();
	
	public City(String name, int countPeople, ArrayList<Police> police) {
		this.name = name;
		this.countPeople = countPeople;
		this.police = police;
	}
	
	public ArrayList<Police> getPolice() {
		return police;
	}
	
	public ArrayList<Immigrant> getImigrants() {
		return imigrants;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCountPeople() {
		return countPeople;
	}
	
	public void setCountPeople(int countPeople) {
		this.countPeople = countPeople;
	}
	
}


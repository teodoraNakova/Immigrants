package weapon;

public class Automat extends Weapon implements IRadicalWeapon{

	public Automat(int price) {
		super(price);
	}

	@Override
	public int makeAShot() {
		System.out.println("Radical immigrant fired an automat.");
		return 40;
	}
}

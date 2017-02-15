package weapon;

public class Gun extends Weapon implements IRadicalWeapon{

	public Gun(int price) {
		super(price);
	}

	@Override
	public int makeAShot() {
		System.out.println("Radical immigrant fired a gun.");
		return 6;
	}

	
}

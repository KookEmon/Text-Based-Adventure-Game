package classes;
import interfaces.Monster;

public class MyMonster extends MyCreature implements Monster {
	private int enrageThreshold = 0;
	private boolean alreadyEnraged = false; //Boolean for preventing the monster from getting enraged multiple times.
	

	public MyMonster(String name, String description, int hitPoints, int damage, int enrageThreshold) {
		super(name, description, hitPoints, damage);
		this.enrageThreshold = enrageThreshold;

	}

	@Override
	public void enrage() {
		if(alreadyEnraged == false) {
			if(canEnrage() == true) {
				super.setDamage(super.getDamage() * 2);
				System.out.println(super.getName() + " has been enraged.");
				System.out.println(super.getName() + " now has " + super.getDamage() + " damage.");
				alreadyEnraged = true;
			}
		}
	}

	@Override
	public boolean canEnrage() {
		if(super.getHitPoints() <= this.enrageThreshold)
			return true;
		else
			return false;
	}

}

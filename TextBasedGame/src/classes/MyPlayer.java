package classes;
import interfaces.Player;


public class MyPlayer extends MyCreature implements Player {
	private int healAmount;
	
	public MyPlayer(String name, String description, int hitPoints, int damage, int healAmount) {
		super(name, description, hitPoints, damage);
		this.healAmount = healAmount;
	}

	@Override
	public void heal() {
		super.setHitPoints(super.getHitPoints() + this.healAmount);
		//Prevents hitpoints from going above 150.
		if (super.getHitPoints() > 150) {
			super.setHitPoints(150);
		}
		System.out.println(super.getName() + " is healed by " + this.healAmount);
	}

}
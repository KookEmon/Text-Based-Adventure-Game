package classes;
import interfaces.Creature;


public class MyCreature extends Object implements Creature {
	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	private MyRoom room = null;

	public MyCreature (String name, String description, int hitPoints, int damage) {
		this.name = name;
		this.description = description;
		this.hitPoints = hitPoints;
		this.damage = damage;
	}
	
	
	
	
	public void attack(MyCreature creature) {
		System.out.println(this.name + " attacks target " + creature.getName() + ", dealing " + damage + " damage.");
		
	}

	@Override
	public void takeDamage(int damage) {
		hitPoints -= damage;
		if(hitPoints < 0)
			hitPoints = 0;
	}

	@Override
	public boolean isAlive() {
		if (hitPoints > 0)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return String.format("name %15s, description %20s, hitPoints %03d, damage %02d", name, description, hitPoints, damage);
	}



	public String getName() {
		return name;
	}



	public String getDescription() {
		return description;
  	}



	public int getHitPoints() {
		return hitPoints;
	}



	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}



	public int getDamage() {
		return damage;
	}



	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public MyRoom getRoom() {
		return room;
	}
	
	public void setRoom​(MyRoom room) {
		this.room = room;
	}



}

package classes;
import interfaces.Room;

public class MyRoom extends Object implements Room {
	private int roomIndex;
	private String description;
	private MyMonster monster;
	
	public MyRoom(int roomIndex, String description, MyMonster monster) {
		this.roomIndex = roomIndex;
		this.description = description;
		this.monster = monster;
	}
	
	@Override
	public boolean isComplete() {
		if (monster.isAlive() == false)
			return true;
		else
			return false;
	}

	public void enter (MyPlayer player) {
		// Initiates the battle.
		if(monster.getName().equals("Orc")) {
			System.out.println(player.getName() + " This Room is " + this.description + ", and has an " + monster.getName() + ".");
			printBattleStats(player);
		}
		
		else {
			System.out.println(player.getName() + " This Room is " + this.description + ", and has a " + monster.getName() + ".");
			printBattleStats(player);
		}
		
		if (isComplete() == false) {
			MyBattle battle = new MyBattle(player, monster);
			battle.run();
		}
		
	}
	
	public java.lang.String toString() {
		return String.format("Room index %2d, description %20s, monster name %20s", roomIndex, description, monster);
	}
	
	// Prints name, damage, and hitpoints for the player and the monster before battle begins.
	public void printBattleStats(MyPlayer player) {
		System.out.println(player.getName() + " { " + player.getDamage() + " damage, " + player.getHitPoints() + " hitpoints }"
				+ " VS. " + monster.getName() + " { " + monster.getDamage() + " damage, " + monster.getHitPoints() + " hitpoints }");
	}
	
	
}


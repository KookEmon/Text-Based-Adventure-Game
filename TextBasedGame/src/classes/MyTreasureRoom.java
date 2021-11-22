package classes;
import interfaces.Room;

public class MyTreasureRoom extends MyRoom implements Room {
	private String treasure;
	private String description;
	private MyMonster monster;

	public MyTreasureRoom(int roomIndex, String description, MyMonster monster, String treasure) {
		super(roomIndex, description, monster);
		this.treasure = treasure;
	}
	
	public void enter​(MyPlayer player) {
		System.out.println("\"" + player.getName()  + "\"" + "This Room is " + this.description + ", and has this.monster");
		if (isComplete() == false) {
			MyBattle battle = new MyBattle(player, monster);
			battle.run();
		}
		
	}

}
 
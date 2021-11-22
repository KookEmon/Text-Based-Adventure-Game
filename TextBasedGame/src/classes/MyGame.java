package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import interfaces.Game;

public class MyGame extends Object implements Game {

	String log = ""; //String used for GameLog.txt. (Miguel Gonzalez helped me with writing the GamLog)
	

	public MyGame() {
	}
	
	@Override
	public void play() throws FileNotFoundException {
		// Reads and creates player.
		File file = new File("PlayerInfo.txt");
		Scanner x = new Scanner(file);
		String playerName = x.nextLine();
		String playerDescription = x.nextLine();
		int playerHitPoints = x.nextInt();
		int playerDamage = x.nextInt();
		int playerHeal = x.nextInt();
		MyPlayer kratos = new MyPlayer(playerName, playerDescription, playerHitPoints, playerDamage, playerHeal);
		
		MyMonster orc = new MyMonster("Orc", "Covered with green blood", 20, 5, 0);
		MyMonster skeleton = new MyMonster("Skeleton", "Funny how it moves", 40, 10, 10);
		MyMonster dragon = new MyMonster("Fire Dragon", "Spout fire with each breath", 100, 20, 40);
		
		MyRoom room0 = new MyRoom(0, "a room with an unbearable smell", orc);
		MyRoom room1 = new MyRoom(1, "dark and cold", skeleton);
		MyTreasureRoom room2 = new MyTreasureRoom(2, "a giant hall with something shiny on the other end", dragon, "Tresure");
		
		// Creates array and stores the rooms;
		MyRoom dungeon[] = new MyRoom[3];
        dungeon[0] = room0;
        dungeon[1] = room1;
        dungeon[2] = room2;
        
        log += ("Player's name: " + kratos.getName() + "\n");
        
        // Loop for player to enter each dungeon.
        // (Miguel Gonzalez helped me with this loop)
        for(int i = 0; i < dungeon.length; i++) {
        	dungeon[i].enter(kratos);
        	
        	if(kratos.isAlive() && dungeon[i].isComplete()) {
        		log+= "Room " + (i+1) + " has been completed by " + kratos.getName() + ".\n";
            }
        	else {
        		log+= kratos.getName() + " died in room " + (i+1) + "\n";
        	}
        }
        	log += "THE END.";
        	TextFileHandler handler = new TextFileHandler();
        	handler.writeToNewFile("GameLog.txt", log);
	}
		
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// Creates a game object and calls play() method.
		MyGame game = new MyGame();
		game.play();
    }
}

package classes;
import interfaces.Battle;

import java.util.Scanner;

public class MyBattle extends Object implements Battle {
	private MyPlayer player;
	private MyMonster monster;
	Scanner sc = new Scanner(System.in);
	
	public MyBattle(MyPlayer player, MyMonster monster) {
		this.player = player;
		this.monster = monster;
	}

	@Override
	public void run() {
		//(Miguel Gonzalez helped me with this method)
		//Lets the player attack or heal using "A" or "H".
		while(monster.isAlive() == true && player.isAlive() == true) {
            System.out.println(player.getName() + "'s turn.");
            System.out.println("Press A to attack or Type H to heal.");
            String move = sc.next();
            if(move.equalsIgnoreCase("H")) {
                player.heal();
                System.out.println(player.getName() + " now has " + player.getHitPoints() + " hitpoints");
            }
            else if (move.equalsIgnoreCase("A")) {
                player.attack(monster);
                monster.takeDamage(player.getDamage());
                System.out.println(monster.getName() + " now has " + monster.getHitPoints() + " hitpoints.");
            }
            else {
                System.out.println("Invalid input. Press A to attack or Type H to heal.");
                while(!move.equalsIgnoreCase("A") && !move.equalsIgnoreCase("H")) {
                	move = sc.next();
                    	if(move.equalsIgnoreCase("H")) {
                    		player.heal();
                    		System.out.println(player.getName() + " healed to " + player.getHitPoints() + " hitpoints");
                    	}
                    	else if (move.equalsIgnoreCase("A")) {
                    	player.attack(monster);
                    	monster.takeDamage(player.getDamage());
                    	System.out.println(monster.getName() + " now has " + monster.getHitPoints() + " hitpoints.");
                    	}
                    	else {
                    	System.out.println("Invalid input. Press A to attack or Type H to heal.");
                    	}
                }
           
            }
            //Lets the monster attack and enrage.
            if (monster.isAlive() == true) {
            	System.out.println(monster.getName() + "'s turn.");
            	monster.enrage();
            	monster.attack(player);
            	player.takeDamage(monster.getDamage());
            	System.out.println(player.getName() + " now has " + player.getHitPoints() + " hitpoints.");
            }
            
		}
			//Prints if player beats the game;
			if(monster.getName().equals("Fire Dragon") && monster.isAlive() == false) {
				System.out.println("Congratulations. You Win!");
				System.out.println("You explored the room and found the hidden treasure!");
			}
	}
}
		
	



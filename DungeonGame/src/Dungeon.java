import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Dungeon {
	static String answer;
	static ArrayList<Monster> dungeon = new ArrayList<Monster>();
	static ArrayList<Monster> monsters = new ArrayList<Monster>();
	public static void main(String[]args) {
		
		Player p1 = new Player(40);
		
		for(int i = 0; i < 10; i++) {
			if(i >= 0 && i < 5) {
				Monster skeleton = new Monster("Skeleton", 2);
				monsters.add(skeleton);
			} else if(i >= 5 && i < 7) {
				Monster goblin = new Monster("Goblin", 5);
				monsters.add(goblin);
			} else if(i >=7 && i < 8) {
				Monster witch = new Monster("Witch", 8);
				monsters.add(witch);
			} else {
				Monster dragon = new Monster("Dragon", 10);
				monsters.add(dragon);
			}
		}
		dungeon.add(monsters.get(getRandom()));
		ask(p1);
	}
	
	public static void ask(Player p1) {
		Scanner in = new Scanner(System.in);
		System.out.println("Are you ready to enter a dungeon? Y/N");
		answer = in.next();
		
		
			if(answer.equals("y")) {
				enteredToDungeon(p1);
				
			} else if(answer.equals("n")) {
				dungeon.add(monsters.get(getRandom()));
				ask(p1);
	
			} else {
				System.out.println("Wrong answer");
				}
			in.close();
	}
	
	public static int getRandom(){
		   Random r = new Random();
		   int high = 9;
		   int result = r.nextInt(high);
		   return result;
		}

	public static void enteredToDungeon(Player p1) {
		for(int j = 0; j < dungeon.size(); j++) {
			p1.health -= dungeon.get(j).strength;
			System.out.println("Monster " + (j+1) + " is a " + dungeon.get(j).name + ". It deals " + dungeon.get(j).strength
					+ " damage to you, leaving you with " + p1.health + " health");
		}
		if(p1.health > 0) {
			int score = 0;
			for(int t = 0; t < dungeon.size(); t++) {
				score += dungeon.get(t).strength;
			}
			System.out.println("Concratulation you won. Your score: " + score);
		} else {
			System.out.println("You lose");
		}
	}
}

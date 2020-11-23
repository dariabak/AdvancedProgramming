import java.util.Scanner;

public class Railcards {
		
	public static void main(String[]args) {
		int age;
		String name;
		Scanner in = new Scanner(System.in);
		System.out.println("What's your name?");
		name = in.next();
		System.out.println("How old are you?");
		age = in.nextInt();
		
		if(age >= 16 && age <= 25) {
			if(age == 16 || age == 17) {
				System.out.println(name + ", we can offer you two options of card:"
						+ " 1.For those aged 16-25, save a 1/3 off rail fares for days out,"
						+ "seeing family and friends and even festivals!"
						+ "2.For those aged 16 or 17. Enjoy 50% off standard Anytime,"
						+ "Off-Peak, Advance and Season tickets, for just £30 a year.");
			} else {
				System.out.println(name + ", we can offer you one option of card: "
						+ "For those aged 16-25, save a 1/3 off rail fares for days out, "
						+ "seeing family and friends and even festivals!");
			}
		} else if(age >= 26 && age <= 30) {
			System.out.println(name + ", we can offer you one option of card: "
					+ "Valid for those aged 26-30. For just £30,"
					+ " save 1/3 on most rail fares to travel across Britain for a year!");
		} else if(age >= 60) {
			System.out.println(name + ", we can offer you one option of card: "
					+ "For those aged 60 and over, save 1/3 off rail fares for days out, "
					+ "holidays, seeing family and friends, and theatre trips!");
			
		} else {
			System.out.println("Sorry, " + name + " we don't have any card to offer you");
		}
		in.close();
	}
}

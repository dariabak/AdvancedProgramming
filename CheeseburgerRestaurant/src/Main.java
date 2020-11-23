import java.util.Random;

public class Main {

	public static int getRandom(){
		   Random r = new Random();
		   int high = 10;
		   int low = 1;
		   int result = r.nextInt(high) + low;
		   return result;
		}
	
	public static void main (String[]args) {
		Restaurant restaurant = new Restaurant(getRandom());
		
		restaurant.setName("Cheesy");
		
		try {
			 restaurant.serveCheeseBurger();
			 restaurant.serveCheeseBurger();
			 restaurant.serveCheeseBurger();
			 restaurant.serveCheeseBurger();
			 restaurant.serveCheeseBurger();
     		 restaurant.serveCheeseBurger();
     		 restaurant.serveCheeseBurger();
 
        } catch (OutOfStockException ex) {
            System.err.print(ex);
        }


	}
}

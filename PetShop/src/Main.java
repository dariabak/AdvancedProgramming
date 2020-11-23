
public class Main {

	public static void main(String[]args) {
		
		PetShop shop = new PetShop();
		StrokeATron t1 = new StrokeATron();
		
		t1.strokeAll(shop.getAllStrokeablePets());
		
	}
}

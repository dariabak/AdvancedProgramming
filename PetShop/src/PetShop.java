import java.util.ArrayList;
import java.util.Random;

public class PetShop {
	ArrayList<String> petsName = new ArrayList<String>();
	Random r = new Random();
	Pet[] petsInStock;
	
	public PetShop() {
		createArrayOfNames();
		petsInStock = new Pet[10]; 
		for(int i = 0; i <= 9; i++) {
			if(i <= 2) {
				petsInStock[i] = new Dog();
				petsInStock[i].setPetAge(r.nextInt(5));
				petsInStock[i].setPetName(petsName.get(r.nextInt(9)));
				petsInStock[i].setPetCost(r.nextInt(50)+ 20 + r.nextDouble());
			} else if(i > 2 && i <= 4) {
				petsInStock[i] = new Cat();
				petsInStock[i].setPetAge(r.nextInt(5));
				petsInStock[i].setPetName(petsName.get(r.nextInt(9)));
				petsInStock[i].setPetCost(r.nextInt(40)+ 20 + r.nextDouble());
			} else if(i > 4 && i <= 9) {
				petsInStock[i] = new Goldfish();
				petsInStock[i].setPetAge(r.nextInt(3));
				petsInStock[i].setPetName(petsName.get(r.nextInt(9)));
				petsInStock[i].setPetCost(r.nextInt(10) + 2 + r.nextDouble());
			}
		}	
		sortPetsStock();
		
	}
	
	public void buyCat() {
		boolean catIsFound = false;
		for(int i = 0; i < petsInStock.length; i++) {
			if(petsInStock[i] instanceof Cat) {
				System.out.println("Name: " + petsInStock[i].getPetName() + " Age: " + petsInStock[i].getPetAge()
						+ " Price: " + petsInStock[i].getPetCost());
				petsInStock[i] = null;
				catIsFound = true;
				break;
			 }
			}
		if(catIsFound == false) {
			System.out.println("There is no more cats in stock");
		}
	}

	public void buyDog() {
		boolean dogIsFound = false;
		for(int i = 0; i < petsInStock.length; i++) {
			if(petsInStock[i] instanceof Dog) {
				System.out.println("Name: " + petsInStock[i].getPetName() + " Age: " + petsInStock[i].getPetAge()
						+ " Price: " + petsInStock[i].getPetCost());
				petsInStock[i] = null;
				dogIsFound = true;
				break;
			 }
			}
		if(dogIsFound == false) {
			System.out.println("There is no more dogs in stock");
		}
	}
	public void buyGoldfish() {
		boolean fishIsFound = false;
		for(int i = 0; i < petsInStock.length; i++) {
			if(petsInStock[i] instanceof Goldfish) {
				System.out.println("Name: " + petsInStock[i].getPetName() + " Age: " + petsInStock[i].getPetAge()
						+ " Price: " + petsInStock[i].getPetCost());
				petsInStock[i] = null;
				fishIsFound = true;
				break;
			 }
			}
		if(fishIsFound == false) {
			System.out.println("There is no more goldfishes in stock");
		}
	}
	public void buyPetByCost(double cash) {
		boolean petIsFound = false;
		for(Pet a: petsInStock) {
			if(a != null) {
				if(a.getPetCost() < cash) {
					System.out.println(a.getClass());
					petIsFound = true;
					break;
				}
				
			}
		}
		if(petIsFound == false) {
			System.out.println("Sorry, but there is no pet in stock for this price");
		}
		
	}
	public void sortPetsStock() {
		Object temp;
		for(int i = 0; i < petsInStock.length; i++) {
			for(int j = i+1; j < petsInStock.length; j++) {
				if(petsInStock[i].getPetCost() < petsInStock[j].getPetCost()) {      //swap elements if not in order
	                 temp = petsInStock[i]; 
	                 petsInStock[i] = petsInStock[j];
	                 petsInStock[j] = (Pet) temp;
			} 
		}
		}
	}
	
	public ArrayList<Strokeable> getAllStrokeablePets() {
		ArrayList<Strokeable> strokeablePets = new ArrayList<Strokeable>();
		for(Pet a: petsInStock) {
			if(a instanceof Strokeable) {
			  strokeablePets.add((Strokeable) a);
			}
		}
		return strokeablePets;
		
	}
	public void createArrayOfNames() {
		petsName.add("Luna");
		petsName.add("Zoe");
		petsName.add("Lucy");
		petsName.add("Ace");
		petsName.add("Bailey");
		petsName.add("Bb");
		petsName.add("Bessie");
		petsName.add("Billy");
		petsName.add("Dino");
		petsName.add("Dolly");
		
	}
}

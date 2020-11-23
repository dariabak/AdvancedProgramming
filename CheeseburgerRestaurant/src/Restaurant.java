
public class Restaurant {
	int stockLevel;
	String name;

	public Restaurant(int stock) {
		this.stockLevel = stock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void serveCheeseBurger() throws OutOfStockException {		
		if(stockLevel > 0) {
			stockLevel -= 1;
			System.out.println("Cheeseburger!");
		} else {
			throw new OutOfStockException("We are out of stock");
		}
	}
}

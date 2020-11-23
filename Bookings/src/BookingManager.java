import java.util.ArrayList;

public class BookingManager {
	
	private ArrayList<Booking> listOfBookings = new ArrayList<Booking>();
	
	public void addBooking(Booking booking) {
		listOfBookings.add(booking);
	}
	
	public int getNumberOfBookings() {
		return listOfBookings.size();
	}
	
	public double getTotalBookingsValue() {
		double totalValue = 0;
		for(int i = 0; i < listOfBookings.size(); i++) {
			totalValue += listOfBookings.get(i).getCostPerNight() * listOfBookings.get(i).getNumberOfNights();
		}
		return totalValue;
	}
	
	public void clearBookings() {
		listOfBookings.clear();
	}
	
	public ArrayList<Booking> getAllBookings(){
		return listOfBookings;
	}
	
	public ArrayList<Booking> getAllBookingsInMonth(String month) {
		ArrayList<Booking> bookingsPerMonth= new ArrayList<Booking>();
		
		for(int i = 0; i < listOfBookings.size(); i++) {
			if(listOfBookings.get(i).getStartDate().getMonth().toString().equals(month.toUpperCase())) {
				bookingsPerMonth.add(listOfBookings.get(i));
			}
		}
		return bookingsPerMonth;
	}
}

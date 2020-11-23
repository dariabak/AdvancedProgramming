import java.time.LocalDate;

public class Main {
	
	public static void main(String[]args) {
		BookingManager manager1 = new BookingManager();
		Booking ap1 = new Booking();
		Booking ap2 = new Booking();
		Booking ap3 = new Booking();
		
		ap1.setCostPerNight(100);
		ap1.setNumberOfNights(3);
		ap1.setStartDate(LocalDate.of(2021, 1, 1));
		ap2.setCostPerNight(95);
		ap2.setNumberOfNights(4);
		ap2.setStartDate(LocalDate.of(2021, 3, 13));
		ap3.setCostPerNight(80);
		ap3.setNumberOfNights(6);
		ap3.setStartDate(LocalDate.of(2021, 1, 24));
		
		manager1.addBooking(ap1);
		manager1.addBooking(ap2);
		manager1.addBooking(ap3);
		
		System.out.println("Number of bookings " + manager1.getNumberOfBookings());
		System.out.println("Total value of bookings " + manager1.getTotalBookingsValue());
		System.out.println("All bookings " + manager1.getAllBookings());
		System.out.println("Bookings in January " + manager1.getAllBookingsInMonth("January"));
		
	}
}

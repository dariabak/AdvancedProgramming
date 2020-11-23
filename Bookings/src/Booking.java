import java.time.LocalDate;

public class Booking {
	private LocalDate startDate;
	private int numberOfNights;
	private double costPerNight;

	LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate date) {
		this.startDate = date;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int nights) {
		this.numberOfNights = nights;
	}

	public double getCostPerNight() {
		return costPerNight;
	}

	public void setCostPerNight(double cost) {
		this.costPerNight = cost;
	}

}

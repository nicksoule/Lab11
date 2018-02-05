public class UsedCar extends Car {

	private double mileage;

	public UsedCar() {

	}

	public UsedCar(String make, String model, int year, double price, double mileage) {
		super(make, model, year, price);
		this.mileage = mileage;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return String.format("(used)Make: %-15s Model: %-15s Year: %-15d Price: $%-15.2f Miles: %-15.1f",
				super.getMake(), super.getModel(), super.getYear(), super.getPrice(), mileage);
	}

}

import java.util.ArrayList;
import java.util.Scanner;

public class CarLotApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Car> carList = new ArrayList<>();
		carList.add(new Car("BMW", "750i", 2018, 80000));
		carList.add(new Car("Ford", "F-150", 2018, 35000));
		carList.add(new Car("Chevy", "Cruze", 2018, 27000));
		carList.add(new UsedCar("Honda", "Accord", 1997, 3000, 145000));
		carList.add(new UsedCar("Volvo", "V70XC", 1999, 2500, 256000));
		carList.add(new UsedCar("Volkswagen", "Jetta", 2011, 7000, 137000));
		String cont;
		int userNum;
		Car newCar = new Car();

		System.out.println("Welcome to the Grand Circus Car Lot?");
		do {
			userNum = Validator.getInt(scan,
					"What would you like to do? Enter the corresponding number to choose. " + "\n" + "1. List All Cars"
							+ "\n" + "2. Add A Car" + "\n" + "3. Remove A Car" + "\n" + "4. Look Up A Car" + "\n"
							+ "5. Replace A Car\n",
					1, 5);
			if (userNum == 1) {
				showCars(carList);
			} else if (userNum == 2) {
				newCar = addCar();
				carList.add(newCar);

			} else if (userNum == 3) {
				userNum = Validator.getInt(scan,
						"Choose the car to be removed. Please enter a number between 1 and " + carList.size() + ".", 1,
						carList.size());
				carList.remove(userNum - 1);
				System.out.println("Car number " + userNum + " has been removed.");
				showCars(carList);
			} else if (userNum == 4) {
				userNum = Validator.getInt(scan,
						"Choose the car you wish to view. Please enter a number between 1 and " + carList.size() + ".",
						1, carList.size());
				System.out.println(carList.get(userNum - 1));
			} else {
				userNum = Validator.getInt(scan,
						"Choose the car you wish to Replace. Please enter a number between 1 and " + carList.size()
								+ ".",
						1, carList.size());
				System.out.println("You chose car number " + userNum);
				System.out.println(
						"Please enter the folowing info for the car you wish replace car number " + userNum + " with.");
				newCar = addCar();
				carList.set(userNum - 1, newCar);
			}
			cont = Validator.getString(scan, "Would you like to continue? y/n", "y", "n");
		} while (cont.equalsIgnoreCase("y"));
		System.out.println("Goodbye!");
	}

	// method that lists all the cars
	public static void showCars(ArrayList<Car> carList) {
		for (int i = 0; i < carList.size(); ++i) {
			System.out.print(i + 1 + ") ");
			System.out.println(carList.get(i));
		}

	}

	// method that takes in info for new car
	public static Car addCar() {
		Car newCar = new Car();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter car make: ");
		String make = scan.nextLine();
		System.out.println("Please enter model: ");
		String model = scan.nextLine();
		System.out.println("Please enter year: ");
		int year = scan.nextInt();
		scan.nextLine();
		System.out.println("Please enter price: ");
		double price = scan.nextDouble();
		scan.nextLine();
		System.out.println("*USED CARS ONLY* Please enter mileage(if new, enter 0): ");
		double mileage = scan.nextDouble();
		scan.nextLine();
		if (mileage == 0.0) {
			newCar = new Car(make, model, year, price);
		} else {
			newCar = new UsedCar(make, model, year, price, mileage);
		}

		return newCar;
	}

}

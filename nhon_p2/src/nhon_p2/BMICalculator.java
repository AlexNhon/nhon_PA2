package nhon_p2;
import java.util.Scanner;
// BMI Calculator
// First ask user if they are going to use metric or imperial system
// then read data from the user based on their select unit of measurement
// calculate BMI and find out which category they are in based on result
// then display the results to the user
public class BMICalculator {
	Scanner scan = new Scanner(System.in);
	private int choice;
	private double height;
	private double weight;
	private double BMI;
	private int BMICategory;
	public void displayBmi() {
		double userBmi = getBmi();
		calculateBmiCategory();
		int userBmiCategory = getBmiCategory();
		System.out.println("Your BMI value is " + userBmi);
		if(userBmiCategory == 1) {
			System.out.println("Your BMI category is Underweight" );
		}
		if(userBmiCategory == 2) {
			System.out.println("Your BMI category is Normal Weight");
		}
		if(userBmiCategory == 3) {
			System.out.println("Your BMI category is Overweight");
		}
		if(userBmiCategory == 4) {
			System.out.println("Your BMI category is Obese");
		}
		
	}
	public void calculateBmi() {
		double userWeight = getWeight();
		double userHeight = getHeight();
		if (choice == 1) {
			this.BMI = (703 * userWeight) / (userHeight * userHeight);
		}
		else if (choice == 2) {
			userHeight = userHeight / 100;
			this.BMI = userWeight / (userHeight * userHeight);
		}
	}
	public void calculateBmiCategory() {
		double userBmi = getBmi();
		setBmiCategory(userBmi);
	}
	public void readUserData() {
		int unit = readUnitType();
		readMeasurementData(unit);
	}
	private int readUnitType() {
		System.out.println("1.Imperial");
		System.out.println("2.Metric");
		while(true) {
			System.out.println("Select the measurement type:");
			choice = scan.nextInt();
			if(choice == 1 || choice == 2) {	
				break;
			}
			else if(choice != 1 || choice != 2) {
				System.out.println("<<<<INVALID OPTION>>>>");
			}
		}
		return choice;
	}
	private void readMeasurementData(int unit) {
		if (unit == 1) {
			readImperialData();
		}
		if (unit == 2) {
			readMetricData();
		}
	}
	private void readImperialData() {
		double userWeight;
		double userHeight;
		System.out.println("Please enter your weight(in Pounds):");
		userWeight = scan.nextDouble();
		setWeight(userWeight);
		
		System.out.println("Please enter your height(in Inches) *6 feet = 72 inches:");
		userHeight = scan.nextDouble();
		setHeight(userHeight);
	}
	private void readMetricData() {
		double userWeight;
		double userHeight;
		System.out.println("Please enter your weight(in Kilograms):");
		userWeight = scan.nextDouble();
		setWeight(userWeight);
		
		System.out.println("Please enter your height(in Centimeters):");
		userHeight = scan.nextDouble();
		setHeight(userHeight);
	}
	public double getWeight() {
		return weight;
	}
	private void setWeight(double userWeight) {
		this.weight = userWeight;
		if(this.weight < 0) {
			System.out.println("<<<Invalid Weight>>>");
			System.exit(0);
		}
	}
	public double getHeight() {
		return height;
	}
	private void setHeight(double userHeight) {
		this.height = userHeight;
		if(this.height < 0) {
			System.out.println("<<<Invalid Height>>>");
			System.exit(0);
		}
	}
	public double getBmi() {
		return BMI;
	}
	private void setBmiCategory(double userBmi) {
		if(userBmi < 18.5) { // User is underweight
			this.BMICategory = 1;
		}
		if(userBmi >= 18.5 && userBmi <= 24.9) {// User is normal weight
			System.out.println("Here" );
			this.BMICategory = 2;
		}
		if(userBmi >= 25.0 && userBmi <= 29.9) {// User is overweight
			this.BMICategory = 3;
		}
		if(userBmi > 30.0) {// user is obese
			this.BMICategory = 4;
		}
	}
	public int getBmiCategory() {
		return BMICategory;
	}
	public static void main(String[] args) {
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}

}

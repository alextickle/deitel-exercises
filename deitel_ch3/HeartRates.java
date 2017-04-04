package java_I_ch3;

public class HeartRates {
	private String last;
	private String first;
	private int yearBirth;
	
	public HeartRates(String last, String first, int yearBirth){
		this.last = last;
		this.first = first;
		this.yearBirth = yearBirth;
	}
	
	public int getAge(){
		return 2016 - yearBirth;
	}
	
	public int maxHeartRate(int age){
		return 220 - age;
	}
	
	public double targetHeartRate(int maxHeartRate){
		return maxHeartRate * .85; 
	}
	
	public void showData(){
		System.out.printf("First name: %s%n", first);
		System.out.printf("First name: %s%n", last);
		System.out.printf("Age: %s%n", getAge());
		System.out.printf("Max Heart Rate: %d%n", maxHeartRate(getAge()));
		System.out.printf("Target Heart Rate: %.2f%n", targetHeartRate(maxHeartRate(getAge())));
	}
}

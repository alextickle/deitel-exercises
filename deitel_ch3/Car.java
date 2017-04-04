package java_I_ch3;

public class Car {
	private String model;
	private String year;
	private double price;
	
	public Car(String model, String year, double price){
		this.model = model;
		this.year = year;
		if (price >= 0){
			this.price = price;
		}
	}
	
	
}

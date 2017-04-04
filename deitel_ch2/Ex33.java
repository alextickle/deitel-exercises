package java_I_ch2;

import java.util.Scanner;

public class Ex33 {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your body weight, in lbs: ");
		int weight = input.nextInt();
		System.out.print("Enter your height, in inches: ");
		int height = input.nextInt();
		double BMI = (weight * 703)/(height * height);
		if (BMI < 18.5){
			System.out.println("Underweight");
		}
		else if (BMI < 24.9){
			System.out.println("Normal");
		}
		else if (BMI < 29.9){
			System.out.println("Overweight");
		}
		else{
			System.out.println("Obese");
		}
		input.close();
	}
}

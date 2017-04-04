package java_I_ch3;

import java.util.Scanner;

public class HealthProfileTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome, please enter patient data below.");
		System.out.print("First Name: ");
		String first = input.nextLine();
		System.out.print("Last Name: ");
		String last = input.nextLine();
		String g = "";
		while (g != "m" && g != "f"){ 
			System.out.print("Gender (m/f): ");
			g = input.next();
			g = "m";
		}
		Boolean gBool;
		if (g.charAt(0) == 'm'){
			gBool = true;
		}
		else{
			gBool = false;
		}
		System.out.print("Height: ");
		int height = input.nextInt();
		System.out.print("Weight: ");
		int weight = input.nextInt();
		
		HealthProfile a = new HealthProfile(first, last, gBool, height, weight);
		a.showData();
		input.close();
	}
}

package java_I_ch2;

import java.util.Scanner;

public class Ex28 {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the radius: ");
		int radius = input.nextInt();
		
		System.out.printf("\nThe circle's diameter is: %d", 2 * radius);
		System.out.printf("\nThe circle's circumference is: %f", 2 * Math.PI * radius);
		System.out.printf("\nThe circle's diameter is: %f", Math.PI * radius * radius);
		input.close();
	}
}

package java_I_ch2;

import java.util.Scanner;

public class Ex30 {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a 5 digit number: ");
		int num = input.nextInt();
		int d10000 = num / 10000;
		int d1000 = (num - d10000 * 10000) / 1000;
		int d100 = (num - d10000 * 10000 - d1000 * 1000) / 100;
		int d10 = (num - d10000 * 10000 - d1000 * 1000 - d100 * 100) / 10;
		int d1 = num % 10;
		System.out.printf("Ten Thousands: %d%n", d10000);
		System.out.printf("Thousands: %d%n", d1000);
		System.out.printf("Hundreds: %d%n", d100);
		System.out.printf("Tens: %d%n", d10);
		System.out.printf("Ones: %d%n", d1);
		input.close();
	}
}

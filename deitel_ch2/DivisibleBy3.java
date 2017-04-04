package java_I_ch2;

import java.util.Scanner;

public class DivisibleBy3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number to check for divisibility by 3: ");
		int num = input.nextInt();
		if (num % 3 == 0){
			System.out.println("This number is divisible by 3!");
		}
		else{
			System.out.println("This number is NOT divisible by 3!");
		}
		input.close();
	}

}

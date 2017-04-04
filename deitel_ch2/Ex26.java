package java_I_ch2;

import java.util.Scanner;

public class Ex26 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the first number: ");
		int num1 = input.nextInt();
		System.out.print("Please enter the second number: ");
		int num2 = input.nextInt();
		
		if ((2 * num2) % num1 == 0){
			System.out.println("Success!");
		}
		else{
			System.out.println("Fail!");
		}
		input.close();
	}

}

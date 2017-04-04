package java_I_ch2;

import java.util.Scanner;

public class Ex34 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the world population: ");
		int worldpop = input.nextInt();
		double growth_rate = 0.0672;
		System.out.println("Year" + "\t" + "Population");
		double [] a = new double[5];
		a[0] = worldpop;
		for (int i = 1; i < 5; i++){
			a[i] = a[i - 1] * growth_rate;
			System.out.println(i + "\t" + a[i]);
		}
		input.close();
	}

}

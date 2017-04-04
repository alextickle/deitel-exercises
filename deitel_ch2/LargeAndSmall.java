package java_I_ch2;

import java.util.Scanner;

public class LargeAndSmall {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1;
		int num2;
		int num3;
		int num4;
		int num5;
		System.out.print("Enter 5 integers: ");
		num1 = input.nextInt();
		num2 = input.nextInt();
		num3 = input.nextInt();
		num4 = input.nextInt();
		num5 = input.nextInt();
		
		int max = num1;
		int [] allnums = new int[5];
		allnums[0] = num1;
		allnums[1] = num2;
		allnums[2] = num3;
		allnums[3] = num4;
		allnums[4] = num5;
		for (int i = 0; i < 5; i++){
			if (max < allnums[i]){
				max = allnums[i];
			}
		}
		System.out.printf("The largest number is: %d%n", max);
		input.close();
	}

}

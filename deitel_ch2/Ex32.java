package java_I_ch2;

import java.util.Scanner;

public class Ex32 {
	
	public static void main(){
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter 5 numbers: ");
		int[] a = new int[5];
		a[0] = input.nextInt();
		a[1] = input.nextInt();
		a[2] = input.nextInt();
		a[3] = input.nextInt();
		a[4] = input.nextInt();
		int countpos = 0;
		int countneg = 0;
		int countzero = 0;
		
		for (int i = 0; i < 5; i++){
			if (a[i] > 0){
				countpos++;
			}
			else if (a[i] == 0){
				countzero++;
			}
			else{
				countneg++;
			}
		}
		System.out.printf("Positives: %d%n", countpos);
		System.out.printf("Negatives: %d%n", countneg);
		System.out.printf("Zeros: %d%n", countzero);
		input.close();
		
	}
}

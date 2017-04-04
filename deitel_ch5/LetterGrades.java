package java_I_ch5;

import java.util.Scanner;

public class LetterGrades {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int total = 0;
		int gradeCounter = 0;
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		int dCount = 0;
		int fCount = 0;
		
		System.out.printf("%s%n%s%n  %s%n  %s%n", 
				"Enter the integer grades in the range 0-100.",
				"Type the end-of-file indicator to terminate input:",
				"On UNIX/Linux/Mac OS X type <Ctrl> d then press Enter.",
				"On Windows type <Ctrl> z then press enter.");
		while (input.hasNext()){
			int grade = input.nextInt();
			total += grade;
			++gradeCoun
		}
	}

}

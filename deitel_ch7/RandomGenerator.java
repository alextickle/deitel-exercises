package com.makesrc.common.util;

public final class RandomGenerator{

	private RandomGenerator(){
	}

	public static int generateRandomNum(int lowerB, int upperB){
		
		// check for valid inputs
		if (upperB < lowerB){
			int tmp = lowerB;
			lowerB = upperB;
			upperB = tmp;
		}

		return (lowerB + (int) (Math.random() * (upperB - lowerB + 1)));
	}

	public static void main(String[] args){
		
		if (args.length <  2 || args.length > 3){
			System.out.println("Usage: java RandomGenerator lower upper <repetition>");
		}

		int lowerBound = Integer.parseInt(args[0]);
		int upperBound = Integer.parseInt(args[1]);
		int repetition = 1;

		if (args.length == 3){
			repetition = Integer.parseInt(args[2]);
		}
		
		for (int i = 0; i < repetition; i++){
			System.out.println("random number: " +
				generateRandomNum(lowerBound, upperBound));
		}
			
	}


}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TreasureHunt2{
	
	private boolean hitBomb = false;
	private int treasureCount = 0;
	private String[][] map = new String[5][5];
	private int[][] bombs = new int[3][2];
	private int[][] treasures = new int[3][2];
	
	public int[][] getBombs(){
		return bombs;
	}
	
	public int[][] getTreasures(){
		return treasures;
	}
	
	public static boolean elementsUnique(int[][] anArray){
		for (int i = 0; i < anArray.length; i++){
			for (int j = 0; j < anArray.length; j++){
				if (i != j && anArray[i][0] == anArray[j][0] && anArray[i][1] == anArray[j][1]){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean gameOver(){
		if (hitBomb || treasureCount == 3){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean intArrayinDoubleIntArray(int[][] a, int[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i][0] == b[0] && a[i][1] == b[1]){
				return true;
			}
		}
		return false;
	}
	
	public static int[][] repopulateArray(int[][] anArray){
		int[][] toReturn = new int[3][2];
		for (int i = 0; i < anArray.length; i++){
			toReturn[i][0] = (int) Math.floor(Math.random() * 5);
			toReturn[i][1] = (int) Math.floor(Math.random() * 5);
		}
		return toReturn;
	}
	
	public void initializeArrays(){
		int[][] newBombs = new int[3][2];
		for (int a = 0; a < 3; a++){
			newBombs[a][0] = (int) Math.floor(Math.random() * 5);
			newBombs[a][1] = (int) Math.floor(Math.random() * 5);
		}
		bombs = newBombs;
		
		int[][] newTreasures = new int[3][2];
		for (int b = 0; b < 3; b++){
			newTreasures[b][0] = (int) Math.floor(Math.random() * 5);
			newTreasures[b][1] = (int) Math.floor(Math.random() * 5);
		}
		treasures = newTreasures;
		
		
		while ((!elementsUnique(bombs)) || (!elementsUnique(treasures))){
			bombs = repopulateArray(bombs);
			treasures = repopulateArray(treasures);
		}
		
		for (int i = 0; i < bombs.length; i++){
			for (int j = 0; j < treasures.length; j++){
				if (bombs[i][0] == treasures[i][0] && bombs[i][1] == treasures[i][1]){
					initializeArrays();
				}
			}
		}
	}
	
	public void initializeMap(){
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				map[i][j] = "-";
			}
		}
	}
	
	public void printMap(){
		System.out.println("    1   2   3   4   5");
		System.out.println("-----------------------");
		String[] letters = {"A", "B", "C", "D", "E"};
		for (int i = 0; i < 5; i++){
			System.out.print(letters[i] + " | ");
			for (int j = 0; j < 5; j++){
				System.out.printf("%s | ", map[i][j]);
			}
			System.out.println("\n-----------------------");
		}
	}

	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Treasure Hunt!");
		TreasureHunt2 game = new TreasureHunt2();
		game.initializeArrays();
		game.initializeMap();
		System.out.println("BOMBS");
		System.out.println(game.bombs[0][0] + " " + game.bombs[0][1]);
		System.out.println(game.bombs[1][0] + " " + game.bombs[0][1]);
		System.out.println(game.bombs[2][0] + " " + game.bombs[2][1]);
		System.out.println("TREASURES");
		System.out.println(game.treasures[0][0] + " " + game.treasures[0][1]);
		System.out.println(game.treasures[1][0] + " " + game.treasures[1][1]);
		System.out.println(game.treasures[2][0] + " " + game.treasures[2][1]);
		System.out.println();
		String response = "";
		int[] pick = new int[2];
		int[][] picks = new int[22][2];
		for (int i = 0; i < picks.length; i++){
			for (int j = 0; j < 2; j++){
				picks[i][j] = -1;
			}
		}
		int pickCount = 0;
		while (!game.gameOver()){
			game.printMap();
			System.out.println("Please select a box: ");
			response = input.next();
			switch (response.charAt(0)){
				case 'A': pick[0] = 0;
					pick[1] = Integer.parseInt(response.substring(1, 2)) - 1;
					break;
				case 'B': pick[0] = 1;
					pick[1] = Integer.parseInt(response.substring(1, 2)) - 1;
					break;
				case 'C': pick[0] = 2;
					pick[1] = Integer.parseInt(response.substring(1, 2)) - 1;
					break;
				case 'D': pick[0] = 3;
					pick[1] = Integer.parseInt(response.substring(1, 2)) - 1;
					break;
				case 'E': pick[0] = 4; 
					pick[1] = Integer.parseInt(response.substring(1, 2)) - 1;
					break;
				default:
					break;
			}
			System.out.println(pick[0] + " " + pick[1]);
			
			if (intArrayinDoubleIntArray(picks, pick)){}
			
			else if (intArrayinDoubleIntArray(game.bombs, pick)){
				game.hitBomb = true;
				game.map[pick[0]] [pick[1]] = "B";
			}
			
			else if (intArrayinDoubleIntArray(game.treasures, pick)){
				game.treasureCount++;
				game.map[pick[0]] [pick[1]] = "$";
			}
			
			else {
				game.map[pick[0]] [pick[1]] = "X";
				
			}
			picks[pickCount][0] = pick[0];
			picks[pickCount][1] = pick[1];
			pickCount++;
			
		}
		
		game.printMap();
		if (game.treasureCount == 3){
			System.out.println("You win!");
		}
		else {
			System.out.println("You lose!");
		}
			
	}

}


import java.util.ArrayList;
import java.util.Scanner;

public class TreasureHunt{
	
	private boolean hitBomb = false;
	private int treasureCount = 0;
	private ArrayList<String> map = new ArrayList<String>();
	private ArrayList<Integer> bombs = new ArrayList<Integer>();
	private ArrayList<Integer> treasures = new ArrayList<Integer>();
	
	public ArrayList<Integer> getBombs(){
		return bombs;
	}
	
	public ArrayList<Integer> getTreasures(){
		return treasures;
	}
	
	public void setBombs(ArrayList<Integer> anArray){
		bombs = anArray;
	}
	
	public void setTreasures(ArrayList<Integer> anArray){
		treasures = anArray;
	}
	
	public static boolean elementsUnique(ArrayList<Integer> anArray){
		for (int i = 0; i < anArray.size() - 1; i++){
			for (int j = i + 1; j < anArray.size(); j++){
				if (anArray.get(i) == anArray.get(j)){
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
	
	public static ArrayList<Integer> repopulateArray(ArrayList<Integer> anArray){
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		for (int i = 0; i < anArray.size(); i++){
			toReturn.add((int) (Math.random() * 25 + 1));
		}
		return toReturn;
	}
	
	public void initializeArrays(){
		ArrayList<Integer> newBombs = new ArrayList<Integer>();
		for (int a = 0; a < 3; a++){
			newBombs.add((int) (Math.random() * 25 + 1));
		}
		bombs = newBombs;
		
		ArrayList<Integer> newTreasures = new ArrayList<Integer>();
		for (int b = 0; b < 3; b++){
			newTreasures.add((int) (Math.random() * 25 + 1));
		}
		treasures = newTreasures;
		
		while ((!elementsUnique(bombs)) || (!elementsUnique(treasures))){
			bombs = repopulateArray(bombs);
			treasures = repopulateArray(treasures);
		}
		
		for (int i = 0; i < bombs.size(); i++){
			for (int j = 0; j < treasures.size(); j++){
				if (bombs.get(i) == treasures.get(j)){
					initializeArrays();
				}
			}
		}
	}
	
	public void initializeMap(){
		for (int i = 0; i < 25; i++){
				map.add("-");
		}
	}
	
	public void printMap(){
		System.out.println("    1   2   3   4   5");
		System.out.println("  ---------------------");
		System.out.printf("A | %s | %s | %s | %s | %s |\n", map.get(0), 
				map.get(1), map.get(2), map.get(3), map.get(4));
		System.out.println("  ---------------------");
		System.out.printf("B | %s | %s | %s | %s | %s |\n", map.get(5), 
				map.get(6), map.get(7), map.get(8), map.get(9));
		System.out.println("  ---------------------");
		System.out.printf("C | %s | %s | %s | %s | %s |\n", map.get(10), 
				map.get(11), map.get(12), map.get(13), map.get(14));
		System.out.println("  ---------------------"); 
		System.out.printf("D | %s | %s | %s | %s | %s |\n", map.get(15), 
				map.get(16), map.get(17), map.get(18), map.get(19));
		System.out.println("  ---------------------");
		System.out.printf("E | %s | %s | %s | %s | %s |\n", map.get(20), 
				map.get(21), map.get(22), map.get(23), map.get(24));
		System.out.println("  ---------------------");
	}

	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Treasure Hunt!");
		TreasureHunt game = new TreasureHunt();
		game.initializeArrays();
		System.out.println("BOMBS");
		System.out.println(game.bombs);
		System.out.println("TREASURES");
		System.out.println(game.treasures);
		game.initializeMap();
		String response = "";
		int pick = 0;
		while (!game.gameOver()){
			game.printMap();
			System.out.println("Please select a box (e.g. 'A2'): ");
			response = input.next();
			switch (response.charAt(0)){
				case 'A': pick = Integer.parseInt(response.substring(1, 2)) - 1;
					break;
				case 'B': pick = 4 + Integer.parseInt(response.substring(1, 2));
					break;
				case 'C': pick = 9 + Integer.parseInt(response.substring(1, 2));
					break;
				case 'D': pick = 14 + Integer.parseInt(response.substring(1, 2));
					break;
				case 'E': pick = 19 + Integer.parseInt(response.substring(1, 2));
					break;
				default:
					break;
			}
			
			if (game.bombs.contains(pick)){
				game.hitBomb = true;
				game.map.set(pick, "B");
			}
			
			else if (game.treasures.contains(pick)){
				game.treasureCount++;
				game.map.set(pick, "$");
			}
			
			else {
				game.map.set(pick, "X");
				
			}
			
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

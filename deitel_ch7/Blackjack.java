package blackjack;

import java.util.ArrayList;
import com.makesrc.common.util.RandomGenerator;
import java.util.Scanner;

public class Blackjack{

	public enum Card{
		// Aces
		ACE_OF_SPADES("Ace of Spades", 1), 
		TWO_OF_SPADES("Two of Spades", 2), 
		THREE_OF_SPADES("Three of Spades", 3),
		FOUR_OF_SPADES("Four of Spades", 4),
		FIVE_OF_SPADES("Five of Spades", 5),
		SIX_OF_SPADES("Six of Spades", 6),
		SEVEN_OF_SPADES("Seven of Spades", 7),
		EIGHT_OF_SPADES("Eight of Spades", 8),
		NINE_OF_SPADES("Nine of Spades", 9),
		TEN_OF_SPADES("Ten of Spades", 10),
		JACK_OF_SPADES("Jack of Spades", 10),
		QUEEN_OF_SPADES("Queen of Spades", 10),
		KING_OF_SPADES("King of Spades", 10),
		// Clubs
		ACE_OF_CLUBS("Ace of Clubs", 1), 
		TWO_OF_CLUBS("Two of Clubs", 2), 
		THREE_OF_CLUBS("Three of Clubs", 3),
		FOUR_OF_CLUBS("Four of Clubs", 4),
		FIVE_OF_CLUBS("Five of Clubs", 5),
		SIX_OF_CLUBS("Six of Clubs", 6),
		SEVEN_OF_CLUBS("Seven of Clubs", 7),
		EIGHT_OF_CLUBS("Eight of Clubs", 8),
		NINE_OF_CLUBS("Nine of Clubs", 9),
		TEN_OF_CLUBS("Ten of Clubs", 10),
		JACK_OF_CLUBS("Jack of Clubs", 10),
		QUEEN_OF_CLUBS("Queen of Clubs", 10),
		KING_OF_CLUBS("King of Clubs", 10),
		// Diamonds
		ACE_OF_DIAMONDS("Ace of Diamonds", 1), 
		TWO_OF_DIAMONDS("Two of Diamonds", 2), 
		THREE_OF_DIAMONDS("Three of Diamonds", 3),
		FOUR_OF_DIAMONDS("Four of Diamonds", 4),
		FIVE_OF_DIAMONDS("Five of Diamonds", 5),
		SIX_OF_DIAMONDS("Six of Diamonds", 6),
		SEVEN_OF_DIAMONDS("Seven of Diamonds", 7),
		EIGHT_OF_DIAMONDS("Eight of Diamonds", 8),
		NINE_OF_DIAMONDS("Nine of Diamonds", 9),
		TEN_OF_DIAMONDS("Ten of Diamonds", 10),
		JACK_OF_DIAMONDS("Jack of Diamonds", 10),
		QUEEN_OF_DIAMONDS("Queen of Diamonds", 10),
		KING_OF_DIAMONDS("King of Diamonds", 10),
		// Hearts
		ACE_OF_HEARTS("Ace of Hearts", 1), 
		TWO_OF_HEARTS("Two of Hearts", 2), 
		THREE_OF_HEARTS("Three of Hearts", 3),
		FOUR_OF_HEARTS("Four of Hearts", 4),
		FIVE_OF_HEARTS("Five of Hearts", 5),
		SIX_OF_HEARTS("Six of Hearts", 6),
		SEVEN_OF_HEARTS("Seven of Hearts", 7),
		EIGHT_OF_HEARTS("Eight of Hearts", 8),
		NINE_OF_HEARTS("Nine of Hearts", 9),
		TEN_OF_HEARTS("Ten of Hearts", 10),
		JACK_OF_HEARTS("Jack of Hearts", 10),
		QUEEN_OF_HEARTS("Queen of Hearts", 10),
		KING_OF_HEARTS("King of Hearts", 10);
		
		private String name;
		private int value;
		
		private Card(String name, int value){
			this.name = name;
			this.value = value;
		}
		
		public String getName(){
			return this.name();
		}
		
		public int getValue(){
			return this.value;
		}
	}
	
	// uses RandomGenerator to return a random Card enum
	public static Card drawCard(){
		return Card.values()[RandomGenerator.generateRandomNum(1, 52) - 1];
	}
	
	// displays the name of each card in a hand and the hand's total value
	public static void showHand(ArrayList<Card> hand){
		for (Card i : hand){
			System.out.print(i.name + " | ");
		}
		System.out.printf("Total: %d", getHandValue(hand));
	}
	
	// returns the value of a given hand
	public static int getHandValue(ArrayList<Card> hand){
		int handValue = 0;
		for (Card i : hand){
			if (i.value == 1 && handValue < 11){
				handValue += 11;
			}
			else{
				handValue += i.value;
			}
		}
		
		if (handValue > 21){
			handValue = 0;
			for (Card i : hand){
					handValue += i.value;
			}
			
		}
		return handValue;
	}
	
	// return true if a hand busts (exceeds 21)
	public static boolean bust(int handValue){
		if (handValue > 21){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public static void main(String[] args){
		
		// instantiate two Card ArrayLists to represent each player's hand
		ArrayList<Card> playerHand = new ArrayList<Card>();
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Shall we play a game? Y or N");
		char response = input.nextLine().charAt(0);
		
		while (response == 'y' || response == 'Y'){
			
			// begin game by drawing two cards per player
			playerHand.add(drawCard());
			playerHand.add(drawCard());
			dealerHand.add(drawCard());
			dealerHand.add(drawCard());
			System.out.println("PLAYER");
			showHand(playerHand);
			System.out.println();
			System.out.println("DEALER");
			System.out.print(dealerHand.get(0).name + " | Total: " + dealerHand.get(0).value);
			System.out.println();
		
			// check if player got 21 on first deal, if not ask to hit or stay
			if ((getHandValue(playerHand) < 21)){
				System.out.println("Do you want to hit (H) or stay (S)?");
				response = input.nextLine().charAt(0);
			}
			
			// loop continues as long as player doesn't bust, get 21, or stay
			while (!bust(getHandValue(playerHand)) && (response == 'h' || response == 'H')){
				playerHand.add(drawCard());
				System.out.println("PLAYER");
				showHand(playerHand);
				System.out.println();
				System.out.println("DEALER");
				System.out.print(dealerHand.get(0).name + " | Total: " + dealerHand.get(0).value);
				System.out.println();
				if ((getHandValue(playerHand) < 21)){
					System.out.println("Do you want to hit (H) or stay (S)?");
					response = input.nextLine().charAt(0);
				}
			}
			
			// if game isn't over then dealer draws until he busts or exceeds 17
			if ((!bust(getHandValue(playerHand))) && (getHandValue(playerHand) != 21)) {
				System.out.println("Dealer shows his second card...");
				System.out.println("PLAYER");
				showHand(playerHand);
				System.out.println();
				System.out.println("DEALER");
				showHand(dealerHand);
				System.out.println();
				while (getHandValue(dealerHand) < 17){
					System.out.println("Dealer draws...");
					dealerHand.add(drawCard());
					System.out.println("PLAYER");
					showHand(playerHand);
					System.out.println();
					System.out.println("DEALER");
					showHand(dealerHand);
					System.out.println();
				}
			}
		
		
			// end of game messages
			if (getHandValue(playerHand) == 21){
				System.out.println("You win!");
			}
		
			else if (bust(getHandValue(playerHand))){
				System.out.println("Dealer wins!");
			}
		
			else if (bust(getHandValue(dealerHand))){
				System.out.println("You win!");
			}
		
			else if (getHandValue(playerHand) >= getHandValue(dealerHand)){
				System.out.println("You win!");
			}
		
			else {
				System.out.println("Dealer wins!");
			}
		
			System.out.println("Shall we play a game? Y or N");
			response = input.nextLine().charAt(0);
			playerHand.clear();
			dealerHand.clear();
			}
		
		System.out.println("Thank you for playing!");
		input.close();
	}
}

package java_I_ch7;

import java.security.SecureRandom;

public class DeckOfCards {
	
	private Card[] deck; // array of Card objects
	private int currentCard; // index of next Card to be dealt (0-51)
	private static final int NUMBER_OF_CARDS = 52; // constant # of cards
	// random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	// constructor fills deck of Cards
	public DeckOfCards{
		String[] faces = {"Aces", "Deuce", "Three", "Four", "Five", "Six",
			"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
		currentCard = 0; // first Card dealt will be deck[0]
		
		// populate deck with Card objects
		for (int count = 0; count < deck.length; count++){
			deck[count] =
				new Card(faces[count % 13], )
		}
	}

}

package BlackJackGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
	private final String[] faces = {"Hearts", "Clubs", "Spades", "Diamonds"};
	private final String[] cardValues = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	private final int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10};
	private List<Card> Deck;
	
	public Deck() {
		makeNewDeck();
	}
	
	private void makeNewDeck() {
		// Initialize variables
		String cardVal; String faceVal; int numberVal; this.Deck = new ArrayList<>();
		
		// Move through every value in the arrays to make a Deck
		for (int valueIndex = 0; valueIndex < values.length; valueIndex++) {
			cardVal = cardValues[valueIndex]; numberVal = values[valueIndex];
			
			for (int faceIndex = 0; faceIndex < faces.length; faceIndex++) {
				faceVal = faces[faceIndex];
				
				this.Deck.add(new Card(faceVal, cardVal, numberVal));
			}
		}
		
		// End by shuffling the deck
		shuffleDeck();
	}
	
	private void shuffleDeck() {
		Collections.shuffle(Deck);
	}
	
	public String toString() {
		String strDeck = "";
		for (Card card : Deck) {
			strDeck = strDeck + card.toString() + "\n";
		}
		
		return strDeck;
	}
	
	public int showDeckSize() {
		int deckSize = Deck.size();
		return deckSize;
	}
	
	public Card drawCard() {
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = ThreadLocalRandom.current().nextInt(0, 52 + 1);
		Card drawnCard = Deck.remove(randomNum);
		
		return drawnCard;
	}
}

package BlackJackGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Card> hand;
	private int handValue = 0;
	private int handSize = 0;
	private boolean isPlaying = false;
	private boolean isDealer = false;
	private String playerName = "";
	
	public Player(boolean isPlaying, boolean isDealer, String playerName) {
		this.hand = new ArrayList<>();
		this.isPlaying = isPlaying;
		this.isDealer = isDealer;
		this.playerName = playerName;
	}
	
	public void addCard(Card card) {
		this.hand.add(card);
		this.adjustHandValue();
		this.handSize = hand.size();
	}
	
	private void adjustHandValue() {
		int handSum = 0; List<Card> specialCards = new ArrayList<>();
		for (Card card : hand) {
			if (card.getCardValueStr().equals("Ace")) {
				specialCards.add(card);
			} else {
				handSum += card.getCardValue();
			}
		}
		for (Card card : specialCards) {
			if ((handSum + 10) <= 21) {
				handSum += 10;
			} else {
				handSum += 1;
			}
		}
		this.handValue = handSum;
	}
	
	public int getHandValue() {
		return handValue;
	}

	public int getHandSize() {
		return this.handSize;
	}
	
	public boolean getIsPlayer() {
		return isPlaying;
	}
	
	public boolean getIsDealer() {
		return isDealer;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public String toString() {
		String result = this.playerName + "'s hand:\n";
		for (Card card : hand) {
			result = result + card.toString() + "\n";
		}
		return result;
	}
	
}

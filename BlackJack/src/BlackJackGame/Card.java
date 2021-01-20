package BlackJackGame;

public class Card {
	private int value;
	private String face;
	private String cardValue;
	
	public Card(String face, String cardValue, int value) {
		this.value = value;
		this.cardValue = cardValue;
		this.face = face;
	}
	
	public String toString() {
		String stringResult = this.cardValue + " of " + this.face;
		return stringResult;
	}
	
	public int getCardValue() {
		return this.value;
	}
	
	public String getCardValueStr() {
		return this.cardValue;
	}
}

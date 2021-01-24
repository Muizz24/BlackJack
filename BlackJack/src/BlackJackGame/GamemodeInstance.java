package BlackJackGame;

public class GamemodeInstance {
	protected String[] options;
	protected Player[] players;
	protected Player Dealer;
	protected Deck deck;
	protected boolean isGameOver = false;
	
	public GamemodeInstance() {
		
	}
	
	// Finds the option in the array, if not inside the array, return -1. If exists, returns index of option
	public int findOption(String userInput) {
		int optionIndex = -1; int i = 0;
		for (String option : options) {
			if (option.equals(userInput)) {
				optionIndex = i; break;
			} else {
				i++;
			}
		}
		return optionIndex;
	}
	
	public String getOptions() {
		String result = "";
		for (int i=0; i < options.length; i++) {
			result = result + "\n" + Integer.toString((i + 1)) + ". " + options[i];
		}
		return result;
	}
	
	public String formulateOptionResponse(int optionsIndex, Player player) {
		return "OVERRIDE";
	}
	
	public Player getDealer() {
		Player dealer = null;
		for (Player player : players) {
			if (player.getIsDealer()) {
				dealer = player;
				break;
			}
		}
		return dealer;
	}
	
	public boolean isGameOver() {
		return this.isGameOver;
	}
	
	protected void setGameOverState(boolean gameState) {
		this.isGameOver = gameState;
	}
}

package BlackJackGame;

public class TextParser {
	private GamemodeInstance gameMode;
	
	public TextParser(String gameMode, Player[] players, Deck deck) {
		// Will add more game-modes later!
		switch(gameMode) {
		  case "blackjack":
		    this.gameMode = new BlackJackGamemode(players, deck);
		    break;
		  default:
		    System.out.println("Error, Gamemode not found");
		}
	}
	
	public String parseResponse(String response, Player player) {
		String reply = "Sorry, this is not a valid option. Your options:\n" +  gameMode.getOptions();
		int optionIndex = this.gameMode.findOption(response.toLowerCase());
		if (optionIndex != -1) {
			reply = this.gameMode.formulateOptionResponse(optionIndex, player);
		}
		return reply;
	}
	
	public String getOptions() {
		return gameMode.getOptions();
	}
	
	public boolean isGameOver() {
		return this.gameMode.isGameOver();
	}

}

package BlackJackGame;

public class BlackJackGamemode extends GamemodeInstance {
	
	public BlackJackGamemode(Player[] players, Deck deck) {
		this.options = new String[]{"stand", "hit"};
		this.players = players;
		this.deck = deck;
	}
	
	public String formulateOptionResponse(int optionsIndex, Player player) {
		String reply = "";
		String option = options[optionsIndex];
		switch(option) {
		  case "stand":
			  reply = "Player stands. Their hand = " + player.getHandValue() + ".\ndealer will now draw.";
			  System.out.println(reply);
			  Player dealer = this.getDealer();
			  while (dealer.getHandValue() <= 21) {
				  Card card = this.deck.drawCard();
				  dealer.addCard(card); int handVal = dealer.getHandValue();
				  reply = "Dealer drew a " + card.toString() + "! Their hand is now worth " + Integer.toString(handVal) + "\n";
				  if (handVal > player.getHandValue() && handVal <= 21) {
					  reply = reply + "Dealer's hand is higher than yours, dealer wins!"; System.out.println(reply); break;
				  } else if (handVal > 21) {
					  reply = reply + "dealer busts, you win!"; System.out.println(reply); break;
				  } else {
					  System.out.println(reply);
				  }
			  }
			  this.setGameOverState(true); break;
			 
		  case "hit":
			  Card card = this.deck.drawCard();
			  player.addCard(card);
			  int handValue = player.getHandValue();
			  reply = player.getPlayerName() + " drew a " + card.toString() + "! Their hand = " + Integer.toString(handValue);
			  if (handValue > 21) {
				  reply = reply + "\n " + player.getPlayerName() + "'s hand is above 21, dealer wins!\n"; this.setGameOverState(true);
			  } else if (handValue == 21) {
				  reply = reply + "\n" + "BlackJack! " + player.getPlayerName() + " wins!\n"; this.setGameOverState(true);
			  }
			break;
		  default:
		    System.out.println("Can't find valid option");
		}
		return reply;
	}
	
	
}

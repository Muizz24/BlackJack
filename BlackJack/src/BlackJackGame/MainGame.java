package BlackJackGame;

import java.util.Scanner;

public class MainGame {
	
	public static TextParser initGame(String username) {
		Deck deck = new Deck(); 
		Player dealer = new Player (true, true, "dealer");
		Player player1 = new Player (true, false, username);
		TextParser txtParser = new TextParser("blackjack", new Player[]{dealer, player1}, deck); 
		
		player1.addCard(deck.drawCard());
		dealer.addCard(deck.drawCard());
		player1.addCard(deck.drawCard());
		dealer.addCard(deck.drawCard());
		return txtParser;
	}

	public static void main(String[] args) {
		Scanner myUserName = new Scanner(System.in);  // Create a Scanner object
	    System.out.print("Enter your name: ");

	    String username = myUserName.nextLine();
		
	    Deck deck = new Deck();
		Player dealer = new Player (true, true, "dealer");
		Player player1 = new Player (true, false, username);
		TextParser txtParser = new TextParser("blackjack", new Player[]{dealer, player1}, deck); 
		
		player1.addCard(deck.drawCard());
		dealer.addCard(deck.drawCard());
		player1.addCard(deck.drawCard());
		dealer.addCard(deck.drawCard());
		
		System.out.println("Welcome to Muizz's Card Casino " + username + "! Let's jump straight to blackJack!");
		while(true) {
			System.out.println(dealer); System.out.println(player1);
			
			Scanner myInput = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Choose an option from the following:\n" + txtParser.getOptions());

		    String option = myInput.nextLine();
		    
		    String response = txtParser.parseResponse(option, player1);
		    System.out.println(response);
		    
		    if (txtParser.isGameOver()) {
		    	deck = new Deck(); 
				dealer = new Player (true, true, "dealer");
				player1 = new Player (true, false, username);
				txtParser = new TextParser("blackjack", new Player[]{dealer, player1}, deck); 
				
				player1.addCard(deck.drawCard());
				dealer.addCard(deck.drawCard());
				player1.addCard(deck.drawCard());
				dealer.addCard(deck.drawCard());
		    }
		}
	}
	
	

}

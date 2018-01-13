package javaBlackJackGame;

public class Blackjack {

	public static void main(String[] args) {
		
		// Welcome Message
        System.out.println("Welcome to Blackjack!");
        
        // Create playing deck
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();

        System.out.println(playingDeck);
		
	}

}

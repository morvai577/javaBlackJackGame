package javaBlackJackGame;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		
		// Welcome Message
        System.out.println("Welcome to Blackjack!");
        
        // Create playing deck
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck(); // Create a deck of cards
        playingDeck.shuffle(); // Shuffle Deck
        
        // Create a deck for the player
        Deck playerDeck = new Deck(); // Starts with an empty deck
        Deck dealerDeck = new Deck();
        
        double playerMoney = 100.00;
        
        Scanner userInput = new Scanner(System.in);

        System.out.println(playingDeck);
		
	}

}

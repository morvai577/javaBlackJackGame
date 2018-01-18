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
        
        // Game Loop
        while (playerMoney > 0) {
        	
        		// Continue playing
        		System.out.println("You have $" + playerMoney + ", how much would you like to bet ?");
        		double playerBet = userInput.nextDouble();
        		if (playerBet > playerMoney) {
        			System.out.println("You cannot bet more than you have. Please try again.");
        			break;
        		}
        		
        		// Start Dealing
        		// Player gets two cards
        		playerDeck.draw(playingDeck);
        		playerDeck.draw(playingDeck);

        		// Dealer gets two cards
        		dealerDeck.draw(playingDeck);
        		dealerDeck.draw(playingDeck);
        		
        		while(true) {
        			System.out.println("Your hand:");
        			System.out.println(playerDeck.toString());
        		}
        		
        		
        		

        }
        
        System.out.println("Game over! You are out of money. :(");
		
	}

}

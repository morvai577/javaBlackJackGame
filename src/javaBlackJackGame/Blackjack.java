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
        		
        		boolean endRound = false;
        		
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
        			System.out.println("Your hand is valued at: " + playerDeck.cardsValue());
        			
        			// Display Dealer Hand
        			System.out.println("Deaer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");
        			
        			// What does the player want to do ?
        			System.out.println("Would you like to (1) Hit or (2) Stand ?");
        			int response = userInput.nextInt();
        			
        			// Player Hit
        			if (response == 1) {
        				playerDeck.draw(playingDeck);
        				System.out.println("You drew a: " + playerDeck.getCard(playerDeck.deckSize() -1).toString());
        				// Stop game is cardsValue > 21
        				if (playerDeck.cardsValue() > 21) {
        					System.out.println("Bust. Currently valued at: " + playerDeck.cardsValue());
        					playerMoney -= playerBet;
        					endRound = true;
        					break;
        					
        				}
        			
        			}
        			
        			if (response == 2) {
        				break;
        			}
        		}
        		
        		// Reveal Dealer Cards
        		System.out.println("Dealer Cards: " + dealerDeck.toString());
        		
        		// See if dealer has more points than player
        		if ((dealerDeck.cardsValue() > playerDeck.cardsValue()) && endRound == false) {
        			System.out.println("Dealer beats you!");
        			playerMoney -= playerBet;
        			endRound = true;
        		}
        		
        		// Dealer Draws at 16, stand at 17
        		while ((dealerDeck.cardsValue() < 17) && endRound == false) {
        			dealerDeck.draw(playingDeck);
        			System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
        		}
        		
        		// Display Total Value for Dealer
        		System.out.println("Dealer's Hand is valued at: " + dealerDeck.cardsValue());
        		
        		// Determine if dealer is busted
        		if ((dealerDeck.cardsValue() > 21) && endRound == false) {
        			System.out.println("Dealer busts! You win.");
        			playerMoney += playerBet;
        			endRound = true;
        		}
        		
        		// Determine if push
        		if ((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
        			System.out.println("Push");
        			endRound = true;
        		}
        		
        		if ((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
        			System.out.println("You win the hand!");
        			playerMoney += playerBet;
        			endRound = true;
        		}
        		
        

        }
        
        System.out.println("Game over! You are out of money. :(");
		
	}

}

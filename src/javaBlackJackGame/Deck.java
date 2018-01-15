/**
 * 
 */
package javaBlackJackGame;

import java.util.ArrayList;
import java.util.Random;


/**
 * @author vai
 *
 */
public class Deck {
	
	//Variables
    private ArrayList<Card> cards;

    //Constructor
    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck() {

        for (Suit cardSuit : Suit.values()) {
            for(Value cardValue : Value.values()) {
                // Add a new card to the mix
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    // Shuffle the deck
    public void shuffle() {
    		ArrayList<Card> tmpDeck = new ArrayList<Card>();
    		Random random = new Random(); // Generate random number
    		int randomCardIndex = 0;
    		int originalSize = this.cards.size();
    		
    		for(int i = 0; i < originalSize; i++) {
    			// Generate random index
    			randomCardIndex = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
    			tmpDeck.add(this.cards.get(randomCardIndex));
    			
    			// Remove from original deck
    			this.cards.remove(randomCardIndex);
    		}
    		
    		this.cards = tmpDeck;
    }
    
    public String toString() {
        String cardListOutput = "";
        int i = 0;
        for (Card aCard : this.cards) {
            cardListOutput += "\n " + aCard.toString();
            i++;
        }

        return cardListOutput;
    }
    
    // Remove the card from the deck
    public void removeCard(int i) {
    		this.cards.remove(i);
    }
    
    // Get a card from the deck
    public Card getCard(int i) {
    		return this.cards.get(i);
    }
    
    // Add a card to the deck
    public void addCard(Card addCard) {
    		this.cards.add(addCard);
    }
    
    // Draw from the deck
    public void draw(Deck comingFrom) {
    		this.cards.add(comingFrom.getCard(0));
    		comingFrom.removeCard(0);
    }
    

}

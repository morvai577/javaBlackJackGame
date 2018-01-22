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
    
    // Return size of deck
    public int deckSize() {
    		return this.cardsValue();
    }
    
    // Return total value of cards in deck
    public int cardsValue() {
    		int totalValue = 0;
    		int aces = 0;
    		
    		for (Card aCard : this.cards) {
    			switch(aCard.getValue()) {
    				
    			case TWO: totalValue += 2; break;
    			case THREE: totalValue += 3; break;
    			case FOUR: totalValue += 4; break;
    			case FIVE: totalValue += 5; break;
    			case SIX: totalValue += 6; break;
    			case SEVEN: totalValue += 7; break;
    			case EIGHT: totalValue += 8; break;
    			case NINE: totalValue += 9; break;
    			case TEN: totalValue += 10; break;
    			case JACK: totalValue += 10; break;
    			case QUEEN: totalValue += 10; break;
    			case KING: totalValue += 10; break;
    			case ACE: aces += 1; break;
    			
    			}
    		}
    		
    		for (int i = 0; i < aces; i++) {
    			
    			if (totalValue > 10) {
    				totalValue += 1;
    			}
    			else {
    				totalValue += 11;
    			}
    		}
    		
    		return totalValue;
    }
    
}

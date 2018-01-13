/**
 * 
 */
package javaBlackJackGame;

import java.util.ArrayList;


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

    public String toString() {
        String cardListOutput = "";
        int i = 0;
        for (Card aCard : this.cards) {
            cardListOutput += "\n" + i + "-" + aCard.toString();
            i++;
        }

        return cardListOutput;
    }

}

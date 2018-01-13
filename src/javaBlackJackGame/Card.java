/**
 * 
 */
package javaBlackJackGame;

/**
 * @author vai
 *
 */
public class Card {
	
	private Suit suit; // Reference to Suit enum
    private Value value; // Reference to Value enum

    // Constructor
    public Card(Suit suit, Value value) {

        this.value = value;
        this.suit = suit;
    }

    public String toString() {

        return this.suit.toString() + "-" + this.value.toString();
    }

    public Value getValue() {
        return value;
    }

}
